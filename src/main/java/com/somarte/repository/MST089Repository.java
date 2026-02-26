package com.somarte.repository;
import com.somarte.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MST089Repository extends JpaRepository<MST089, MST089Id> {
    
    // Buscar por usuario
    List<MST089> findByIdStempAndIdSt89user(Integer stemp, String st89user);   
}