package com.somarte.repository;

import com.somarte.model.LST001;
import com.somarte.model.LST001Id;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LST001Repository extends JpaRepository<LST001, LST001Id> {
    List<LST001> findByL1tdocAndL1ndoc(Integer l1tdoc, String l1ndoc);
}


