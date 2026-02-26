package com.somarte.repository;

import com.somarte.model.MST8;
import com.somarte.model.MST8Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MST8Repository extends JpaRepository<MST8, MST8Id> {
    
    // Buscar por número de cuenta
    Optional<MST8> findByStncta(Integer stncta);
    
    // Buscar por tipo y número de documento
    List<MST8> findBySttdocAndStndoc(Integer sttdoc, String stndoc);
}