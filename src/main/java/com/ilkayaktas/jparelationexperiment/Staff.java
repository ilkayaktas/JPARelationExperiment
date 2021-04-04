package com.ilkayaktas.jparelationexperiment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by ilkayaktas on 3.04.2021 at 23:04.
 */

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @SequenceGenerator(name="jpaPkSeq", sequenceName="JPA_PK_SEQ", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaPkSeq")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;
}
