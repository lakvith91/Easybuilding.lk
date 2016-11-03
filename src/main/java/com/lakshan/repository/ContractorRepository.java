package com.lakshan.repository;

import com.lakshan.model.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LakshanD on 10/31/2016.
 */
@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Integer> {
}
