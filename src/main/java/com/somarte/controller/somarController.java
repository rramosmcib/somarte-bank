
package com.somarte.controller;

import com.somarte.model.MST001;
import com.somarte.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class somarController {

    @Autowired
    private MST001Repository mst001Repository;
    
    @GetMapping("/somar/home")
    public String login() {
        return "login";  
    }
    
    @PostMapping("/somar/")
    @ResponseBody
    public Map<String, Object> auth(@RequestParam String user, @RequestParam String pass) {
        Map<String, Object> response = new HashMap<>();

        List<MST001> usuarios = mst001Repository.findByStempAndM1user(1, user);	// Consulta MST001
        if (!usuarios.isEmpty()) {
            MST001 usuario = usuarios.get(0);	// Obtiene primer registro
                         

            response.put("ok", true);
            response.put("mensaje", "Usuario encontrado");
            response.put("ruta","/c/home");
        } else {
            response.put("ok", false);
            response.put("mensaje", "Usuario no encontrado.");
        }
        
        return response;
    }
}