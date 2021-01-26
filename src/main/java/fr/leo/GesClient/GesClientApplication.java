package fr.leo.GesClient;

import fr.leo.GesClient.Repository.ChambreRepository;
import fr.leo.GesClient.entities.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import fr.leo.GesClient.Repository.ClientRepository;
import fr.leo.GesClient.Repository.ReservationRepository;
import fr.leo.GesClient.entities.Chambre;
import fr.leo.GesClient.entities.Reservation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootApplication
public class GesClientApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository ClientDao;
    @Autowired
    private ChambreRepository chambreDao;
    @Autowired
    private ReservationRepository reservDao;

    public static void main(String[] args) {
        SpringApplication.run(GesClientApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
       
//        reservDao.save(new Reservation(
//                2, java.sql.Date.valueOf("2021-01-15"), java.sql.Date.valueOf("2021-01-16"),
//                ClientDao.getOne(2),
//                chambreDao.getOne(2)
//        ));      

    }

}
