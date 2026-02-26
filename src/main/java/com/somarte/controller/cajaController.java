package com.somarte.controller;

import com.somarte.model.*;
import com.somarte.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.persistence.Query;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class cajaController {

	@PersistenceContext
	private EntityManager entityManager;
	
    @Autowired
    private MST001Repository Mst001;
    
    @GetMapping("/c/home")
    public String login() {
        return "caja/home";  
    }
    
    @PostMapping("/c/depositar")
    @ResponseBody
    public Map<String, Object> c_Depositar(
        @RequestParam Integer moneda,
        @RequestParam Integer cuenta,
        @RequestParam Double importe
    ) {
        Map<String, Object> response = new HashMap<>();

        try {
            BigDecimal ctaeq = BigDecimal.valueOf(cuenta);
            BigDecimal imp = BigDecimal.valueOf(importe);

            Query query = entityManager.createNativeQuery(
                "SELECT * FROM fn_abono_cuenta(:p_ctaeq, :p_imp, :p_mon, :p_user)"
            );
            query.setParameter("p_ctaeq", ctaeq);
            query.setParameter("p_imp", imp);
            query.setParameter("p_mon", moneda);
            query.setParameter("p_user", "admin");

            Object[] result = (Object[]) query.getSingleResult();
            Integer codret = ((Number) result[0]).intValue();
            String mensaje = (String) result[1];

            response.put("ok", codret == 0);
            response.put("mensaje", mensaje);
        } catch (Exception e) {
            response.put("ok", false);
            response.put("mensaje", e.getMessage());
        }

        return response;
    }
    
    @PostMapping("/c/retirar")
    @ResponseBody
    public Map<String, Object> c_Retirar(
        @RequestParam Integer moneda,
        @RequestParam Integer cuenta,
        @RequestParam Double importe
    ) {
        Map<String, Object> response = new HashMap<>();

        try {
        	Integer ctaeq = cuenta;
            BigDecimal imp = BigDecimal.valueOf(importe);

            Query query = entityManager.createNativeQuery(
                "SELECT * FROM fn_retiro_cuenta(:p_ctaeq, :p_imp, :p_mon, :p_user)"
            ); 
            query.setParameter("p_ctaeq", ctaeq);
            query.setParameter("p_imp", imp);
            query.setParameter("p_mon", moneda);
            query.setParameter("p_user", "admin");

            Object[] result = (Object[]) query.getSingleResult();
            Integer codret = ((Number) result[0]).intValue();
            String mensaje = (String) result[1];

            response.put("ok", codret == 0);
            response.put("mensaje", mensaje);
        } catch (Exception e) {
            response.put("ok", false);
            response.put("mensaje", e.getMessage());
        }

        return response;
    }
}