package com.somarte.repository;

import com.somarte.model.MST001;
import com.somarte.model.MST001Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MST001Repository extends JpaRepository<MST001, MST001Id> {
    
    // Buscar por usuario
    List<MST001> findByStempAndM1user(Integer stemp, String m1user);
    
    // Buscar por tipo y número de documento
    List<MST001> findByM1tdocAndM1ndoc(Integer m1tdoc, String m1ndoc);
}