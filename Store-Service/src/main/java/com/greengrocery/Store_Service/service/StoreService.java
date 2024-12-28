package com.greengrocery.Store_Service.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.greengrocery.Store_Service.dto.StoreDTO;
import com.greengrocery.Store_Service.entity.Store;
import com.greengrocery.Store_Service.repository.StoreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {

    private final StoreRepository storeRepository;
    private final ModelMapper modelMapper;

    public StoreService(StoreRepository storeRepository, ModelMapper modelMapper) {
        this.storeRepository = storeRepository;
        this.modelMapper = modelMapper;
    }

    public StoreDTO createStore(StoreDTO storeDTO) {
        Store store = modelMapper.map(storeDTO, Store.class);
        Store savedStore = storeRepository.save(store);
        return modelMapper.map(savedStore, StoreDTO.class);
    }

    public List<StoreDTO> getAllStores() {
        List<Store> stores = storeRepository.findAll();
        return stores.stream()
                .map(store -> modelMapper.map(store, StoreDTO.class))
                .collect(Collectors.toList());
    }

    public StoreDTO getStoreById(Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));
        return modelMapper.map(store, StoreDTO.class);
    }

    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}

