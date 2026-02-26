package com.somarte.controller;


import com.somarte.model.MST001;
import com.somarte.repository.MST001Repository;
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
public class gerenteController {

    @Autowired
    private MST001Repository mst001Repository;
    
    @GetMapping("/g/home")
    public String login() {
        return "gerente/home";  
    }
}