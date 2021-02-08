package com.co.personalsoft.examenreactive.repositorys;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.co.personalsoft.examenreactive.models.Category;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {

}
