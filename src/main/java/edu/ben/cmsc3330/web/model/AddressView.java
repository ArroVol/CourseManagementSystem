package edu.ben.cmsc3330.web.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AddressView {

    private int id;

    private String street;

    private String city;

    private String state;

    private String postalCode;

    private int studentId;
}
