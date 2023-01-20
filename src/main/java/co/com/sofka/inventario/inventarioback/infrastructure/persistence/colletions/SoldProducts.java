package co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class SoldProducts {
    private String idProduct;
    private Integer quantity;
}
