package com.ilkayaktas.jparelationexperiment;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ilkayaktas on 3.04.2021 at 22:13.
 */

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByName(String name);
}
