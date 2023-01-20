package co.com.sofka.inventario.inventarioback.application.mapper;

import co.com.sofka.inventario.inventarioback.domain.models.Products;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.ProductsColletion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {

    public Products productCollectionToProduct(ProductsColletion productsColletion){
        return Products.builder()
                .id(productsColletion.getId())
                .name(productsColletion.getName())
                .inInventory(productsColletion.getInInventory())
                .enabled(productsColletion.getEnabled())
                .min(productsColletion.getMin())
                .max(productsColletion.getMax())
                .build();
    }

    public ProductsColletion productToProductCollection(Products products){
        return ProductsColletion.builder()
                .id(products.getId())
                .name(products.getName())
                .inInventory(products.getInInventory())
                .enabled(products.getEnabled())
                .min(products.getMin())
                .max(products.getMax())
                .build();
    }

    public List<Products> productListColletionToProductList(List<ProductsColletion>productListCollection){
        List<Products>productsList= new ArrayList<>();
        for (ProductsColletion
                product:productListCollection){
            productsList.add(productCollectionToProduct(product));
        }
        return productsList;
    }
    public List<ProductsColletion>buyListToBuyListCollection(List<Products>productsList) {
        List<ProductsColletion> productListCollection = new ArrayList<>();
        for (Products
                productCollection:productsList) {
            productListCollection.add(productToProductCollection(productCollection));
        }
        return productListCollection;
    }
}
