package edu.ben.cmsc3330;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Slf4j
@SpringBootApplication
public class Cmsc3330Application implements CommandLineRunner {

//    private final ProductRepository productRepository;
//    private final ProductTypeRepository productTypeRepository;
//    private final ProductService productService;
//    private final OrderRepository orderRepository;

    private Scanner input = new Scanner(System.in);


//    public Cmsc3330Application( ProductRepository productRepository,
//                               ProductTypeRepository productTypeRepository, ProductService productService, OrderRepository orderRepository) {
//        this.productRepository = productRepository;
//        this.productTypeRepository = productTypeRepository;
//
//        this.productService = productService;
//        this.orderRepository = orderRepository;
//    }

    /**
     * Starts the spring application
     *
     * @param args unused
     * @throws FileNotFoundException
     * @throws SQLException
     */
    public static void main(String[] args) throws FileNotFoundException, SQLException {

        SpringApplication.run(Cmsc3330Application.class, args);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("Running Application...");

//        File categoryFile = new File("src/categories.csv");
//        File distinctItemSortedFile = new File("src/distinct_items_sorted.csv");
//        insertProductData(categoryFile);
//        insertProductTypeData(distinctItemSortedFile);
//
//        displayMenu();
    }
}


