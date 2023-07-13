package com.stage.eCommerce.repositories;

import com.stage.eCommerce.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    public List<Commande> findByDate(Date dateCommande);
    public List<Commande> findByCommand(long id);
    public List<Commande> findByProduct(long id);
}
