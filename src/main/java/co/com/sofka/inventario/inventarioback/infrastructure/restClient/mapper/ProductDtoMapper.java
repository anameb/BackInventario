package co.com.sofka.inventario.inventarioback.infrastructure.restClient.mapper;

import co.com.sofka.inventario.inventarioback.domain.models.Products;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.ProductsColletion;
import co.com.sofka.inventario.inventarioback.infrastructure.restClient.dto.ProductsDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDtoMapper {

    public Products ProductDtoToproducts(ProductsDto productsDto){
        return Products.builder()
                .id(productsDto.getId())
                .name(productsDto.getName())
                .inInventory(productsDto.getInInventory())
                .enabled(productsDto.getEnabled())
                .min(productsDto.getMin())
                .max(productsDto.getMax())
                .build();
    }

    public ProductsDto productsToProductDto(Products products){
        return ProductsDto.builder()
                .id(products.getId())
                .name(products.getName())
                .inInventory(products.getInInventory())
                .enabled(products.getEnabled())
                .min(products.getMin())
                .max(products.getMax())
                .build();
    }

    public List<Products>productListDtoToProductList(List<ProductsDto>productsDtoList) {
        List<Products>productsList= new ArrayList<>();
        for (ProductsDto
                product:productsDtoList){
            productsList.add(ProductDtoToproducts(product));
        }
        return productsList;
    }

    public List<ProductsDto>ProductListToproductListDto(List<Products>productsList) {
        List<ProductsDto>productsDtoList= new ArrayList<>();
        for (Products
                productsDto:productsList){
            productsDtoList.add(productsToProductDto(productsDto));
        }
        return productsDtoList;
    }
}
