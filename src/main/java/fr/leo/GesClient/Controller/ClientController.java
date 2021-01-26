package fr.leo.GesClient.Controller;

import fr.leo.GesClient.entities.Client;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import fr.leo.GesClient.Repository.ClientRepository;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientDao;

   

    @GetMapping("/user/client")
    public String listeCours(Model model,
            @RequestParam(name = "page", defaultValue = "0") int p,
            @RequestParam(name = "motCle", defaultValue = "") String mc
    ) {
        //1-    on recupere les client
        // List<Cours> listeCours = clientDao.findAll();

        //1-a   on recupère des pages de client
        // Page<Cours> listeCours = clientDao.findAll(PageRequest.of(p, 10));
        Page<Client> listeClient = clientDao.findByNomClientContains(mc, PageRequest.of(p, 10));

        //1-b   On stock le nombres de page total
        model.addAttribute("pages", new int[listeClient.getTotalPages()]);

        //1-c   stockage de la page active
        model.addAttribute("pageActive", p);

        //1-d   on stock le mot clé dans le modele
        model.addAttribute("mc", mc);

        //2 injection de la liste dans le modeele
        model.addAttribute("listeClient", listeClient);

        return "client";
    }

    @GetMapping("/admin/delete")
    public String delete(
            @RequestParam(name = "numClient") int id) {

        //suppression d'un objet client
        clientDao.deleteById(id);

        return "redirect:/user/client";
    }

    @PostMapping("/admin/insert")
    public String insert(@Valid Client client, BindingResult bindingResult) {
        //suppression d'un objet client

        if (bindingResult.hasErrors()) {

            return "formClient";

        } else {
            clientDao.save(client);
            return "redirect:/user/client";

        }

    }

    @GetMapping("/admin/formClient")
    public String form(Model model) {
        model.addAttribute("client", new Client());

        return "formClient";
    }

    @RequestMapping(value = "/admin/formClient", params = "numClient")
    public String formUpdate(Model model, @RequestParam int numClient) {

        Optional<Client> dbClient = clientDao.findById(numClient);
        if (dbClient.isPresent()) {
            Client clientUpdate = new Client();

            Client existClient = dbClient.get();

            clientUpdate.setNumClient(existClient.getNumClient());
            clientUpdate.setNomClient(existClient.getNomClient());
            clientUpdate.setPrenomClient(existClient.getPrenomClient());
            clientUpdate.setAdresseClient(existClient.getAdresseClient());
            clientUpdate.setTelClient(existClient.getTelClient());
            clientUpdate.setEmailClient(existClient.getEmailClient());

            model.addAttribute("client", clientUpdate);
        } else {
            model.addAttribute("client", new Client());
        }

        return "formClient";
    }

    

}
