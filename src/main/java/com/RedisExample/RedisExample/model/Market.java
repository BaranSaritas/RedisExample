package com.RedisExample.RedisExample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import java.util.List;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Market {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @JsonIgnore
        @OneToMany(mappedBy = "market", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Product> products;
}
