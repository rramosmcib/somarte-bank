
package com.somarte.repository;

import com.somarte.model.LST003;
import com.somarte.model.LST003Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LST003Repository extends JpaRepository<LST003, LST003Id> {
}