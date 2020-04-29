package edu.ben.cmsc3330;

import edu.ben.cmsc3330.data.model.*;
import edu.ben.cmsc3330.data.repository.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;

@Slf4j
@SpringBootApplication
public class Cmsc3330Application  {


//    public static ProcessData dataProcessor;

    /**
     * All Object repositories
     */
    private final AddressRepository addressRepository;
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final RegistrationRepository registrationRepository;
    private final SectionRepository sectionRepository;
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final CourseGradeRepository courseGradeRepository;


    /**
     * All object Hashmaps used for data import
     */
    public static HashMap<String, Student> people = new HashMap<String, Student>();
    public static HashMap<String, Instructor> instructors = new HashMap<String, Instructor>();
    public static HashMap<String, Course> courses = new HashMap<String, Course>();
    public static HashMap<String, CourseGrade> grades = new HashMap<String, CourseGrade>();
    public static HashMap<String, Section> sections = new HashMap<String, Section>();

    /**
     * ArrayLists to remove duplicate data
     */
    public static ArrayList<String> removeNames = new ArrayList<String>();
    public static ArrayList<String> removeInstructors = new ArrayList<String>();
    public static ArrayList<String> removeCourses = new ArrayList<String>();
    public static ArrayList<String> removeGrades = new ArrayList<String>();
    public static ArrayList<String> removeSections = new ArrayList<String>();

    /**
     * Class Repository Constructor
     * @param addressRepository Address repository
     * @param courseRepository Course repository
     * @param instructorRepository Instructor repository
     * @param registrationRepository Registration repository
     * @param sectionRepository Section repository
     * @param studentRepository Student repository
     * @param userRepository User repository
     * @param courseGradeRepository Course Grade Repository
     */
    public Cmsc3330Application(AddressRepository addressRepository,
       CourseRepository courseRepository,
       InstructorRepository instructorRepository, RegistrationRepository registrationRepository,
       SectionRepository sectionRepository, StudentRepository studentRepository,
       UserRepository userRepository, CourseGradeRepository courseGradeRepository) {
        this.addressRepository = addressRepository;
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.registrationRepository = registrationRepository;
        this.sectionRepository = sectionRepository;
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.courseGradeRepository = courseGradeRepository;
    }

    /**
     * Main method to run backend application
     * @param args argument
     * @throws SQLException SQL exception
     * @throws FileNotFoundException File not found
     */
    public static void main(String[] args) throws SQLException, FileNotFoundException {

       SpringApplication.run(Cmsc3330Application.class, args);

    }


    /**
     * Old Java import method, used to check entry values
     *
     * @param students student hashmap
     * @throws SQLException sql exception
     */
    public static void studentImport(HashMap<String, Student> students) throws SQLException {
        for (Map.Entry<String, Student> entry : students.entrySet()) {
            String sql = "INSERT INTO student " + "VALUES (";
            String part = entry.getValue().toString();
            sql += part;
            System.out.println(sql);
        }
    }

    /**
     * Old Instructor import, used as check
     * @param teachers teacher hashmap
     * @throws SQLException sql exception
     */
    public static void instructorImport(HashMap<String, Instructor> teachers) throws SQLException {
        for (Map.Entry<String, Instructor> entry : teachers.entrySet()) {
            String sql = "INSERT INTO instructor " + "VALUES (";
            String part = entry.getValue().toString();
            sql += part;
            System.out.println(sql);

        }
    }

    /**
     * Old course import, used as check
     * @param c course hashmap
     * @throws SQLException sql exception
     */
    public static void courseImport(HashMap<String, Course> c) throws SQLException {
        for (Map.Entry<String, Course> entry : c.entrySet()) {
            String sql = "INSERT INTO course " + "VALUES (";
            String part = entry.getValue().toString();
            sql += part;
            System.out.println(sql);
        }
    }

    /**
     * Old grade import, used as check
     * @param c grade hashmap
     * @throws SQLException sql exception
     */
    public static void gradeImport(HashMap<String, CourseGrade> c) throws SQLException {
        for (Map.Entry<String, CourseGrade> entry : c.entrySet()) {
            String sql = "INSERT INTO course_grade " + "VALUES (";
            String part = entry.getValue().toString();
            sql += part;
            System.out.println(sql);
        }
    }

    /**
     * Old section import, used as check
     * @param c section hashmap
     * @throws SQLException sql exception
     */
    public static void sectionImport(HashMap<String, Section> c) throws SQLException {
        for (Map.Entry<String, Section> entry : c.entrySet()) {
            String sql = "INSERT INTO section " + "VALUES (";
            String part = entry.getValue().toString();
            sql += part;
            System.out.println(sql);
        }
    }

