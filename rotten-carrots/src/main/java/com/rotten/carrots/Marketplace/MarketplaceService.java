package com.rotten.carrots.Marketplace;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarketplaceService {

    private final MarketplaceRepository marketplaceRepository;

    public List<Marketplace> getAll() {
        return marketplaceRepository.findAll();
    }


    public Optional<Marketplace> getMarketplaceByID(String id) {
        return marketplaceRepository.findById(id);
    }

    public ResponseEntity<?> deleteMarketplaceByID(String id) {
        var entity = marketplaceRepository.findById(id);
        if(entity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        marketplaceRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
