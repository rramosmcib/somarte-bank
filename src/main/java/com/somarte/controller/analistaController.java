package com.somarte.controller;


import com.somarte.model.*;
import com.somarte.repository.*;

import jakarta.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.persistence.Query;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.ParameterMode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class analistaController {

    @Autowired
    private MST097Repository mst097;
    @Autowired
    private MST8Repository mst8;    
    @Autowired
    private LST001Repository lst001;
    @Autowired
    private LST002Repository lst002;
    @Autowired
    private LST003Repository lst003;
    @Autowired
    private LST004Repository lst004;
    

	@PersistenceContext
	private EntityManager entityManager;
	
    @GetMapping("/a/home")
    public String a_home() {
        return "analista/home";  
    }

    @PostMapping("/a/nuevo-cliente")
    @ResponseBody
    public Map<String, Object> c_NuevoCliente(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Datos personales
            Map<String, Object> datosPersonales = (Map<String, Object>) payload.get("datosPersonales");
            Integer tdoc = Integer.parseInt(datosPersonales.get("l1tdoc").toString());
            String ndoc = datosPersonales.get("l1ndoc").toString();
            String ape1 = datosPersonales.get("l1ape1").toString().toUpperCase();
            String ape2 = datosPersonales.get("l1ape2").toString().toUpperCase();
            String nom1 = datosPersonales.get("l1nom1").toString().toUpperCase();
            String nom2 = datosPersonales.get("l1nom2").toString().toUpperCase();
            String nomb = datosPersonales.get("l1nomb").toString().toUpperCase();
            Integer stemp = 1;

            // Guardar en LST001
            LST001 cliente = new LST001(stemp, tdoc, ndoc, ape1, ape2, nom1, nom2, nomb);
            lst001.save(cliente);

            // Direcciones
            List<Map<String, Object>> direcciones = (List<Map<String, Object>>) payload.get("direcciones");
            for (Map<String, Object> dir : direcciones) {
                LST002 direccion = new LST002();
                
                direccion.setStemp(stemp);
                direccion.setL1tdoc(tdoc);
                direccion.setL1ndoc(ndoc);
                direccion.setL2corr(Integer.parseInt(dir.get("l2corr").toString()));
                direccion.setL2pais(dir.get("l2pais").toString().toUpperCase());
                direccion.setL2depa(dir.get("l2depa").toString().toUpperCase());
                direccion.setL2prov(dir.get("l2prov").toString().toUpperCase());
                direccion.setL2dist(dir.get("l2dist").toString().toUpperCase());
                direccion.setL2direc(dir.get("l2direc").toString().toUpperCase());

                lst002.save(direccion);
            }

            // Contactos
            List<Map<String, Object>> contactos = (List<Map<String, Object>>) payload.get("contactos");
            for (Map<String, Object> contacto : contactos) {
            	int l3corr = Integer.parseInt(contacto.get("l3corr").toString());
                String l3tel = contacto.get("l3tel").toString();
                String l3mail = contacto.get("l3mail").toString();
                
                
                LST003 entidadContacto = new LST003(stemp,tdoc,ndoc,l3corr,l3tel,l3mail);
                lst003.save(entidadContacto);
            }

            // Vinculados
            List<Map<String, Object>> vinculados = (List<Map<String, Object>>) payload.get("vinculados");
            for (Map<String, Object> vinc : vinculados) {
            	int l4corr = Integer.parseInt(vinc.get("l4corr").toString());
            	int l4tip = Integer.parseInt(vinc.get("l4tip").toString());
            	int l4tdoc = Integer.parseInt(vinc.get("l4tdoc").toString());
            	String l4ndoc = vinc.get("l4ndoc").toString().toUpperCase();
            	String l5nomb = vinc.get("l5nomb").toString().toUpperCase();

            	LST004 entidadVinc = new LST004(stemp, tdoc, ndoc,
            	                                l4corr, l4tip, l4tdoc, l4ndoc, l5nomb);

            	lst004.save(entidadVinc);
            }

            
            Query query = entityManager.createNativeQuery(
                    "SELECT * FROM fn_crear_cliente(:p_tdoc, :p_ndoc, :p_user)"
                );
            query.setParameter("p_tdoc", tdoc);
            query.setParameter("p_ndoc", ndoc);
            query.setParameter("p_user", "admin");
            
            Object[] result = (Object[]) query.getSingleResult();
            Integer codret = ((Number) result[1]).intValue();
            String mensaje = (String) result[2];
            
            if (codret == 0 ) {
                response.put("ok", true);
                response.put("mensaje", "Cliente registrado correctamente"); 	
            } else {
                response.put("ok", false);
                response.put("mensaje", mensaje); 
            }


        } catch (Exception e) {
            e.printStackTrace();
            response.put("ok", false);
            response.put("mensaje", "Error al registrar cliente: " + e.getMessage());
        }

        return response;
    }
    
    
    @PostMapping("/a/crear-cuenta")
    @ResponseBody
    public Map<String, Object> c_CrearCuenta(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Datos personales
            Map<String, Object> datosCuenta = (Map<String, Object>) payload.get("datosCuenta");
            Integer tdoc = Integer.parseInt(datosCuenta.get("tdoc").toString());
            String  ndoc = datosCuenta.get("nodc").toString();
            Integer mod  = Integer.parseInt(datosCuenta.get("modu").toString());
            Integer mda  = Integer.parseInt(datosCuenta.get("mda").toString());
           
            Query query = entityManager.createNativeQuery(
            		"SELECT * FROM fn_crear_cuenta(:p_tdoc, :p_ndoc, :p_mod, :p_tope, :p_sbop, :p_mda, :p_user)"
                );
            query.setParameter("p_tdoc", tdoc);
            query.setParameter("p_ndoc", ndoc);
            query.setParameter("p_mod", mod);
            query.setParameter("p_tope", 0);
            query.setParameter("p_sbop", 0);
            query.setParameter("p_mda", mda);
            query.setParameter("p_user", "admin");
            
            Object[] result = (Object[]) query.getSingleResult();
            Integer ctaeq = ((Number) result[0]).intValue();
            Integer codret = ((Number) result[1]).intValue();
            String mensaje = (String) result[2];
            
            if (codret == 0 ) {
                response.put("ok", true);
                response.put("mensaje", "Cliente registrado correctamente<br>Numero de cuenta:" + ctaeq ); 	
            } else {
                response.put("ok", false);
                response.put("mensaje", mensaje); 
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.put("ok", false);
            response.put("mensaje", "Error al registrar cliente: " + e.getMessage());
        }

        return response;
    }
    
    @PostMapping("/a/evaluar")
    @ResponseBody
    public Map<String, Object> c_Evaluar(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();
        try {
            Integer tdoc = Integer.parseInt(payload.get("tdoc").toString());
            String ndoc = payload.get("ndoc").toString();
           
			StoredProcedureQuery sp_AsigCal = entityManager
			    .createStoredProcedureQuery("sp_asigna_calificacion")
			    .registerStoredProcedureParameter("p_tdoc", Integer.class, ParameterMode.IN)
			    .registerStoredProcedureParameter("p_ndoc", String.class, ParameterMode.IN);
		
			sp_AsigCal.setParameter("p_tdoc", tdoc);
			sp_AsigCal.setParameter("p_ndoc", ndoc);
		
			sp_AsigCal.execute();
			
		    List<MST097> evalua = mst097.findBySt97tdocAndSt97ndoc(tdoc, ndoc);		    
	        if (!evalua.isEmpty()) {
	        	// Calificacion	 
	        	MST097 eval = evalua.get(0);	       	
	            String cal = eval.getSt97cali();
	            BigDecimal impApro = BigDecimal.ZERO;
	            Random random = new Random();

	            switch (cal) {
		            case "NOR":
		                double valorNor = 25000 + (random.nextDouble() * (50000 - 25000));
		                impApro = BigDecimal.valueOf(valorNor).setScale(2, RoundingMode.HALF_UP);
		                response.put("tasa", 0.1299);
		                break;
		            case "DUD":
		                double valorDud = random.nextDouble() * 25000;
		                impApro = BigDecimal.valueOf(valorDud).setScale(2, RoundingMode.HALF_UP);
		                response.put("tasa", 0.1999); 
		                break;
		            case "DEF":
		            	response.put("tasa", 0);
		                break;
		            case "CPP":
		            	response.put("tasa", 0);
		                break;
		            case "PER":
		            	response.put("tasa", 0);
		                break;
	            }
	            response.put("calificacion", cal); 
	            response.put("importe", impApro); 
	            
	            // obtiene nombre
	            List<LST001> personas = lst001.findByL1tdocAndL1ndoc(tdoc, ndoc);
	            if (!personas.isEmpty()) {
	            	LST001 persona = personas.get(0);
	            	String Nomb = persona.getL1nomb();
	            	response.put("nombre", Nomb);
	            }
	            
	            // cont productos
	            Query query = entityManager.createNativeQuery(
            	    "SELECT COUNT(*) " +
            	    "FROM MST011 " +
            	    "WHERE STCTA = ( " +
            	    "    SELECT STNCTA FROM MST8 " +
            	    "    WHERE STTDOC = :STTDOC AND STNDOC = :STNDOC " +
            	    ")"
            	);

            	query.setParameter("STTDOC", tdoc);
            	query.setParameter("STNDOC", ndoc);
            	Number result = (Number) query.getSingleResult();
            	Integer cantidad = result.intValue();	     
            	response.put("cantidad", cantidad);
            	
	            response.put("ok", true);

	        } else {
	            response.put("ok", false);
	            response.put("mensaje", "No se pudo evaluar al cliente.");
	        }

        } catch (Exception e) {
            e.printStackTrace();
            response.put("ok", false);
            response.put("mensaje", "Error al evaluar cliente: " + e.getMessage());
        }

        return response;
    }
    
    @PostMapping("/a/desembolsar")
    @ResponseBody
    public Map<String, Object> c_desembolsar(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();
        try {
            Integer tdoc = Integer.valueOf(payload.get("tdoc").toString());
            String ndoc = payload.get("ndoc").toString();
            BigDecimal tasa = new BigDecimal(payload.get("tasa").toString());
            BigDecimal importe = new BigDecimal(payload.get("importe").toString());
            Integer plazo = Integer.valueOf(payload.get("plazo").toString());
        	
        	List<MST8> cuentas = mst8.findBySttdocAndStndoc(tdoc, ndoc);
            if (cuentas.isEmpty()) {
                response.put("ok", false);
                response.put("mensaje", "No se encontró cuenta para el cliente");
                return response;
            }

            Integer numeroCuenta = cuentas.get(0).getStncta();
            Integer moneda = 0; 
            String usuario = "RRAMOSM"; 

            StoredProcedureQuery sp = entityManager
                .createStoredProcedureQuery("sp_desembolso")
                .registerStoredProcedureParameter("p_ncta", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_mda", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_user", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_imp", BigDecimal.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_tas", BigDecimal.class, ParameterMode.IN)
                .registerStoredProcedureParameter("p_pla", Integer.class, ParameterMode.IN);

            sp.setParameter("p_ncta", numeroCuenta);
            sp.setParameter("p_mda", moneda);
            sp.setParameter("p_user", usuario);
            sp.setParameter("p_imp", importe);
            sp.setParameter("p_tas", tasa);
            sp.setParameter("p_pla", plazo);

            sp.execute();

            response.put("ok", true);
            response.put("mensaje", "Crédito desembolsado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("ok", false);
            response.put("mensaje", "Error al desembolsar crédito: " + e.getMessage());
        }
        return response;
    }  
}