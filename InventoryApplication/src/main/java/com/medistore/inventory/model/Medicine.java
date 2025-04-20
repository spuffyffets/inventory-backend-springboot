package com.medistore.inventory.model;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Medicine name is required")
    private String name;
    @NotBlank(message = "Company name is required")
    private String company;
    
    @Positive(message = "Price must be greater than 0")
    private double price;
    @Min(value = 1, message = "Quantity must be at least 1")
    
    private int quantity;
    private String expiryDate; 
}
