package com.example.demo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by sahil on 10/09/17.
 */

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

    public Versement() {
        super();
    }

    public Versement(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
