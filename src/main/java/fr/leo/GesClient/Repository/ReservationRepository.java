/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.leo.GesClient.Repository;

import fr.leo.GesClient.entities.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Léo
 */
public interface ReservationRepository  extends JpaRepository<Reservation, Object>{
   
}
