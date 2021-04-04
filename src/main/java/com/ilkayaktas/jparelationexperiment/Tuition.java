package com.ilkayaktas.jparelationexperiment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ilkayaktas on 2.04.2021 at 15:04.
 */

@Entity
@Table(name = "tuition")
public class Tuition {

    @Id
    @SequenceGenerator(name="jpaPkSeq", sequenceName="JPA_PK_SEQ", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaPkSeq")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Double fee;

    //what column in Tuition table has the FK
    @JoinColumn(name = "student_id")
    @OneToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    private Student student;

    /* Getters and setters */
}