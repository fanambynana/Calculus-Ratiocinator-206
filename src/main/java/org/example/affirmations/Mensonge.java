package org.example.affirmations;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.Enum.Valeur;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Mensonge extends Affirmer {
    public Mensonge(String phrase) {
        super(phrase, Valeur.FAUX);
    }
}
