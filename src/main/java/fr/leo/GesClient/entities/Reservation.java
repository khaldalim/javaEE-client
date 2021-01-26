/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.leo.GesClient.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Léo
 */
@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numReserv;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numClient", nullable = false)
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "numChambre", nullable = false)
    private Chambre chambre;

    public Reservation() {
    }

    public Reservation(int numReserv, Date dateDebut, Date dateFin, Client client, Chambre chambre) {
        this.numReserv = numReserv;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.chambre = chambre;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public int getNumReserv() {
        return numReserv;
    }

    public void setNumReserv(int numReserv) {
        this.numReserv = numReserv;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Reservation{" + "numReserv=" + numReserv + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", client=" + client + ", chambre=" + chambre + '}';
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
        final Reservation other = (Reservation) obj;
        if (this.numReserv != other.numReserv) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        if (!Objects.equals(this.chambre, other.chambre)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

}
