package com.example.demo.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by sahil on 10/09/17.
 */

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue
    private Long code;
    private String nom;
    private String email;

    @OneToMany(mappedBy = "client")
    private Collection<Compte> comptes;

    public Client() {
        super();
    }

    public Client(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public Client(String nom, String email, Collection<Compte> comptes) {
        this.nom = nom;
        this.email = email;
        this.comptes = comptes;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
}
