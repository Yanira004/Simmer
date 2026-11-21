package com.simmer.simmer_backend.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.simmer.simmer_backend.model.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {

    Optional<Unit> findByNameIgnoreCase(String name);

}