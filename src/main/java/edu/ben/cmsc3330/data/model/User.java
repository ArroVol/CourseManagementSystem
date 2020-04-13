package edu.ben.cmsc3330.data.model;

import com.sun.istack.NotNull;

import javax.persistence.Column;

public class User extends AbstractEntity {

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "ssn")
    private String ssn;

}
