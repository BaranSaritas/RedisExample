package com.RedisExample.RedisExample.Service.impl;


import com.RedisExample.RedisExample.Repository.MarketRepository;
import com.RedisExample.RedisExample.Service.MarketService;
import com.RedisExample.RedisExample.model.Market;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MarketServiceImpl implements MarketService {

    private final MarketRepository repository;
    @Override
    public List<Market> getAllMarket() {
        return repository.getAllMarkets();
    }

    @Override
    public Market getMarket(String marketName) {
        return repository.getMarket(marketName);
    }
}
