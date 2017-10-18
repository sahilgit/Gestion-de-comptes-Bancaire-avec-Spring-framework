package com.example.demo.web;

import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;
import com.example.demo.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sahil on 11/09/17.
 */
@Controller
public class BanqueController {

    @Autowired
    public IBanqueMetier iBanqueMetier;

    @RequestMapping("/operations")
    public String index(){
        return "comptes";
    }

    @RequestMapping("/consultercompte")
    public String consultercompte(Model model,String codeCompte){
        model.addAttribute("codecompte",codeCompte);
        try {
            Compte cp = iBanqueMetier.consulterCompte(codeCompte);
            Page<Operation> pageOperation=iBanqueMetier.listOperations(codeCompte,0,7);
            model.addAttribute("listoperations",pageOperation.getContent());
            int[] pages=new int[pageOperation.getTotalPages()];
            model.addAttribute("pages",pages);
            model.addAttribute("compte", cp);
        }
        catch (Exception e){
            model.addAttribute("exception",e);
        }

        return "comptes";
    }

    @RequestMapping(value = "/saveOperation",method = RequestMethod.POST)
    public String saveOperation(Model model,String typeOperation,String codeCompte,double montant,String codeCompte2){
        try {
            System.out.println(codeCompte2);
            if (typeOperation.equals("vir")) iBanqueMetier.virement(codeCompte, codeCompte2, montant);
            if (typeOperation.equals("ver")) iBanqueMetier.verser(codeCompte, montant);
            if (typeOperation.equals("ret")) iBanqueMetier.retrait(codeCompte, montant);
        }
        catch(Exception e){
            model.addAttribute("error",e);
            return "redirect:/consultercompte?error="+e.getMessage()+"&codeCompte="+codeCompte;
        }
        return "redirect:/consultercompte?codeCompte="+codeCompte;
    }


}
