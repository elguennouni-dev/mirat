package elguennouni.dev.mirat.util;

import elguennouni.dev.mirat.contsants.ShareType;
import elguennouni.dev.mirat.exception.InvalidWasiyaException;
import elguennouni.dev.mirat.exception.InvalidWealthException;
import elguennouni.dev.mirat.model.*;
import elguennouni.dev.mirat.relationship.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class MathUtils {

    public DistributionResult calculate(InheritanceCase inheritanceCase) {
        Tarika tarika = inheritanceCase.getTarika();
        List<Warith> heirs = inheritanceCase.getHeirs();

        BigDecimal netEstate = calculateNetEstate(tarika);

        List<Warith> eligibleHeirs = applyExclusionRules(heirs);
        Map<Warith, Fraction> fixedShares = applyFixedShareRules(eligibleHeirs);

        boolean isAwl = checkAwl(fixedShares);
        if (isAwl) fixedShares = applyAwl(fixedShares);

        Map<Warith, Fraction> allShares = distributeRemainingToAsaba(eligibleHeirs, fixedShares);

        return calculateFinalResult(allShares, netEstate, heirs);

    }


    private BigDecimal calculateNetEstate(Tarika tarika) throws InvalidWealthException, InvalidWasiyaException {
        return tarika.getTotalWealth()
                .subtract(tarika.getDebts()
                        .add(tarika.getFuneralCosts())
                        .add(tarika.getWasiya()));
    }

    private List<Warith> applyExclusionRules(List<Warith> heirs) {
        List<Warith> filtered = heirs.stream()
                .filter(Warith::isEligible)
                .collect(Collectors.toList());

        boolean hasFather = filtered.stream().anyMatch(w -> w.getRelation() == Usol.AB);
        boolean hasSon = filtered.stream().anyMatch(w -> w.getRelation() == Forou.IBN);
        boolean hasMother = filtered.stream().anyMatch(w -> w.getRelation() == Usol.OMM);
        boolean hasAsaba = filtered.stream().anyMatch(w -> w.getRelation().isAsaba());

        if (hasFather) {
            filtered = removeRelations(filtered, Usol.JAD, Usol.JADA);
        }

        if (hasAsaba) {
            filtered = removeRelations(filtered, Others.DO_AR7AM, Others.KHONTA, Others.MOTA3ATIQ);
        }

        if (hasFather || hasSon) {
            filtered = removeRelations(filtered,
                    Ikhwa.AKH_SHAQIQ, Ikhwa.OKHT_SHAQIQA,
                    Ikhwa.AKH_AB, Ikhwa.OKHT_AB,
                    Ikhwa.AKH_OMM, Ikhwa.OKHT_OMM,
                    A3mam._3AM_SHAQIQ, A3mam._3AM_AB,
                    A3mam.IBN_AKH
            );
        }

        return filtered;
    }

    private List<Warith> removeRelations(List<Warith> input, WarithRelation... relationsToRemove) {
        Set<WarithRelation> set = new HashSet<>(Arrays.asList(relationsToRemove));
        return input.stream()
                .filter(w -> !set.contains(w.getRelation()))
                .collect(Collectors.toList());
    }

    private Map<Warith, Fraction> applyFixedShareRules(List<Warith> heirs) {
        Map<Warith, Fraction> fixedShares = new HashMap<>();

        boolean hasChild = heirs.stream().anyMatch(w ->
                w.getRelation() == Forou.IBN || w.getRelation() == Forou.IBNA);

        boolean hasMoreThanOneSiblingFromMother = heirs.stream()
                .filter(w -> w.getRelation() == Ikhwa.AKH_OMM || w.getRelation() == Ikhwa.OKHT_OMM)
                .count() > 1;
        long daughters = heirs.stream()
                .filter(w -> w.getRelation() == Forou.IBNA)
                .count();
        long sons = heirs.stream()
                .filter(w -> w.getRelation() == Forou.IBN)
                .count();

        for (Warith warith : heirs) {
            WarithRelation rel = warith.getRelation();

            if (!rel.isFard()) continue;
            Fraction share = null;

            if (rel == Zawjiya.ZAWJ) {
                share = hasChild ? Fraction.of(1,4) : Fraction.of(1,2);
            } else if (rel == Zawjiya.ZAWJA) {
                share = hasChild ? Fraction.of(1,8) : Fraction.of(1,4);
            } else if (rel == Usol.OMM) {
                if (hasChild || hasMoreThanOneSiblingFromMother) {
                    share = Fraction.of(1,6);
                }else {
                    share = Fraction.of(1,3);
                }
            } else if (rel == Usol.AB) {
                if(hasChild) {
                    share = Fraction.of(1,6);
                }
            } else if (rel == Usol.JAD) {
                if (hasChild) {
                    share = Fraction.of(1,6);
                }
            } else if (rel == Usol.JADA) {
                share = Fraction.of(1,6);
            } else if (rel == Forou.IBNA) {
                if(daughters == 1 && sons == 0) {
                    share = Fraction.of(1,2);
                } else if (daughters >= 2 && sons == 0) {
                    share = Fraction.of(2,3);
                }
            } else if (rel == Forou.BINT_IBN) {
                long bintCount = heirs.stream()
                        .filter(w -> w.getRelation() == Forou.IBNA)
                        .count();
                long bintIbnCount = heirs.stream()
                        .filter(w -> w.getRelation() == Forou.BINT_IBN)
                        .count();

                if (bintCount == 0 && bintIbnCount == 1) {
                    share = Fraction.of(1,2);
                } else if (bintCount == 1 && bintIbnCount == 1) {
                    share = Fraction.of(1,6);
                } else if (bintCount == 0 && bintIbnCount > 1) {
                    share = Fraction.of(2,3);
                }
            } else if (rel == Ikhwa.OKHT_SHAQIQA) {
                if (!hasChild && sons == 0) {
                    long okhtCount = heirs.stream()
                            .filter(w -> w.getRelation() == Ikhwa.OKHT_SHAQIQA)
                            .count();
                    share = okhtCount == 1 ? Fraction.of(1,2) : Fraction.of(2,3);
                }
            } else if (rel == Ikhwa.AKH_OMM || rel == Ikhwa.OKHT_OMM) {
                long ikhwaOmmCount = heirs.stream()
                        .filter(w -> w.getRelation() == Ikhwa.AKH_OMM || w.getRelation() == Ikhwa.OKHT_OMM)
                        .count();
                share = ikhwaOmmCount == 1 ? Fraction.of(1,6) : Fraction.of(1,3);
            }

            if (share != null) {
                fixedShares.put(warith, share);
            }

        }

        return fixedShares;

    }
    private boolean checkAwl(Map<Warith, Fraction> shares) {
        Fraction total = Fraction.of(0,1);
        for(Fraction share: shares.values()) {
            total = total.add(share);
        }
        return total.compareTo(Fraction.of(1,1)) > 0;
    }

    private Map<Warith, Fraction> applyAwl(Map<Warith, Fraction> shares) {
        Fraction total = Fraction.of(0,1);
        for (Fraction share : shares.values()) {
            total = total.add(share);
        }
        if (total.compareTo(Fraction.of(1,1)) <= 0) {
            return shares;
        }
        Fraction awlFactor = new Fraction(1,1).multiply(
                Fraction.of(total.getDenominator(), total.getNumerator())
        );

        Map<Warith, Fraction> adjusted = new HashMap<>();
        for (Map.Entry<Warith, Fraction> entry : shares.entrySet()) {
            Fraction adjustedShare = entry.getValue().multiply(awlFactor);
            adjusted.put(entry.getKey(), adjustedShare);
        }

        return adjusted;
    }

    private Map<Warith, Fraction> distributeRemainingToAsaba(List<Warith> heirs, Map<Warith, Fraction> fixedShares) {
        Map<Warith, Fraction> allShares = new HashMap<>(fixedShares);

        Fraction totalFixed = Fraction.of(0,1);
        for (Fraction share : fixedShares.values()) {
            totalFixed = totalFixed.add(share);
        }

        Fraction remaining = Fraction.of(1,1).add(totalFixed.multiply(Fraction.of(-1,1)));

        List<Warith> eligibleAsaba = heirs.stream()
                .filter(w -> !fixedShares.containsKey(w) && w.getRelation().isAsaba() && w.isEligible())
                .collect(Collectors.toList());
        if (eligibleAsaba.isEmpty() || remaining.compareTo(Fraction.of(0,1)) <= 0) {
            return allShares;
        }

        int totalPortions = 0;
        Map<Warith, Integer> portions = new HashMap<>();

        for (Warith w : eligibleAsaba) {
            int p = (w.getGender() == Gender.MALE) ? 2 : 1;
            portions.put(w,p);
            totalPortions += p;
        }

        for (Map.Entry<Warith, Integer> entry : portions.entrySet()) {
            Warith w = entry.getKey();
            int p = entry.getValue();

            Fraction share = remaining.multiply(Fraction.of(p, totalPortions));
            allShares.put(w, share);
        }

        return allShares;

    }

    private DistributionResult calculateFinalResult(Map<Warith, Fraction> allShares, BigDecimal netEstate, List<Warith> heirs) {
        List<Share> resultShares = new ArrayList<>();
        List<Warith> excluded = new ArrayList<>();

        for (Warith h : heirs) {
            if (!allShares.containsKey(h)) {
                excluded.add(h);
            }
        }

        for (Map.Entry<Warith, Fraction> entry : allShares.entrySet()) {
            Warith w = entry.getKey();
            Fraction fraction = entry.getValue();

            BigDecimal amount = fraction.toDecimal(10).multiply(netEstate).setScale(2,RoundingMode.HALF_UP);

            ShareType type;

            if (w.getRelation().isFard()) {
                type = ShareType.FIXED;
            } else if (w.getRelation().isAsaba()) {
                type = ShareType.ASABA;
            }else {
                type = ShareType.MAA_GHAYR;
            }
            resultShares.add(new Share(w,fraction,amount,type));
        }

        boolean hasAwl = checkAwl(allShares);

        return new DistributionResult(netEstate, resultShares,excluded,hasAwl);
    }



}
