package br.senai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/sobre")
    public String sobre(){
        return "sobre";
    }

    @GetMapping("/marketing/login")
    public String login(){return "marketing/login";}

    @GetMapping("/marketing/cadastro")
    public String cadastro(){return "marketing/cadastro";}
}