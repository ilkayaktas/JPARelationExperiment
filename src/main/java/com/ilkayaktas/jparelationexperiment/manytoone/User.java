package com.ilkayaktas.jparelationexperiment.manytoone;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ilkayaktas on 7.04.2021 at 08:00.
 */
@Entity
@Table(name = "usertest")
public class User {
    @Id
    @SequenceGenerator(name="jpaPkSeq", sequenceName="JPA_PK_SEQ", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaPkSeq")
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String name;
}
