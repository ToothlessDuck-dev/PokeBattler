package org.example.BattleLogic;

import org.example.model.Element;
import java.util.Map;

public class ElementEffectiveness {

    // Inehåller hur effektivt varje element är mot andra element
    private static final Map<Element, Map<Element, Double>> chart = Map.of(
            Element.FIRE, Map.of(
                    Element.GRASS, 2.0,
                    Element.WATER, 0.5
            ),

            Element.WATER, Map.of(
                    Element.FIRE, 2.0,
                    Element.GRASS, 0.5
            ),

            Element.GRASS, Map.of(
                    Element.WATER, 2.0,
                    Element.FIRE, 0.5
            ),

            Element.ELECTRIC, Map.of(
                    Element.WATER, 2.0
            ),

            Element.NORMAL, Map.of()
    );

    // Hämntar skade-multiplikatorn för attackens och försvararens element
    public static double getMultiplier(Element attackElement, Element defenderElement){

        // Ifall ingen specifik kombination finns används 1.0 som standard
        return chart
                .getOrDefault(attackElement, Map.of())
                .getOrDefault(defenderElement, 1.0);
    }
}
