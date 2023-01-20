package co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder(toBuilder = true)
@Document(collection = "buys")
public class BuyColletion {

    @Id
    private String idBuy;
    private String date;
    private String idType;
    private Integer idClient;
    private String clientName;
    private List<SoldProducts> products;

}
