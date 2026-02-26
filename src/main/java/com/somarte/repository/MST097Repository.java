
package com.somarte.repository;

import com.somarte.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//import java.util.Optional;

@Repository
public interface MST097Repository extends JpaRepository<MST097, MST097Id> {
    List<MST097> findBySt97tdocAndSt97ndoc(Integer st97tdoc, String st97ndoc);
}