package com.somarte.repository;

import com.somarte.model.LST004;
import com.somarte.model.LST004Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LST004Repository extends JpaRepository<LST004, LST004Id> {
}