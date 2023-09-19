package com.josedev.market.web.controller;

import com.josedev.market.domain.Purchase;
import com.josedev.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping()
    public List<Purchase> getAll() {
        return purchaseService.getAllPurchses();
    }

    @GetMapping("/{id}")
    public Optional<List<Purchase>> getAllPurchasesByClientId(@PathVariable("id")String clientId){
        return purchaseService.getAllPurchasesByCLientId(clientId);
    }

    @PostMapping()
    public Purchase createAPurchase(@RequestBody Purchase purchase){
        return purchaseService.createPurchase(purchase);
    }
}