    /**
     * Command line runner
     * @return data processed
     */
    @Bean
    public CommandLineRunner process(){
        return (args) ->
                processdata();
    }

    /**
     * Method to process and store data into sql database
     * @throws SQLException sql exception
     * @throws FileNotFoundException file not found
     */
    private void processdata() throws SQLException, FileNotFoundException {

        File csvFile = new File("src/Lab 5 Student.csv");
        File instructorFile = new File("src/Lab 5 Instructor.csv");
        File courseFile = new File("src/Lab 5 Course.csv");
        File gradeFile = new File("src/Lab 5 Course Grades.csv");
        File sectionFile = new File("src/Lab 5 Section.csv");

        studentFileReader(csvFile);
        instructorFileReader(instructorFile);
        courseFileReader(courseFile);
        sectionFileReader(sectionFile);
        gradeFileReader(gradeFile);

//        DBConnector db = new DBConnector();
//        line = db.getConnection().createStatement();
//
//        // Check if entry already in table
//        studentDuplicates(line);
//        instructorDuplicates(line);
//        courseDuplicates(line);
//        gradeDuplicates(line);
//        sectionDuplicates(line);

        // Remove from Map if entry in table
        for (String s : removeNames) {
            if (people.containsKey(s)) {
                people.remove(s);
            }
        }

        for (String s : removeInstructors) {
            if (instructors.containsKey(s)) {
                instructors.remove(s);
            }
        }

        for (String s : removeCourses) {
            if (courses.containsKey(s)) {
                courses.remove(s);
            }
        }

        for (String s : removeGrades) {
            if (grades.containsKey(s)) {
                grades.remove(s);
            }
        }

        for (String s : removeSections) {
            if (sections.containsKey(s)) {
                sections.remove(s);
            }
        }

        studentImport(people);
        instructorImport(instructors);
        courseImport(courses);
        sectionImport(sections);
        gradeImport(grades);
    }


    /**
     * Read CSV file and extract student data
     *
     * @param csvFile student file
     * @throws FileNotFoundException File not found
     */
    public void studentFileReader(File csvFile) throws FileNotFoundException {
        Scanner fileInput = new Scanner(csvFile);
        // Skip 1st line
        fileInput.nextLine();
        // Store Student data
        while (fileInput.hasNext()) {
            String words = fileInput.nextLine().replace("'", "");
            String[] row = words.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            storePerson(row);
        }

        fileInput.close();

    }

    /**
     * Read CSV File to extract instructor data
     * @param csvFile instructor file
     * @throws FileNotFoundException File not found
     */
    public void instructorFileReader(File csvFile) throws FileNotFoundException {
        Scanner fileInput = new Scanner(csvFile);
        // Skip 1st line
        fileInput.nextLine();
        // Store Student data
        while (fileInput.hasNext()) {
            String words = fileInput.nextLine().replace("'", "");
            String[] row = words.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            storeInstructor(row);
        }

        fileInput.close();

    }

    /**
     * Read CSV File tp extract course data
     * @param csvFile course file
     * @throws FileNotFoundException File not found
     */
    public void courseFileReader(File csvFile) throws FileNotFoundException {
        Scanner fileInput = new Scanner(csvFile);
        // Skip 1st line
        fileInput.nextLine();
        // Store Student data
        while (fileInput.hasNext()) {
            String words = fileInput.nextLine().replace("'", "");
            String[] row = words.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            storeCourse(row);
        }

        fileInput.close();

    }

    /**
     * Read CSV file to extract course grade data
     * @param csvFile courseGrade file
     * @throws FileNotFoundException File not found
     */
    public void gradeFileReader(File csvFile) throws FileNotFoundException {
        Scanner fileInput = new Scanner(csvFile);
        // Skip 1st line
        fileInput.nextLine();
        // Store Student data
        while (fileInput.hasNext()) {
            String words = fileInput.nextLine().replace("'", "");
            String[] row = words.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            storeGrade(row);
        }

        fileInput.close();

    }

    /**
     * Read CSV file to extract section data
     * @param csvFile section file
     * @throws FileNotFoundException File not found
     */
    public void sectionFileReader(File csvFile) throws FileNotFoundException {
        Scanner fileInput = new Scanner(csvFile);
        // Skip 1st line
        fileInput.nextLine();
        // Store Student data
        while (fileInput.hasNext()) {
            String words = fileInput.nextLine().replace("'", "");
            String[] row = words.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            storeSection(row);
        }

        fileInput.close();

    }

