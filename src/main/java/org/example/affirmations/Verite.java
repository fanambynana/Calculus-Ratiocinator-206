package org.example.affirmations;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.Enum.Valeur;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Verite extends Affirmer {
    public Verite(String phrase) {
        super(phrase, Valeur.VRAI);
    }
}
