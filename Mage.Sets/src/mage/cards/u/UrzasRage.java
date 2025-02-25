package mage.cards.u;

import mage.abilities.Ability;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.condition.common.KickedCondition;
import mage.abilities.decorator.ConditionalOneShotEffect;
import mage.abilities.effects.Effect;
import mage.abilities.effects.common.CantBeCounteredSourceEffect;
import mage.abilities.effects.common.DamageTargetEffect;
import mage.abilities.keyword.KickerAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Zone;
import mage.target.common.TargetAnyTarget;

import java.util.UUID;

/**
 * @author FenrisulfrX
 */
public final class UrzasRage extends CardImpl {

    public UrzasRage(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.INSTANT}, "{2}{R}");

        // Kicker {8}{R}
        this.addAbility(new KickerAbility("{8}{R}"));

        // Urza's Rage can't be countered.
        Effect effect = new CantBeCounteredSourceEffect();
        effect.setText("this spell can't be countered");
        Ability ability = new SimpleStaticAbility(Zone.STACK, effect);
        ability.setRuleAtTheTop(true);
        this.addAbility(ability);

        // Urza's Rage deals 3 damage to any target. If Urza's Rage was kicked, instead it deals 10 damage to that creature or player and the damage can't be prevented.
        this.getSpellAbility().addEffect(new ConditionalOneShotEffect(
                new DamageTargetEffect(10, false), new DamageTargetEffect(3),
                KickedCondition.ONCE, "{this} deals 3 damage to any target. If this spell was kicked, " +
                "instead it deals 10 damage to that permanent or player and the damage can't be prevented."
        ));
        this.getSpellAbility().addTarget(new TargetAnyTarget());
    }

    private UrzasRage(final UrzasRage card) {
        super(card);
    }

    @Override
    public UrzasRage copy() {
        return new UrzasRage(this);
    }
}
