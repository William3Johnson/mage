package mage.sets;

import mage.cards.ExpansionSet;
import mage.constants.Rarity;
import mage.constants.SetType;

/**
 * @author TheElk801
 */
public final class Commander2021Edition extends ExpansionSet {

    private static final Commander2021Edition instance = new Commander2021Edition();

    public static Commander2021Edition getInstance() {
        return instance;
    }

    private Commander2021Edition() {
        super("Commander 2021 Edition", "C21", ExpansionSet.buildDate(2021, 4, 23), SetType.SUPPLEMENTAL);
        this.blockName = "Command Zone";
        this.hasBasicLands = false;
    }
}