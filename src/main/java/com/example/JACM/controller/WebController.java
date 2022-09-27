package com.example.JACM.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/index")
    public String index(){
        return "index.html";
    }

//    @GetMapping("/")
//    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
//        if(principal != null){
//            System.out.println(principal.getClaims());
//            Autenticacion usuario = this.sauth.getOrCreateAuth(principal.getClaims());
//            model.addAttribute("auth", usuario);
//        }
//        return "index";
//    }

}