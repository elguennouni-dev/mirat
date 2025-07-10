package com.messanger.app.rule;

import com.messanger.app.contsants.ShareType;
import com.messanger.app.model.Fraction;
import com.messanger.app.model.Warith;

import java.util.List;

public interface ShareRule {
    boolean appliesTo(Warith warith, List<Warith> all);
    Fraction getFraction(Warith warith, List<Warith> all);
    ShareType getShareType();
}
