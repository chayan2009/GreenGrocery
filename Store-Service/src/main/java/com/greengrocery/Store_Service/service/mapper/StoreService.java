package com.greengrocery.Store_Service.service.mapper;

import com.greengrocery.Store_Service.dto.StoreDTO;

import java.util.List;

public interface StoreService {

    StoreDTO addStore(StoreDTO storeDTO);

    StoreDTO getStoreById(Long id);

    List<StoreDTO> getAllStores();

    void deleteStore(Long id);

    StoreDTO updateStore(Long id, StoreDTO storeDTO);

    StoreDTO markStoreAsActive(Long id);

    StoreDTO markStoreAsInactive(Long id);
}

