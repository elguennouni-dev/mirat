package com.messanger.app.model;

import java.math.BigDecimal;
import java.util.List;

public class DistributionResult {
    private BigDecimal netEstate;
    private List<Share> shares;
    private List<Warith> excludedHeirs;
    private boolean hasAwl;

    public DistributionResult(BigDecimal netEstate, List<Share> shares, List<Warith> excludedHeirs, boolean hasAwl) {
        this.netEstate = netEstate;
        this.shares = shares;
        this.excludedHeirs = excludedHeirs;
        this.hasAwl = hasAwl;
    }


    public void setNetEstate(BigDecimal netEstate) {
        this.netEstate = netEstate;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public void setExcludedHeirs(List<Warith> excludedHeirs) {
        this.excludedHeirs = excludedHeirs;
    }

    public void setHasAwl(boolean hasAwl) {
        this.hasAwl = hasAwl;
    }

    public BigDecimal getNetEstate() {
        return netEstate;
    }

    public List<Share> getShares() {
        return shares;
    }

    public List<Warith> getExcludedHeirs() {
        return excludedHeirs;
    }

    public boolean isHasAwl() {
        return hasAwl;
    }

}
