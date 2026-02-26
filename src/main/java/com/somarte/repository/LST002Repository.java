package com.somarte.repository;

import com.somarte.model.LST002;
import com.somarte.model.LST002Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LST002Repository extends JpaRepository<LST002, LST002Id> {
}