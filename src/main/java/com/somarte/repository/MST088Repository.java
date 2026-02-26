package com.somarte.repository;

import com.somarte.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MST088Repository extends JpaRepository<MST088, MST088Id> {
    
    // Buscar por usuario
    List<MST088> findByIdStempAndIdSt88user(Integer stemp, String st88user);
}