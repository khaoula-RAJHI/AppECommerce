package com.stage.eCommerce.controllers;


import com.stage.eCommerce.entities.Commande;
import com.stage.eCommerce.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    CommandeService commandeProduitService;

    @GetMapping("/retrieve-all-commandeProduits")
    @ResponseBody
    public List<Commande> getCommandeProduits() {
        List<Commande> list = commandeProduitService.retrieveAllCommandeProduits();
        return list;
    }

    @GetMapping("/retrieve-commandeProduit/{commandeProduit-id}")
    @ResponseBody
    public Commande retrieveCommandeProduit(@PathVariable("commandeProduit-id") Long commandeProduitId) {
        return commandeProduitService.retrieveCommandeProduit(commandeProduitId);
    }

    @PostMapping("/add-commandeProduit/{idp}/{idf}")
    @ResponseBody
    public Commande addCommandeProduit(@RequestBody Commande cp,@PathVariable("idp") long idp ,@PathVariable("idf") long idf) {
        Commande commandeProduit = commandeProduitService.addCommandeProduit(cp,idp,idf);
        return commandeProduit;
    }

    @DeleteMapping("/remove-commandeProduit/{commandeProduit-id}")
    @ResponseBody
    public void removeCommandeProduit(@PathVariable("commandeProduit-id") Long commandeProduitId) {
        commandeProduitService.removeCommandeProduit(commandeProduitId);
    }

    @PutMapping("/modify-commandeProduit")
    @ResponseBody
    public Commande modifyCommandeProduit(@RequestBody Commande commandeProduit) {
        return commandeProduitService.updateCommandeProduit(commandeProduit);
    }
}
