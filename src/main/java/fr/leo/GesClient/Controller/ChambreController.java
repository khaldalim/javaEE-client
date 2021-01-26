/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.leo.GesClient.Controller;

import fr.leo.GesClient.entities.Chambre;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import fr.leo.GesClient.Repository.ChambreRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Léo
 */
@Controller
public class ChambreController {

    @Autowired
    private ChambreRepository chambreDao;

    @GetMapping("/user/chambre")

    public String listeChambre(Model model,
            @RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "numChambre", defaultValue = "0") int numChambre) {

        //1-c   stockage de la page active
       
        model.addAttribute("numChambre", numChambre);

        //List<Chambre> listeChambre = chambreDao.findAll();
        if (numChambre != 0) {
            model.addAttribute("listeChambre", chambreDao.findById(numChambre).get());

        } else {
             model.addAttribute("pageActive", p);
            Page<Chambre> listeChambre = chambreDao.findAll(PageRequest.of(p, 10));
            model.addAttribute("listeChambre", chambreDao.findAll(PageRequest.of(p, 10)));
            model.addAttribute("pages", new int[listeChambre.getTotalPages()]);
           
        }

        return "chambre";
    }
  

    @GetMapping("/admin/deleteChambre")
    public String deleteChambre(
            @RequestParam(name = "numChambre") int id) {
        chambreDao.deleteById(id);
        return "redirect:/user/chambre";
    }

    @PostMapping("/admin/insertChambre")
    public String insertChambre(@Valid Chambre chambre, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formChambre";
        } else {
            chambreDao.save(chambre);
            return "redirect:/user/chambre";

        }

    }

    @GetMapping("/admin/formChambre")
    public String formChambre(Model model) {
        model.addAttribute("chambre", new Chambre());
        return "formChambre";
    }

    @RequestMapping(value = "/admin/formChambre", params = "numChambre")
    public String formUpdateChambre(Model model, @RequestParam int numChambre) {

        Optional<Chambre> dbChambre = chambreDao.findById(numChambre);
        if (dbChambre.isPresent()) {
            Chambre chambreUpdate = new Chambre();

            Chambre existChambre = dbChambre.get();

            chambreUpdate.setNumChambre(existChambre.getNumChambre());
            chambreUpdate.setTelChambre(existChambre.getTelChambre());

            model.addAttribute("chambre", chambreUpdate);
        } else {
            model.addAttribute("chambre", new Chambre());
        }

        return "formChambre";
    }

}
