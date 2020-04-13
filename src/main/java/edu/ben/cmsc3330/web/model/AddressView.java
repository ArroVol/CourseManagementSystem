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

    private String street;

    private String street2;

    private String street3;

    private String city;

    private String state;

    private String postalCode;
}
