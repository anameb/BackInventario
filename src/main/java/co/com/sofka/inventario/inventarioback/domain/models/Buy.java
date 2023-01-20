package co.com.sofka.inventario.inventarioback.domain.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Buy {

    private String date;
    private String idType;
    private Integer id;
    private String clientName;
    private List<SoldProducts> products;

}
