package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vegetable", schema = "fsweb")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotNull
    @NotBlank(message = "Name field cannot be empty.")
    @Size(min = 2, max = 20, message = "Vegetable name cannot smaller than 2 and " +
            "cannot bigger than 20.")
    private String name;

    @Column(name = "price")
    @NotBlank(message = "Please fill the blank.")
    @Min(5)
    private Double price;

    @Column(name = "is_grown_on_tree")
    @NotBlank
    private Boolean isGrownOnTree;
}
