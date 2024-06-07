package org.example.affirmations;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Calculateur;
import org.example.Enum.Conjonction;
import org.example.Enum.Reponse;
import org.example.Enum.Valeur;

@AllArgsConstructor
@Data
public class Affirmer {
    private String phrase;
    private Valeur valeur;
}
