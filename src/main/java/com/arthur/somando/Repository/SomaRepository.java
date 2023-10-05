package com.arthur.somando.Repository;

import com.arthur.somando.Entity.SomaNumeros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SomaRepository extends JpaRepository<SomaNumeros, Long> {
}
