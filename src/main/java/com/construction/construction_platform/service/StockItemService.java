package com.construction.construction_platform.service;

import com.construction.construction_platform.model.StockItem;
import com.construction.construction_platform.repository.StockItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockItemService {

    @Autowired
    private StockItemRepository stockItemRepository;

    public List<StockItem> getAllStock() {
        return stockItemRepository.findAll();
    }

    public StockItem addOrUpdateStock(StockItem stockItem) {
        return stockItemRepository.findByMaterialName(stockItem.getMaterialName())
                .map(existing -> {
                    existing.setQuantity(existing.getQuantity() + stockItem.getQuantity());
                    existing.setWarehouseLocation(stockItem.getWarehouseLocation());
                    return stockItemRepository.save(existing);
                })
                .orElseGet(() -> stockItemRepository.save(stockItem));
    }
}