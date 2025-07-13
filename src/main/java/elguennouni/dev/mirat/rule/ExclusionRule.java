package elguennouni.dev.mirat.rule;

import elguennouni.dev.mirat.model.Warith;

import java.util.List;

public interface ExclusionRule {
    boolean isExcluded(Warith target, List<Warith> all);
}
