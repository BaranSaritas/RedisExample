package com.RedisExample.RedisExample.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "description")
        private String description;

        @Column(name = "price", nullable = false)
        private BigDecimal price;

        @ManyToOne
        @JoinColumn(name = "market_id", nullable = false)
        private Market market;


}
