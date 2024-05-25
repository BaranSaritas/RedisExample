package com.RedisExample.RedisExample.Repository;

import com.RedisExample.RedisExample.model.Market;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<Market,Long> {

    @Query("""
            SELECT m FROM Market m
            """)
    List<Market> getAllMarkets();

    @Query("""
            SELECT m FROM Market m WHERE :marketName IS NOT NULL AND m.name = :marketName
            """)
    Market getMarket(@Param("marketName") String marketName);
}
