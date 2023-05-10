package com.rotten.carrots.Marketplace;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marketplaces")
@RequiredArgsConstructor
public class MarketplaceResource {

    private final MarketplaceService marketplaceService;

    @GetMapping("/all")
    public List<Marketplace> getAll() {
        return marketplaceService.getAll();
    }

    @GetMapping("/{marketplaceID}")
    public Optional<Marketplace> getMarketplaceByID(@PathVariable("marketplaceID") String id) {
        return marketplaceService.getMarketplaceByID(id);
    }

    @DeleteMapping("/{marketplaceID}")
    public ResponseEntity<?> deleteMarketplace(@PathVariable("marketplaceID") String id) {
        return marketplaceService.deleteMarketplaceByID(id);
    }
}
