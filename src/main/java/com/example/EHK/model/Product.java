package com.example.EHK.model;
import javax.persistence.*;
import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String status;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}