package co.com.sofka.inventario.inventarioback.application.usecases;

import co.com.sofka.inventario.inventarioback.application.mapper.ProductMapper;
import co.com.sofka.inventario.inventarioback.domain.models.Products;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductsUseCase {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public Products addProduct(Products products){
        return productMapper.productCollectionToProduct(productService.saveProduct(productMapper.productToProductCollection(products)));
    }

    public Products updateProduct(Products products){
        return productMapper.productCollectionToProduct(productService.updateProduct(productMapper.productToProductCollection(products)));
    }

    public boolean deleteProduct(String id){
        return productService.deleteProduct(id);
    }

    public List<Products> getAllProducts(){
        return productMapper.productListColletionToProductList(productService.getAllProduct());

    }

    public Products getProductById(String id){
        return productMapper.productCollectionToProduct(productService.getProductById(id));
    }
}
