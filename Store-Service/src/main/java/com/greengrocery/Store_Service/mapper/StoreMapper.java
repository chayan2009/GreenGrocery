package net.learnvector.store_service.mapper;

import net.learnvector.store_service.dto.StoreDTO;
import net.learnvector.store_service.entity.Store;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    StoreDTO toDTO(Store store);
    Store toEntity(StoreDTO storeDTO);
    List<StoreDTO> toDTOs(List<Store> stores);
}

