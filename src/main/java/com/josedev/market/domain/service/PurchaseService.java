package com.josedev.market.domain.service;

import com.josedev.market.domain.Purchase;
import com.josedev.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchses() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getAllPurchasesByCLientId(String clientId) {
        return purchaseRepository.getAllByClientId(clientId);
    }

    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
