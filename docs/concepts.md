# Core Concepts

The Mirat library is built around a few core concepts that represent the key elements of an inheritance case.

## Tarika (The Estate)

The `Tarika` class represents the estate of the deceased. Before the inheritance can be distributed, certain deductions must be made from the total wealth. A `Tarika` object is initialized with:

* `totalWealth`: The total value of the assets left by the deceased.
* `debts`: Any outstanding debts that must be paid.
* `wasiya`: The value of any bequests (wasiya), which cannot exceed one-third of the wealth after debts and funeral costs.
* `funeralCosts`: The costs associated with the burial.

The library validates these values upon instantiation, throwing exceptions for negative amounts or an invalid `wasiya`.

## Warith (The Heir)

The `Warith` class represents an heir. Each heir has several attributes that determine their eligibility and share:

* `name`: The name of the heir.
* `relation`: The heir's relationship to the deceased, defined by the `WarithRelation` interface.
* `gender`: The gender of the heir.
* `isAlive`, `isMuslim`, `killedDeceased`: Boolean flags that determine the heir's eligibility (`isEligible()`).

## WarithRelation (Heir Relationship)

`WarithRelation` is an interface implemented by a series of `enum`s that define the different types of relationships. This allows for a structured and type-safe way to specify each heir's connection to the deceased. The main relationship categories include:

* `Usol`: Ascendants (father, mother, grandfather, grandmother).
* `Forou`: Descendants (son, daughter, son's son, son's daughter).
* `Ikhwa`: Siblings (full, paternal, and maternal brothers and sisters).
* `Zawjiya`: Spouses (husband, wife).

## Share (The Inheritance Share)

The `Share` class represents the calculated inheritance portion for a single heir. It contains:

* `warith`: The heir receiving the share.
* `fraction`: The fractional portion of the estate the heir is entitled to.
* `amount`: The final monetary value of the share.
* `type`: The type of share, such as `FIXED`, `ASABA`, or `MAA_GHAYR`.

## DistributionResult

The `DistributionResult` is a container object returned by the `calculate()` method. It encapsulates the complete outcome of the inheritance calculation, including:

* A list of `Share` objects for all eligible heirs.
* A list of excluded heirs.
* The net value of the estate.
* A boolean flag indicating if the `Awl` (increase) principle was applied.