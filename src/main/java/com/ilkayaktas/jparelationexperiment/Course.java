package com.ilkayaktas.jparelationexperiment;

/**
 * Created by ilkayaktas on 3.04.2021 at 23:29.
 */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @SequenceGenerator(name="jpaPkSeq", sequenceName="JPA_PK_SEQ", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaPkSeq")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @ManyToMany(mappedBy = "courses")
    @Getter
    @Setter
    private Set<Student> students;
}
