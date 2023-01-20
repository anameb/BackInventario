package co.com.sofka.inventario.inventarioback.infrastructure.restClient.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ProductsDto {
    private String id;
    private String name;
    private Integer inInventory;
    private Boolean enabled;
    private Integer min;
    private Integer max;
}
