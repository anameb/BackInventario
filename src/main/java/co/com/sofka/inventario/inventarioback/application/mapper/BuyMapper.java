package co.com.sofka.inventario.inventarioback.application.mapper;

import co.com.sofka.inventario.inventarioback.domain.models.Buy;
import co.com.sofka.inventario.inventarioback.domain.models.SoldProducts;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.BuyColletion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuyMapper {

    public Buy buyCollectionToBuy(BuyColletion buyColletion){
        return Buy.builder()
                .date(buyColletion.getDate())
                .idType(buyColletion.getIdType())
                .id(buyColletion.getIdClient())
                .clientName(buyColletion.getClientName())
                .products(soldProductsListCollectionToSoldProductList(buyColletion.getProducts()))
                .build();
    }

    public List<SoldProducts> soldProductsListCollectionToSoldProductList(List<co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.SoldProducts> soldProductsListCollection){
        List<SoldProducts> soldProductsList = new ArrayList<>();
        for (co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.SoldProducts
                productsCollection:soldProductsListCollection) {
            soldProductsList.add(SoldProducts.builder()
                    .idProduct(productsCollection.getIdProduct())
                            .quantity(productsCollection.getQuantity())
                    .build());
        }
        return soldProductsList;
    }

    public BuyColletion buyToBuyCollection(Buy buy){
        return BuyColletion.builder()
                .date(buy.getDate())
                .idType(buy.getIdType())
                .idClient(buy.getId())
                .clientName(buy.getClientName())
                .products(SoldProductListTosoldProductsListCollection(buy.getProducts()))
                .build();
    }

    public List<co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.SoldProducts> SoldProductListTosoldProductsListCollection(List<SoldProducts> soldProductsList){
        List<co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.SoldProducts> soldProductsArrayList = new ArrayList<>();
        for (SoldProducts
                products:soldProductsList) {
            soldProductsArrayList.add(co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.SoldProducts.builder()
                    .idProduct(products.getIdProduct())
                    .quantity(products.getQuantity())
                    .build());
        }
        return soldProductsArrayList;
    }

    public List<Buy>buyListColletionTobuyList(List<BuyColletion>buyListCollection){
        List<Buy>buyList= new ArrayList<>();
        for (BuyColletion
                buy:buyListCollection){
            buyList.add(buyCollectionToBuy(buy));
        }
        return buyList;
    }
    public List<BuyColletion>buyListToBuyListCollection(List<Buy>buyList) {
        List<BuyColletion> buyListColletion = new ArrayList<>();
        for (Buy
                buyColletion : buyList) {
            buyListColletion.add(buyToBuyCollection(buyColletion));
        }
        return buyListColletion;
    }




}
