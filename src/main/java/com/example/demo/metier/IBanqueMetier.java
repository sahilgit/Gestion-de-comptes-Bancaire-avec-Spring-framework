package com.example.demo.metier;

import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;
import org.springframework.data.domain.Page;

/**
 * Created by sahil on 11/09/17.
 */
public interface IBanqueMetier {

    public Compte consulterCompte(String codeCpte);
    public void verser(String codeCpte,Double montant);
    public void retrait(String codeCpte,Double montant);
    public void virement(String codeCpte1,String codeCpte2,Double montant);
    public Page<Operation> listOperations(String codeCpte,int numPage,int taille);


}
