package com.stage.eCommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private Integer qteCommande;
    private float prixTotalCommande;
    @Temporal(TemporalType.DATE)
    private Date dateCommande;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    private User users;

    }
    /*@ManyToOne
    @JsonIgnore
   // Facture facture;    */

