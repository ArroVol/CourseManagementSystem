package edu.ben.cmsc3330.web.model;

import edu.ben.cmsc3330.data.model.Address;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserView {

    private int userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private int studentId;

//    private Address address;
}
