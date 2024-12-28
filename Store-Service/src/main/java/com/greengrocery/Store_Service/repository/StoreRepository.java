package com.greengrocery.Store_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greengrocery.Store_Service.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
    
}

