package elguennouni.dev.mirat.rule;

import elguennouni.dev.mirat.contsants.ShareType;
import elguennouni.dev.mirat.model.Fraction;
import elguennouni.dev.mirat.model.Warith;

import java.util.List;

public interface ShareRule {
    boolean appliesTo(Warith warith, List<Warith> all);
    Fraction getFraction(Warith warith, List<Warith> all);
    ShareType getShareType();
}
