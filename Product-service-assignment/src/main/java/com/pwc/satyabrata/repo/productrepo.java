package com.pwc.satyabrata.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pwc.satyabrata.model.product;
@Repository
public interface productrepo extends JpaRepository<product, Integer>{
		Optional<product> findByProductName(String productName);
}
