package com.ilkayaktas.jparelationexperiment;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ilkayaktas on 3.04.2021 at 23:06.
 */

public interface StaffRepository extends CrudRepository<Staff, Long> {
}
