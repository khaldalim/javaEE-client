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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numClient;

    @NotNull
    private String nomClient;

    @NotNull
    private String prenomClient;

    @NotNull    
    private String adresseClient;

    @NotNull
    private String telClient;

    @NotNull
    @Email
    private String emailClient;

    //association @OneToMany ==> liste
    @OneToMany(targetEntity = Reservation.class, mappedBy = "client")
    List<Reservation> listReservation = new ArrayList<>();

    public Client() {
    }

    public Client(int numClient, String nomClient, String prenomClient, String adresseClient, String telClient, String emailClient) {
        this.numClient = numClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adresseClient = adresseClient;
        this.telClient = telClient;
        this.emailClient = emailClient;
    }

    public int getNumClient() {
        return numClient;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public String toString() {
        return "Client{" + "numClient=" + numClient + ", nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", adresseClient=" + adresseClient + ", telClient=" + telClient + ", emailClient=" + emailClient + '}';
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
        final Client other = (Client) obj;
        if (this.numClient != other.numClient) {
            return false;
        }
        if (!Objects.equals(this.nomClient, other.nomClient)) {
            return false;
        }
        if (!Objects.equals(this.prenomClient, other.prenomClient)) {
            return false;
        }
        if (!Objects.equals(this.adresseClient, other.adresseClient)) {
            return false;
        }
        if (!Objects.equals(this.telClient, other.telClient)) {
            return false;
        }
        if (!Objects.equals(this.emailClient, other.emailClient)) {
            return false;
        }
        return true;
    }

}
