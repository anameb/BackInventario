package co.com.sofka.inventario.inventarioback.infrastructure.persistence.repostory;

import co.com.sofka.inventario.inventarioback.domain.models.Buy;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.BuyColletion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuysRepository  extends MongoRepository<BuyColletion,String> {
}