    /**
     * Creates student object and adds to student repository
     *
     * @param row Data from file
     */
    public void storePerson(String[] row) {
        Student p = new Student();
        p.setId(Integer.parseInt(row[0]));
        p.setStudentFirstName(row[1]);
        p.setStudentLastName(row[2]);
        p.setStudentMiddleName(row[3]);
        p.setSsn(row[4]);
        p.setDob(row[5]);
        p.setStudentEmail(row[6]);
        if (!people.containsKey(row[0])) {
            people.put(row[0], p);
            studentRepository.save(p);
        }
        System.out.println(p.toString());
//        studentRepository.save(p);
        System.out.println("saved");
    }

    /**
     * Creates instructor object and adds to instructor repository
     * @param row data
     */
    public void storeInstructor(String[] row) {
        Instructor p = new Instructor(Integer.parseInt(row[0]), row[1], row[2], row[3], row[4]);
        if (!instructors.containsKey(row[0])) {
            instructors.put(row[0], p);
            instructorRepository.save(p);
        }
        System.out.println(p.toString());
    }

    /**
     * Creates course object and adds to course repository
     * @param row course data
     */
    public void storeCourse(String[] row) {
        Course p = new Course();
        p.setCourseId(Integer.parseInt(row[0]));
        p.setCourseName(row[1]);
        p.setUnits(Integer.parseInt(row[2]));
        p.setCourseSubject(row[3]);

        if (!courses.containsKey(row[0])) {
            courses.put(row[0], p);
            courseRepository.save(p);
        }
        System.out.println(p.toString());
    }

    /**
     * Creates courseGrade object and stores into repository
     * @param row courseGrade data
     */
    public void storeGrade(String[] row) {
        CourseGrade p = new CourseGrade(Integer.parseInt(row[0]), Integer.parseInt(row[1]), Integer.parseInt(row[2]), row[3]);
        if (!grades.containsKey(row[0])) {
            grades.put(row[0], p);
            courseGradeRepository.save(p);
        }
        System.out.println(p.toString());
    }

    /**
     * Creates section object and stores into section repository
     * @param row section data
     */
    public void storeSection(String[] row) {
        boolean check = Boolean.parseBoolean(row[2]);
        int value = 0;
        if (check) {
            value = 1;
        }
        Section p = new Section();
        p.setSectionNo(Integer.parseInt(row[0]));
        p.setSemester(row[1]);
        p.setStatus(Boolean.parseBoolean(row[2]));
        p.setRoomNo(row[3]);
        p.setDayAndTime(row[4]);
        p.setCourseId(Integer.parseInt(row[5]));
        if (!sections.containsKey(row[0])) {
            sections.put(row[0], p);
            sectionRepository.save(p);
        }
        System.out.println(p.toString());
    }
    

//    public static void studentDuplicates(line) throws SQLException {
//        for (Map.Entry<String, Student> entry : people.entrySet()) {
//            String sql = "SELECT * FROM student where id = '" + entry.getKey() + "'";
//            ResultSet rs = line.executeQuery(sql);
//            if (rs.next()) {
//                removeNames.add(entry.getKey());
//            }
//        }
//    }
//
//    public static void instructorDuplicates(line) throws SQLException {
//        for (Map.Entry<String, Instructor> entry : instructors.entrySet()) {
//            String sql = "SELECT * FROM instructor where instructor_id = '" + entry.getKey() + "'";
//            ResultSet rs = line.executeQuery(sql);
//            if (rs.next()) {
//                removeInstructors.add(entry.getKey());
//            }
//        }
//    }
//
//    public static void courseDuplicates(line) throws SQLException {
//        for (Map.Entry<String, Course> entry : courses.entrySet()) {
//            String sql = "SELECT * FROM course where course_id = '" + entry.getKey() + "'";
//            ResultSet rs = line.executeQuery(sql);
//            if (rs.next()) {
//                removeCourses.add(entry.getKey());
//            }
//        }
//    }
//
//    public static void gradeDuplicates(line) throws SQLException {
//        for (Map.Entry<String, CourseGrade> entry : grades.entrySet()) {
//            String sql = "SELECT * FROM course_grade where course_grade_id = '" + entry.getKey() + "'";
//            ResultSet rs = line.executeQuery(sql);
//            if (rs.next()) {
//                removeGrades.add(entry.getKey());
//            }
//        }
//    }
//
//    public static void sectionDuplicates(line) throws SQLException {
//        for (Map.Entry<String, Section> entry : sections.entrySet()) {
//            String sql = "SELECT * FROM section where section_no = '" + entry.getKey() + "'";
//            ResultSet rs = line.executeQuery(sql);
//            if (rs.next()) {
//                removeSections.add(entry.getKey());
//            }
//        }
//    }


    }




