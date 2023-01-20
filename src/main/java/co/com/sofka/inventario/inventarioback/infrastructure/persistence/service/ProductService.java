package co.com.sofka.inventario.inventarioback.infrastructure.persistence.service;

import co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.ProductsColletion;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.repostory.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductsRepository productsRepository;

    public ProductsColletion saveProduct(ProductsColletion productsColletion) {
        return productsRepository.save(productsColletion);
    }
    public List<ProductsColletion> getAllProduct(){
        return productsRepository.findAll();
    }
    public ProductsColletion updateProduct(ProductsColletion productsColletion){
        if (productsColletion.getId().isEmpty())
            //Error, no puede modificar
            return null;
        return productsRepository.save(productsColletion);
    }

    public ProductsColletion getProductById(String id){
        return productsRepository.findById(id).orElse(null);
    }
    public boolean deleteProduct(String id) {
        Optional<ProductsColletion> product = productsRepository.findById(id);
        if (product.isEmpty()){
            return false;
        }
        productsRepository.deleteById(id);
        return true;
    }

    public ProductsColletion findById(String id) {
        return productsRepository.findById(id).orElse(null);
    }
}
