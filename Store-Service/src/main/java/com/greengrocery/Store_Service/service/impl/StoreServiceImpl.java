package com.greengrocery.Store_Service.service.impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.hibernate.StaleObjectStateException;
import lombok.AllArgsConstructor;
import com.greengrocery.Store_Service.dto.StoreDTO;
import com.greengrocery.Store_Service.entity.Store;
import com.greengrocery.Store_Service.repository.StoreRepository;
import com.greengrocery.Store_Service.service.mapper.StoreService;
import com.greengrocery.Store_Service.utils.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final ModelMapper modelMapper;
    private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Override
    public StoreDTO addStore(StoreDTO storeDTO) {
        try {
            // Map DTO to Entity
            Store store = modelMapper.map(storeDTO, Store.class);
            // Save store to the database
            Store savedStore = storeRepository.save(store);
            // Log the saved store details
            logger.debug("Saved store: {}", savedStore);
            // Map saved store entity back to DTO and return
            return modelMapper.map(savedStore, StoreDTO.class);
        } catch (StaleObjectStateException e) {
            logger.error("Optimistic lock failure - the store was modified or deleted by another transaction", e);
            throw new RuntimeException("Store update failed due to concurrency conflict", e);
        }
    }

    @Override
    public StoreDTO getStoreById(Long id) {
        // Fetch store by ID and map to DTO
        Store store = storeRepository.findById(id).orElse(null);
        if (store != null) {
            return modelMapper.map(store, StoreDTO.class);
        }
        return null; // Alternatively, you can throw an exception if needed
    }

    @Override
    public List<StoreDTO> getAllStores() {
        // Fetch all stores and map each to DTO
        List<Store> stores = storeRepository.findAll();
        return stores.stream()
                      .map(store -> modelMapper.map(store, StoreDTO.class))
                      .collect(Collectors.toList());
    }

    @Override
    public void deleteStore(Long id) {
        // Find the store by ID
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found with id: " + id));
        // Delete the store
        storeRepository.delete(store);
    }

    @Override
    public StoreDTO updateStore(Long id, StoreDTO storeDTO) {
        // Find the store by ID
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found with id: " + id));
        
        // Map the updated DTO fields to the existing store entity
        modelMapper.map(storeDTO, store);
        // Save the updated store entity
        Store updatedStore = storeRepository.save(store);
        // Return the updated store as DTO
        return modelMapper.map(updatedStore, StoreDTO.class);
    }

    @Override
    public StoreDTO markStoreAsActive(Long id) {
        // Find the store by ID
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found with id: " + id));
        
        // Mark the store as active
        store.setActive(true);
        // Save the updated store entity
        Store updatedStore = storeRepository.save(store);
        // Return the updated store as DTO
        return modelMapper.map(updatedStore, StoreDTO.class);
    }

    @Override
    public StoreDTO markStoreAsInactive(Long id) {
        // Find the store by ID
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found with id: " + id));
        
        // Mark the store as inactive
        store.setActive(false);
        // Save the updated store entity
        Store updatedStore = storeRepository.save(store);
        // Return the updated store as DTO
        return modelMapper.map(updatedStore, StoreDTO.class);
    }
}
