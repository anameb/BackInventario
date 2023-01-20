package co.com.sofka.inventario.inventarioback.application.usecases;

import co.com.sofka.inventario.inventarioback.application.mapper.BuyMapper;
import co.com.sofka.inventario.inventarioback.application.mapper.ProductMapper;
import co.com.sofka.inventario.inventarioback.domain.models.Buy;
import co.com.sofka.inventario.inventarioback.domain.models.Products;
import co.com.sofka.inventario.inventarioback.domain.models.SoldProducts;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.service.BuyService;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BuyUseCase {

    private final ProductService productService;
    private final BuyService buyService;
    private final ProductMapper productMapper;
    private final BuyMapper buyMapper;

    public Buy saveBuy(Buy buy) {
        boolean error = false;

        List<SoldProducts> soldProductsList = buy.getProducts();
        for (SoldProducts soldProducts : soldProductsList) {

            Products product = productMapper.productCollectionToProduct(
                    productService.findById(soldProducts.getIdProduct()));

            if (!enabledProduct(soldProducts, product)) {
                error = false;
                break;
            }
            if (!validateMinMax(soldProducts, product)) {
                error = false;
                break;
            }

            if (!validateInventory(soldProducts, product)) {
                error = false;
                break;
            }
        }

        if (error) {
            buy = buyMapper.buyCollectionToBuy(buyService.saveBuy(buyMapper.buyToBuyCollection(buy)));
            for (SoldProducts soldProducts : soldProductsList) {

                Products product = productMapper.productCollectionToProduct(
                        productService.findById(soldProducts.getIdProduct()));
                discountInventory(soldProducts, product);
            }

        } else {
            //indicar que no se pudo realizar la compra
        }

        return buy;
    }

    private boolean discountInventory(SoldProducts soldProducts, Products product) {
        product.setInInventory(product.getInInventory() - soldProducts.getQuantity());
        try {
            productService.updateProduct(productMapper.productToProductCollection(product));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private boolean validateMinMax(SoldProducts soldProducts, Products product) {

        if (product.getMin() >= soldProducts.getQuantity() && soldProducts.getQuantity() <= product.getMax()) {
            return true;
        } else {
            return false;

        }
    }

    private boolean enabledProduct(SoldProducts soldProducts, Products product) {

        if (product.getEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validateInventory(SoldProducts soldProducts, Products product) {
        if (product.getInInventory() >= soldProducts.getQuantity()) {
            return true;
        } else {
            return false;
        }
    }

    public List<Buy> historyBuys(){
        return buyMapper.buyListColletionTobuyList(buyService.getAllBuys());

    }

}
