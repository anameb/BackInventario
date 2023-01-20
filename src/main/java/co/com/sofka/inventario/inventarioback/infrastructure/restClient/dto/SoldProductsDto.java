package co.com.sofka.inventario.inventarioback.infrastructure.restClient.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class SoldProductsDto {
    private String idProduct;
    private Integer quantity;
}
