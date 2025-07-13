# API Reference: Tarika Class

The `model.elguennouni.dev.mirat.Tarika` class represents the estate of the deceased.

## Constructor

### `public Tarika(BigDecimal totalWealth, BigDecimal debts, BigDecimal wasiya, BigDecimal funeralCosts)`

Creates a new `Tarika` instance.

* **Parameters:**
    * `totalWealth`: The total value of the assets.
    * `debts`: Any outstanding debts.
    * `wasiya`: The value of any bequests (cannot exceed 1/3 of the net wealth).
    * `funeralCosts`: The costs associated with the burial.
* **Throws:**
    * `InvalidWealthException`: If `totalWealth` is negative.
    * `InvalidDebtException`: If `debts` is negative.
    * `InvalidWasiyaException`: If `wasiya` is negative or exceeds one-third of the wealth.

## Methods

### `public BigDecimal getTotalWealth()`

* **Returns:** The total wealth of the estate.

### `public BigDecimal getDebts()`

* **Returns:** The total debts.

### `public BigDecimal getWasiya()`

* **Returns:** The amount of the bequest (`wasiya`).

### `public BigDecimal getFuneralCosts()`

* **Returns:** The funeral costs.