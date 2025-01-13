package com.example.API_Lancha.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter  @Setter  @AllArgsConstructor  @NoArgsConstructor  @ToString  @EqualsAndHashCode(of = "id")
@Entity
@Table(name = "ship")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String name;
    @NotNull
    @Max(18)
    private Integer limite;
    @NotBlank
    private String hour;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Role go;
    @NotNull
    private Integer price;
}
