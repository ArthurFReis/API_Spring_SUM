package com.arthur.somando.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "TB_SOMA")
public class SomaNumeros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Num1")
    private int num1;

    @Column(name = "Num2")
    private int num2;

    @Column(name = "Soma")
    private int soma;


    @Override
    public String toString() {
        return "SomaNumeros{" +
                "id=" + id +
                ", num1=" + num1 +
                ", num2=" + num2 +
                ", soma=" + soma +
                '}';
    }
}
