package com.messanger.app.rule;

import com.messanger.app.model.Warith;

import java.util.List;

public interface ExclusionRule {
    boolean isExcluded(Warith target, List<Warith> all);
}
