package com.petland.petlandapi.model.product.usecases;

import com.petland.petlandapi.model.product.dto.ProductResponseDTO;
import com.petland.petlandapi.model.product.entity.ProductEntity;
import com.petland.petlandapi.model.product.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListAllProductsUseCase {
    private final ProductRepository productRepository;
    public ListAllProductsUseCase(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public List<ProductResponseDTO> execute() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<> ();
        for (ProductEntity productEntity : productEntities) {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO(
                    productEntity.getId(),
                    productEntity.getName(),
                    productEntity.getValue(),
                    productEntity.isService()
            );
            BeanUtils.copyProperties(productEntity, productResponseDTO);
            productResponseDTOS.add(productResponseDTO);
        }
        return productResponseDTOS;
    }
}
