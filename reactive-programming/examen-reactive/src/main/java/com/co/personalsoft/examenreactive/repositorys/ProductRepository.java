package com.co.personalsoft.examenreactive.repositorys;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.co.personalsoft.examenreactive.models.Product;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long>{

}
