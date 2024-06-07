package org.example;

import org.example.Enum.Conjonction;
import org.example.Enum.Reponse;
import org.example.affirmations.Affirmation;
import org.example.affirmations.Mensonge;
import org.example.affirmations.Verite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateurTest {
    Calculateur calculateur = new Calculateur();

    Verite verite_1 = new Verite("Lou est beau.");
    Mensonge mensonge_1 = new Mensonge("Lou est pauvre.");
    Affirmation affirmation_1 = new Affirmation("Lou est généreux.");



    @Test
    void mensonge_et_affirmation_retourne_faux() {
        Assertions.assertEquals(calculateur.calculerLaValeur(verite_1, Conjonction.ET, mensonge_1), Reponse.FAUX);
    }
    @Test
    void verite_et_mensonge_retourne_faux() {
        Assertions.assertEquals(calculateur.calculerLaValeur(verite_1, Conjonction.ET, mensonge_1), Reponse.FAUX);
    }
    @Test
    void verite_ou_mensonge_retourne_vrai() {
        Assertions.assertEquals(calculateur.calculerLaValeur(verite_1, Conjonction.OU, mensonge_1), Reponse.VRAI);
    }
    @Test
    void verite_et_affirmation_retourne_jenesaispas() {
        Assertions.assertEquals(calculateur.calculerLaValeur(verite_1, Conjonction.ET, affirmation_1), Reponse.JE_NE_SAIS_PAS);
    }
    @Test
    void verite_ou_affirmation_retourne_vrai() {
        Assertions.assertEquals(calculateur.calculerLaValeur(verite_1, Conjonction.OU, affirmation_1), Reponse.VRAI);
    }

    @Test
    void verite_donc_mensonge_retourne_faux(){
        Assertions.assertEquals(calculateur.calculerLaValeur(verite_1, Conjonction.DONC, mensonge_1), Reponse.FAUX);
    }
    @Test
    void verite_donc_affirmation_retourne_faux(){
        Assertions.assertEquals(calculateur.calculerLaValeur(verite_1, Conjonction.DONC, mensonge_1), Reponse.FAUX);
    }
    @Test
    void mesonge_donc_verite_retourne_vrai(){
        Assertions.assertEquals(calculateur.calculerLaValeur(mensonge_1, Conjonction.DONC, verite_1), Reponse.VRAI);
    }


}
