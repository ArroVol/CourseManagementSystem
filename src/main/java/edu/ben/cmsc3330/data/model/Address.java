package edu.ben.cmsc3330.data.model;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "address")
public class Address extends AbstractEntity {

    @NotNull
    @Column(name = "street")
    private String street;

    @Column(name = "street2")
    private String street2;

    @Column(name = "street3")
    private String street3;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @NotNull
    @Column(name = "postal_code")
    private String postalCode;

}
