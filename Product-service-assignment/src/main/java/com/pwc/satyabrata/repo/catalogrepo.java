package com.pwc.satyabrata.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pwc.satyabrata.model.catalog;

@Repository
public interface catalogrepo extends JpaRepository<catalog, Integer> {
	Optional<catalog>  findByCategoryName(String catalogName);

}
