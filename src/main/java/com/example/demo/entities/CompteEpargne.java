package com.example.demo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Collection;
import java.util.Date;

/**
 * Created by sahil on 10/09/17.
 */
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

    private double taux;

    public CompteEpargne() {
        super();
    }

    public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, double taux) {
        super(codeCompte, dateCreation, solde, client);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
