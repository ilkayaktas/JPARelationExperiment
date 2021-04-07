package com.ilkayaktas.jparelationexperiment.manytoone;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ilkayaktas on 7.04.2021 at 08:49.
 */

public interface UserTestRepository extends CrudRepository<User, Long> {
}
