package co.com.sofka.inventario.inventarioback.infrastructure.restClient.dto;

import co.com.sofka.inventario.inventarioback.domain.models.SoldProducts;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class BuyDto {

    private String date;
    private String idType;
    private Integer id;
    private String clientName;
    private List<SoldProducts> products;

}
