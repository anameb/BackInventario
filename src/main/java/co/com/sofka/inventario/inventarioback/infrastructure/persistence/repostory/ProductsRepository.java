package co.com.sofka.inventario.inventarioback.infrastructure.persistence.repostory;

import co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.ProductsColletion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<ProductsColletion,String> {
}
