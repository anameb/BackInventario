package co.com.sofka.inventario.inventarioback.infrastructure.persistence.service;

import co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.BuyColletion;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.ProductsColletion;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.repostory.BuysRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BuyService {

    private final BuysRepository buysRepository;

    public BuyColletion saveBuy(BuyColletion buyColletion) {
        return buysRepository.save(buyColletion);
    }
    public List<BuyColletion> getAllBuys(){
        return buysRepository.findAll();
    }
}
