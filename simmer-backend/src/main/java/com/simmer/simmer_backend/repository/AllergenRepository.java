package com.simmer.simmer_backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.simmer.simmer_backend.model.Allergen;

public interface AllergenRepository extends JpaRepository<Allergen, Long> {
    Optional<Allergen> findByNameIgnoreCase(String name);
}
