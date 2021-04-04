package com.ilkayaktas.jparelationexperiment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ilkayaktas on 2.04.2021 at 15:04.
 */

@Entity
@Table(name = "student")
public class Student {

    @Id
    @SequenceGenerator(name="jpaPkSeq", sequenceName="JPA_PK_SEQ", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaPkSeq")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch= FetchType.LAZY)
    @Getter
    @Setter
    private Tuition tuition;

    // bidirectional
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "university_id")
    @Getter
    @Setter
    private University university;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "student_course",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    @Getter
    @Setter
    private Set<Course> courses;
}