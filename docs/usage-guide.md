# Usage Guide: Real-life Scenarios

The Mirat library is designed to handle a variety of complex inheritance scenarios automatically. This guide explains how the library addresses some of these cases.

## Hajb (Exclusion)

*Hajb* is the principle by which some heirs can exclude others from inheritance, either completely or partially. Mirat implements these exclusion rules in the `applyExclusionRules` method of the `MathUtils` class.

For example:
* The presence of a son (`IBN`) will exclude all siblings (`AKH_SHAQIQ`, `OKHT_SHAQIQA`, etc.) and paternal uncles (`_3AM_SHAQIQ`, etc.).
* The presence of a father (`AB`) will exclude the grandfather (`JAD`) and all siblings.

The library automatically filters the initial list of heirs to create a list of `eligibleHeirs` before calculating the shares.

## Awl (Increase)

*Awl* occurs when the sum of the prescribed fractional shares (`Fard`) of the heirs is greater than 1 (i.e., the total estate). In this case, the denominator of all shares is increased proportionally to make the total sum equal to 1.

Mirat handles this scenario with the following methods in `MathUtils`:

1.  **`checkAwl(Map<Warith, Fraction> shares)`**: This method first calculates the sum of all fixed shares. If the sum is greater than 1, it returns `true`.

2.  **`applyAwl(Map<Warith, Fraction> shares)`**: If `Awl` is detected, this method recalculates all the shares by adjusting their denominators, ensuring the total distribution is correct.

The `hasAwl()` method in the `Mirat` class allows you to check if this principle was applied in the final result.

## Asaba (Residuary Heirs)

*Asaba* are heirs who do not have a fixed share but instead inherit the remainder of the estate after all the fixed-share (`Fard`) heirs have received their portions.

The `distributeRemainingToAsaba` method in `MathUtils` manages this distribution. It calculates the remaining portion of the estate and distributes it among the eligible residuary heirs, following the principle of "to the male, a portion equal to that of two females."