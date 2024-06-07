package org.example;

import org.example.Enum.Conjonction;
import org.example.Enum.Reponse;
import org.example.Enum.Valeur;
import org.example.Enum.Valeur;
import org.example.affirmations.Affirmer;

import java.util.List;

public class Calculateur {
    public Affirmer calculer(Affirmer affirmation_a, Conjonction conjonction, Affirmer affirmation_b) {
        Valeur valeurCalcule;
        String phraseForme = String.format("%s %s %s",
                affirmation_a, conjonction, affirmation_b
        );

        if (conjonction.equals(Conjonction.DONC)) {
            if (affirmation_a.getValeur().equals(Valeur.VRAI)) {

                if (affirmation_b.getValeur().equals(Valeur.VRAI_OU_FAUX)) {
                    valeurCalcule = Valeur.VRAI_OU_FAUX;
                } else if (affirmation_b.getValeur().equals(Valeur.FAUX)) {
                    valeurCalcule = Valeur.FAUX;
                } else {
                    valeurCalcule = Valeur.VRAI;
                }

            } else {
                valeurCalcule = Valeur.VRAI;
            }
        } else {
            if (affirmation_a.getValeur().equals(Valeur.VRAI_OU_FAUX)) {

                if (conjonction.equals(Conjonction.ET)) {
                    if (affirmation_b.getValeur().equals(Valeur.VRAI)) {
                        valeurCalcule = Valeur.VRAI_OU_FAUX;
                    } else {
                        valeurCalcule = Valeur.FAUX;
                    }
                } else {
                    if (affirmation_b.getValeur().equals(Valeur.VRAI)) {
                        valeurCalcule = Valeur.VRAI;
                    } else {
                        valeurCalcule = Valeur.VRAI_OU_FAUX;
                    }
                }
            } else if (affirmation_b.getValeur().equals(Valeur.VRAI_OU_FAUX)) {
                if (conjonction.equals(Conjonction.ET)) {

                    if (affirmation_a.getValeur().equals(Valeur.VRAI)) {
                        valeurCalcule = Valeur.VRAI_OU_FAUX;
                    } else {
                        valeurCalcule = Valeur.FAUX;
                    }
                } else {
                    if (affirmation_a.getValeur().equals(Valeur.VRAI)) {
                        valeurCalcule = Valeur.VRAI;
                    } else {
                        valeurCalcule = Valeur.VRAI_OU_FAUX;
                    }
                }
            } else {
                boolean estMemeValeur = affirmation_a.getValeur().equals(affirmation_b.getValeur());
                if (
                        ((estMemeValeur && affirmation_a.getValeur().equals(Valeur.VRAI))
                                && (conjonction.equals(Conjonction.ET) || conjonction.equals(Conjonction.OU)))
                                || !estMemeValeur && conjonction.equals(Conjonction.OU
                        )
                ) {
                    valeurCalcule = Valeur.VRAI;
                } else {
                    valeurCalcule = Valeur.FAUX;
                }
            }
        }
        return new Affirmer(phraseForme, valeurCalcule);
    }

    public Reponse calculerLaValeur(Affirmer affirmation_a, Conjonction conjonction, Affirmer affirmation_b) {
        Reponse reponse;
        Valeur valeurCalcule = calculer(affirmation_a, conjonction, affirmation_b).getValeur();
         if (valeurCalcule.equals(Valeur.VRAI_OU_FAUX)) {
             return Reponse.JE_NE_SAIS_PAS;
         } else {
             return Reponse.valueOf(valeurCalcule.toString());
         }
    }
}
