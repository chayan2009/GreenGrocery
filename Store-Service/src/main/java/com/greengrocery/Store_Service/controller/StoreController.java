package com.greengrocery.Store_Service.controller;

import com.greengrocery.Store_Service.dto.StoreDTO;
import com.greengrocery.Store_Service.service.impl.StoreServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreServiceImpl storeService;

    public StoreController(StoreServiceImpl storeService) {
        this.storeService = storeService;
    }

    @Operation(summary = "Create a new store", description = "This endpoint allows you to create a new store.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Store created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO storeDTO) {
        StoreDTO createdStore = storeService.addStore(storeDTO);
        return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve all stores", description = "This endpoint retrieves a list of all stores.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of stores")
    })
    @GetMapping
    public ResponseEntity<List<StoreDTO>> getAllStores() {
        List<StoreDTO> stores = storeService.getAllStores();
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @Operation(summary = "Retrieve a store by ID", description = "This endpoint retrieves a specific store by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Store retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Store not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable Long id) {
        StoreDTO store = storeService.getStoreById(id);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    @Operation(summary = "Delete a store", description = "This endpoint deletes a specific store by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Store deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Store not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return new ResponseEntity<>("Store deleted successfully", HttpStatus.NO_CONTENT);
    }
}
