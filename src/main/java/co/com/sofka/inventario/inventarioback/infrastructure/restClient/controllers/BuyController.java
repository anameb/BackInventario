package co.com.sofka.inventario.inventarioback.infrastructure.restClient.controllers;

import co.com.sofka.inventario.inventarioback.application.usecases.BuyUseCase;
import co.com.sofka.inventario.inventarioback.domain.models.Buy;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.BuyColletion;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.colletions.ProductsColletion;
import co.com.sofka.inventario.inventarioback.infrastructure.persistence.service.BuyService;
import co.com.sofka.inventario.inventarioback.infrastructure.restClient.dto.BuyDto;
import co.com.sofka.inventario.inventarioback.infrastructure.restClient.mapper.BuyDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/buys")
public class BuyController {

    private final BuyUseCase buyUseCase;
    private final BuyDtoMapper buyDtoMapper;

    @PostMapping()
    public BuyDto addBuy(BuyDto buyDto) {
        return buyDtoMapper.buyToBuyDto(buyUseCase.saveBuy(buyDtoMapper.BuyDtoTobuy(buyDto)));
    }
    @GetMapping()
    public List<BuyDto> getAllBuy(){
        return buyDtoMapper.buyListToBuyListDto(buyUseCase.historyBuys());
    }
}
