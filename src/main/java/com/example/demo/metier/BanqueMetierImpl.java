package com.example.demo.metier;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.CompteRepository;
import com.example.demo.dao.OperationRepository;
import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;

/**
 * Created by sahil on 11/09/17.
 */
@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {

    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Compte consulterCompte(String codeCpte) {
        Compte c=compteRepository.findOne(codeCpte);
        if(c==null) throw new RuntimeException("Compte Introuvable");
        return c;
    }

    @Override
    public void verser(String codeCpte, Double montant) {

        Compte cp=consulterCompte(codeCpte);
        Versement versement=new Versement(new Date(),montant,cp);
        operationRepository.save(versement);
        cp.setSolde(cp.getSolde()+montant);
        compteRepository.save(cp);


    }

    @Override
    public void retrait(String codeCpte, Double montant) {

        Compte cp=consulterCompte(codeCpte);
        Double facilitecaisse=0.0;
        if(cp instanceof CompteCourant) facilitecaisse=((CompteCourant) cp).getDecouvert();
        if(cp.getSolde()+facilitecaisse<=montant) throw new RuntimeException("solde insuffisant");
        Retrait retrait= new Retrait(new Date(),montant,cp);
        operationRepository.save(retrait);
        cp.setSolde(cp.getSolde()-montant);
        compteRepository.save(cp);
    }

    @Override
    public void virement(String codeCpte1, String codeCpte2, Double montant) {

        if(codeCpte1.equals(codeCpte2)) throw new RuntimeException("le code correspond a votre compte");
       retrait(codeCpte1,montant);
       verser(codeCpte2,montant);


    }

    @Override
    public Page<Operation> listOperations(String codeCpte, int numPage, int taille) {
        return operationRepository.listOperation(codeCpte,new PageRequest(numPage,taille));
    }
}
