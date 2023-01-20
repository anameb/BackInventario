package co.com.sofka.inventario.inventarioback.infrastructure.restClient.controllers;

import co.com.sofka.inventario.inventarioback.application.usecases.BuyUseCase;
import co.com.sofka.inventario.inventarioback.infrastructure.restClient.dto.BuyDto;
import co.com.sofka.inventario.inventarioback.infrastructure.restClient.mapper.BuyDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/buys")
public class BuyController {

    private final BuyUseCase buyUseCase;
    private final BuyDtoMapper buyDtoMapper;

    @PostMapping()
    public BuyDto addBuy(@RequestBody BuyDto buyDto) {
        return buyDtoMapper.buyToBuyDto(buyUseCase.saveBuy(buyDtoMapper.BuyDtoTobuy(buyDto)));
    }
    @GetMapping()
    public List<BuyDto> getAllBuy(){
        return buyDtoMapper.buyListToBuyListDto(buyUseCase.historyBuys());
    }
}
