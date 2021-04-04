package com.ilkayaktas.jparelationexperiment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ilkayaktas on 3.04.2021 at 22:43.
 */
@Entity
@Table(name = "university")
public class University {
    @Id
    @SequenceGenerator(name="jpaPkSeq", sequenceName="JPA_PK_SEQ", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaPkSeq")
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    // bidirectional
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter
    @Setter
    private List<Student> students;

    // unidirectional. Additional update methods are invoked.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "university_id")
    @Getter
    @Setter
    private List<Staff> staff;
}
