package com.RedisExample.RedisExample.Service;


import com.RedisExample.RedisExample.model.Market;

import java.util.List;

public interface MarketService {
    List<Market> getAllMarket();

    Market getMarket(String marketName);
}
