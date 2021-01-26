/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.leo.GesClient.Controller;

import fr.leo.GesClient.Repository.ChambreRepository;
import fr.leo.GesClient.Repository.ClientRepository;
import fr.leo.GesClient.Repository.ReservationRepository;
import fr.leo.GesClient.entities.Chambre;
import fr.leo.GesClient.entities.Client;
import fr.leo.GesClient.entities.Reservation;
import java.util.List;
import java.util.Optional;
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

/**
 *
 * @author Léo
 */
@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationDao;

    @Autowired
    private ChambreRepository chambreDao;

    @Autowired
    private ClientRepository clientDao;

    @GetMapping("/user/reservation")
    public String listeReservation(Model model,
            @RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "numReserv", defaultValue = "0") int numReserv
    ) {
        model.addAttribute("numReserv", numReserv);

        //List<Chambre> listeChambre = chambreDao.findAll();
        if (numReserv != 0) {
            model.addAttribute("listeReservation", reservationDao.findById(numReserv).get());

        } else {
            model.addAttribute("pageActive", p);
            Page<Reservation> listeReservation = reservationDao.findAll(PageRequest.of(p, 10));
            model.addAttribute("listeReservation", reservationDao.findAll(PageRequest.of(p, 10)));
            model.addAttribute("pages", new int[listeReservation.getTotalPages()]);

        }

        return "reservation";
    }

    @GetMapping("/admin/deleteReservation")
    public String deleteReservation(
            @RequestParam(name = "numReserv") int id) {
        reservationDao.deleteById(id);
        return "redirect:/user/reservation";
    }

    @PostMapping("/admin/insertReservation")
    public String insertReservation(@Valid Reservation reservation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formReservation";
        } else {
            reservationDao.save(reservation);
            return "redirect:/user/reservation";

        }

    }

    @GetMapping("/admin/formReservation")
    public String formReservation(Model model) {

        model.addAttribute("listeChambre", chambreDao.findAll());
        model.addAttribute("listeClient", clientDao.findAll());
        model.addAttribute("reservation", new Reservation());

        return "formReservation";
    }

    @RequestMapping(value = "/admin/formReservation", params = "numReserv")
    public String formUpdateReservation(Model model, @RequestParam int numReserv) {

        model.addAttribute("listeChambre", chambreDao.findAll());
        model.addAttribute("listeClient", clientDao.findAll());

        Optional<Reservation> dbReserv = reservationDao.findById(numReserv);

        if (dbReserv.isPresent()) {
            Reservation reservUpdate = new Reservation();

            Reservation existReserv = dbReserv.get();

            reservUpdate.setNumReserv(existReserv.getNumReserv());
            reservUpdate.setDateDebut(existReserv.getDateDebut());
            reservUpdate.setDateFin(existReserv.getDateFin());
            reservUpdate.setClient(existReserv.getClient());
            reservUpdate.setChambre(existReserv.getChambre());

            model.addAttribute("reservation", reservUpdate);
        } else {
            model.addAttribute("reservation", new Reservation());
        }

        return "formReservation";
    }
}
