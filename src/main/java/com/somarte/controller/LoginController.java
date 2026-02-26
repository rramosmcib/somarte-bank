package com.somarte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.somarte.repository.*;
import com.somarte.model.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    private final MST001Repository mst001;
    private final MST089Repository mst089;
    
    public LoginController(MST001Repository mst001, MST089Repository mst089) {
        this.mst001 = mst001;
        this.mst089 = mst089;
    }
    
    @GetMapping("/")
    public String login() {
        return "login";  
    }
    
    @PostMapping("/auth")
    @ResponseBody
    public Map<String, Object> auth(@RequestParam String user, @RequestParam String pass) {
        Map<String, Object> response = new HashMap<>();

        try {
            List<MST001> usuarios = mst001.findByStempAndM1user(1, user.toUpperCase()); // Consulta MST001
            if (!usuarios.isEmpty()) {
                MST001 usuario = usuarios.get(0); // Obtiene primer registro
            	
                if (!usuario.getM1pass().equals(pass)) {
                    response.put("ok", false);
                    response.put("mensaje", "Credenciales incorrectas");
                    return response;
                }

                List<MST089> rutas = mst089.findByIdStempAndIdSt89user(1, user.toUpperCase()); // busca la ruta de usuario
                if (!rutas.isEmpty() && usuario.getM1stat() == 0) {
                    MST089 ruta = rutas.get(0);

                    response.put("ok", true);
                    response.put("mensaje", "Usuario encontrado");
                    response.put("ruta", ruta.getSt89ruta());
                } else {
                    response.put("ok", false);
                    response.put("mensaje", "Usuario no tiene accesos");
                }
            } else {
                response.put("ok", false);
                response.put("mensaje", "Usuario no encontrado.");
            }
        } catch (Exception e) {
            response.put("ok", false);
            response.put("mensaje", "Error interno: " + e.getMessage());
        }

        return response;
    }
    
    
    @PostMapping("/validate")
    @ResponseBody
    public Map<String, Object> validate(@RequestParam Integer tdoc, @RequestParam String ndoc) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> datos    = new HashMap<>();

        try {
            List<MST001> usuarios = mst001.findByM1tdocAndM1ndoc(tdoc, ndoc); // Consulta MST001
            if (!usuarios.isEmpty()) {
                MST001 usuario = usuarios.get(0); // Obtiene primer registro
                
                datos.put("tdoc",tdoc);
                datos.put("ndoc", ndoc);
                
                response.put("ok", true);
                response.put("mensaje", "Usuario encontrado.");
                response.put("datos", datos);
            } else {
                response.put("ok", false);
                response.put("mensaje", "Usuario no encontrado.");
                response.put("datos", "");
            }
        } catch (Exception e) {
            response.put("ok", false);
            response.put("mensaje", "Error interno: " + e.getMessage());
            response.put("datos", "");
        }

        return response;
    }
    
    @PostMapping("/recupera-contraseña")
    @ResponseBody
    public Map<String, Object> recuperaContraseña(@RequestParam String newpass,
    								@RequestParam String confpass,
    								@RequestParam Integer tdoc,
    								@RequestParam String ndoc) {
        Map<String, Object> response = new HashMap<>();
        if (!newpass.equals(confpass)) {
            response.put("ok", false);
            response.put("mensaje", "Contraseña no coiciden");
            return response;
        } else {        	
        	List<MST001> usuarios = mst001.findByM1tdocAndM1ndoc(tdoc, ndoc);

        	if (!usuarios.isEmpty()) {
        	    MST001 usuario = usuarios.get(0); // obtienes el primer registro

        	    // Actualizas el campo
        	    usuario.setM1pass(confpass);

        	    // Guardas la entidad actualizada
        	    mst001.save(usuario);
        	    

                response.put("ok", true);
                response.put("mensaje", "Contraseña cambiada");
        	}
        }

        return response;
    }    
}