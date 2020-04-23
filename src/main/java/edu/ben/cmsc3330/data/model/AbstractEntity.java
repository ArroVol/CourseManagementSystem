package edu.ben.cmsc3330.data.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@MappedSuperclass
@SuperBuilder
public class AbstractEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "created_on")
    private String created;

    @Column(name = "updated_on")
    private String updated;
}
