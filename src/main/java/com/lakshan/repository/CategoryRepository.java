package com.lakshan.repository;

import com.lakshan.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by LakshanD on 11/6/2016.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
