package com.stage.eCommerce.services;

import com.stage.eCommerce.entities.Commande;

import java.util.List;

public interface ICommandeService {
    List<Commande> retrieveAllCommandeProduits();

    Commande addCommandeProduit (Commande cp , Long idp, Long idu);

    Commande updateCommandeProduit (Commande cp);

    Commande retrieveCommandeProduit (Long id);

    void removeCommandeProduit (Long id);
}
