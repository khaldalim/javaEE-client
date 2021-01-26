/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.leo.GesClient.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Léo
 */

@Controller
public class GeneralController {
    
    
     @RequestMapping(value = "/user/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    
    
    @PostMapping("/403")
    public String page403() {
        return "403";
    }

    @GetMapping("/403")
    public String page403Get() {
        return "403";
    }

    @GetMapping("/")
    public String defaut() {
        return "redirect:/user/index";
    }
    
    @GetMapping("/user")
    public String user() {
        return "redirect:/user/index";
    }
    
    @GetMapping("/admin")
    public String admin() {
        return "redirect:/user/index";
    }
    

}
