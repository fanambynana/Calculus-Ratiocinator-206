package org.example.outils;

import org.example.Calculateur;
import org.example.Enum.Conjonction;
import org.example.affirmations.Affirmer;

public class CreateurAffirmationCompose {
    Calculateur calculateur;

    public CreateurAffirmationCompose() {
        this.calculateur = new Calculateur();
    }

    public Affirmer creerAffirmationCompose(Affirmer affirmation_a, Conjonction conjonction, Affirmer affirmation_b) {
        return calculateur.calculer(affirmation_a, conjonction, affirmation_b);
    }
}
