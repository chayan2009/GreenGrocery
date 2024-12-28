package com.greengrocery.Store_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greengrocery.Store_Service.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}

