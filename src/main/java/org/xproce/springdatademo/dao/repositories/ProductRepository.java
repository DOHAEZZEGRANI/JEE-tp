package org.xproce.springdatademo.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.springdatademo.dao.entities.product;

public interface ProductRepository extends JpaRepository<product, Integer> {
}
