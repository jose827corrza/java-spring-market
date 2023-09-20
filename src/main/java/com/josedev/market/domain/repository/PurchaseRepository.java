package com.josedev.market.domain.repository;

import com.josedev.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();
    Optional<List<Purchase>> getAllByClientId(String clientId);
    Purchase save(Purchase purchase);
}
