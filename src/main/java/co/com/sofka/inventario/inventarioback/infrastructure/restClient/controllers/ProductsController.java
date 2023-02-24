package co.com.sofka.inventario.inventarioback.infrastructure.restClient.controllers;

import co.com.sofka.inventario.inventarioback.application.usecases.ProductsUseCase;
import co.com.sofka.inventario.inventarioback.domain.models.Products;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.ProductsColletion;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.service.ProductService;
import co.com.sofka.inventario.inventarioback.infrastructure.restClient.dto.ProductsDto;
import co.com.sofka.inventario.inventarioback.infrastructure.restClient.mapper.ProductDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins ="http://localhost:4200" )
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductsUseCase productsUseCase;
    private final ProductDtoMapper productDtoMapper;


    @PostMapping()
    public ProductsDto addProducts(@RequestBody ProductsDto productsDto){
        return productDtoMapper.productsToProductDto(productsUseCase.addProduct(productDtoMapper.ProductDtoToproducts(productsDto)));
    }
    @GetMapping()
    public List<ProductsDto> getAllProducts(){
        return productDtoMapper.ProductListToproductListDto(productsUseCase.getAllProducts());
    }

    @GetMapping(path = "/{id}")
    public ProductsDto getProductById(@PathVariable("id")String id){
        return productDtoMapper.productsToProductDto(productsUseCase.getProductById(id));
    }

    @PutMapping()
    public ProductsDto updateProduct(@RequestBody ProductsDto productsDto){
        return productDtoMapper.productsToProductDto(productsUseCase.updateProduct(productDtoMapper.ProductDtoToproducts(productsDto)));
    }

    @DeleteMapping(path = "/{id}")
    public String deletebyId(@PathVariable("id") String id) {
        boolean ok = this.productsUseCase.deleteProduct(id);
        if (ok) {
            return "Se eliminó el producto con id " + id;
        } else {
            return "No pudo eliminar el producto con id" + id;
        }

    }

}
