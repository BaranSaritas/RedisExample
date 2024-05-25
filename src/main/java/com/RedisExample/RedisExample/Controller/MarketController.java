package com.RedisExample.RedisExample.Controller;

import com.RedisExample.RedisExample.Service.MarketService;
import com.RedisExample.RedisExample.model.Market;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/market")
public class MarketController {

    private final MarketService service;

    @GetMapping("/")
    public ResponseEntity<List<Market>> getAllMarket(){

        return  ResponseEntity.ok(service.getAllMarket());
    }

    @GetMapping("/{productName}")
    public ResponseEntity<Market> getMarket(@RequestParam("marketName") String marketName){
        return ResponseEntity.ok(service.getMarket(marketName));
    }
}
