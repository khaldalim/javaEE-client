/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.leo.GesClient.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Léo
 */
@Entity
@Table(name = "chambre")
public class Chambre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numChambre;

    @NotNull
    private String TelChambre;

    //association @OneToMany ==> liste
    @OneToMany(targetEntity = Reservation.class, mappedBy = "chambre")
    List<Reservation> listReservation = new ArrayList<>();

    public Chambre() {
    }

    public Chambre(int numChambre, String TelChambre) {
        this.numChambre = numChambre;
        this.TelChambre = TelChambre;
    }

    public int getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(int numChambre) {
        this.numChambre = numChambre;
    }

    public String getTelChambre() {
        return TelChambre;
    }

    public void setTelChambre(String TelChambre) {
        this.TelChambre = TelChambre;
    }

    @Override
    public String toString() {
        return "Chambre{" + "numChambre=" + numChambre + ", TelChambre=" + TelChambre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Chambre other = (Chambre) obj;
        if (this.numChambre != other.numChambre) {
            return false;
        }
        if (!Objects.equals(this.TelChambre, other.TelChambre)) {
            return false;
        }
        return true;
    }

}
