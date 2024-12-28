package com.greengrocery.Store_Service.dto;


import lombok.Data;

@Data
public class StoreDTO {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private boolean active;  // To reflect if the store is active or not

}
