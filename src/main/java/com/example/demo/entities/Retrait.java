package com.example.demo.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by sahil on 10/09/17.
 */

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {

    public Retrait() {
        super();
    }

    public Retrait(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
