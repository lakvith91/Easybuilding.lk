package com.lakshan.repository;

import com.lakshan.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by LakshanD on 11/25/2016.
 */
public interface AdvertisementRepository extends JpaRepository<Advertisement,Integer> {
}
