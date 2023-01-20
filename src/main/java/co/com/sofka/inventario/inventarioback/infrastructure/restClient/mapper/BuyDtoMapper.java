package co.com.sofka.inventario.inventarioback.infrastructure.restClient.mapper;

import co.com.sofka.inventario.inventarioback.domain.models.Buy;
import co.com.sofka.inventario.inventarioback.domain.models.Products;
import co.com.sofka.inventario.inventarioback.infrastructure.restClient.dto.BuyDto;
import co.com.sofka.inventario.inventarioback.infrastructure.restClient.dto.ProductsDto;

import java.util.ArrayList;
import java.util.List;

public class BuyDtoMapper {
    public Buy BuyDtoTobuy(BuyDto buyDto){
        return Buy.builder()
                .date(buyDto.getDate())
                .idType(buyDto.getIdType())
                .id(buyDto.getId())
                .clientName(buyDto.getClientName())
                .products(buyDto.getProducts())
                .build();
    }

    public BuyDto buyToBuyDto(Buy buy){
        return BuyDto.builder()
                .date(buy.getDate())
                .idType(buy.getIdType())
                .id(buy.getId())
                .clientName(buy.getClientName())
                .products(buy.getProducts())
                .build();
    }

    public List<Buy> buyListDtoToBuyList(List<BuyDto> buyDtoList) {
        List<Buy>buyList= new ArrayList<>();
        for (BuyDto
                buy:buyDtoList){
            buyList.add(BuyDtoTobuy(buy));
        }
        return buyList;
    }

    public List<BuyDto>buyListToBuyListDto(List<Buy> buyList) {
        List<BuyDto>buyDtoList= new ArrayList<>();
        for (Buy
                buyDto:buyList){
            buyDtoList.add(buyToBuyDto(buyDto));
        }
        return buyDtoList;
    }
}
