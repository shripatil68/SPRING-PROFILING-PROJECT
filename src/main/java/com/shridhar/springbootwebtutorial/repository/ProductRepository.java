package com.shridhar.springbootwebtutorial.repository;

import com.shridhar.springbootwebtutorial.entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findBy(Sort by);

//    List<ProductEntity> findByTitleOrderByPrice();
}
