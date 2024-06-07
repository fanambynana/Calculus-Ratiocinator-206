package org.example.affirmations;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.Enum.Valeur;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Affirmation extends Affirmer {
    public Affirmation(String phrase) {
        super(phrase, Valeur.VRAI_OU_FAUX);
    }
}
