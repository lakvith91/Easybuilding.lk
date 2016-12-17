package com.lakshan.repository;

import com.lakshan.model.StdPrice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LakshanD on 11/26/2016.
 */
public interface PriceRepository extends JpaRepository<StdPrice,Integer> {
}
