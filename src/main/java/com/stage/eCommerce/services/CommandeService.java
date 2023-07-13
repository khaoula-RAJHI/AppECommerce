package com.stage.eCommerce.services;

import com.stage.eCommerce.entities.Commande;
import com.stage.eCommerce.entities.Produit;
import com.stage.eCommerce.entities.User;
import com.stage.eCommerce.repositories.CommandeRepository;
import com.stage.eCommerce.repositories.ProduitRepository;
import com.stage.eCommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandeService implements ICommandeService {

    @Autowired
    CommandeRepository cpr;
    @Autowired
    UserRepository fr;
    @Autowired
    ProduitRepository pr;

    private List<Commande> CommandeProduits;
    private List<Produit> produits;
    private List<User> users;

    private String To;
    private String msg;


    @Override
    public List<Commande> retrieveAllCommandeProduits() {
        CommandeProduits = new ArrayList<Commande>();
        cpr.findAll().forEach(e -> CommandeProduits.add(e));
        return CommandeProduits;
    }

    @Override
    public Commande addCommandeProduit(Commande cp, Long idp, Long idf) {
        Produit p = pr.findById(idp).get();
        User f = fr.findById(idf).get();
        if (!ObjectUtils.isEmpty(p) && !ObjectUtils.isEmpty(f)) {
            cp.setProduit(p);
            cp.setUsers(f);
        }

        cpr.save(cp);

        To = String.valueOf(cp.getUsers().getEmail());
        msg = "- -" + "\nCommande pour : " + String.valueOf(cp.getUsers().getUsername()) + "\nProduit : "
                + cp.getProduit().getLibelleProduit() + "\nQuantite : " + String.valueOf(cp.getQteCommande()) + "\nDate : "
                + String.valueOf(cp.getDateCreation());


        return cp;
    }

    @Override
    public Commande updateCommandeProduit(Commande cp) {
        cpr.save(cp);
        return cp;
    }

    @Override
    public Commande retrieveCommandeProduit(Long id) {
        Commande cp = cpr.findById(id).get();
        return cp;
    }

    @Override
    public void removeCommandeProduit(Long id) {
        Commande cp = cpr.findById(id).get();
        cpr.delete(cp);
    }
}
