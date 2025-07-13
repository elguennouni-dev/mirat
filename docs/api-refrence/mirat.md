# API Reference: Mirat Class

The `elguennouni.dev.mirat.Mirat` class is the main entry point for using the library.

## Constructor

### `public Mirat(Tarika tarika, List<Warith> heirs)`

Creates a new `Mirat` instance to perform an inheritance calculation.

* **Parameters:**
    * `tarika`: A `Tarika` object representing the estate.
    * `heirs`: A `List` of `Warith` objects representing the heirs.

## Methods

### `public DistributionResult calculate()`

Calculates the inheritance distribution based on the provided `Tarika` and `heirs`. This is the primary method to execute the calculation logic.

* **Returns:** A `DistributionResult` object containing the complete results of the calculation.

### `public List<Share> getShares()`

Returns the list of calculated shares for the eligible heirs.

* **Returns:** A `List` of `Share` objects.
* **Throws:** `IllegalStateException` if `calculate()` has not been called first.

### `public List<Warith> getExcludedHeirs()`

Returns the list of heirs who were excluded from inheritance due to the presence of other heirs.

* **Returns:** A `List` of excluded `Warith` objects.
* **Throws:** `IllegalStateException` if `calculate()` has not been called first.

### `public BigDecimal getNetEstates()`

Returns the net value of the estate after deducting debts, funeral costs, and bequests.

* **Returns:** A `BigDecimal` representing the net estate.
* **Throws:** `IllegalStateException` if `calculate()` has not been called first.

### `public boolean hasAwl()`

Checks if the `Awl` (increase) principle was applied during the calculation.

* **Returns:** `true` if `Awl` was applied, `false` otherwise.
* **Throws:** `IllegalStateException` if `calculate()` has not been called first.

### `public String exportAsText()`

Exports the distribution results as a formatted string in Arabic.

* **Returns:** A `String` containing the formatted results.
* **Throws:** `IllegalStateException` if `calculate()` has not been called first.