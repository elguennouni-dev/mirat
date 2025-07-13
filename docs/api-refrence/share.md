# API Reference: Share Class

The `model.elguennouni.dev.mirat.Share` class represents the calculated inheritance portion for a single heir.

## Constructor

### `public Share(Warith warith, Fraction fraction, BigDecimal amount, ShareType type)`

Creates a new `Share` instance. This is typically done internally by the `MathUtils` class.

* **Parameters:**
    * `warith`: The `Warith` object receiving the share.
    * `fraction`: The `Fraction` of the estate.
    * `amount`: The final `BigDecimal` value of the share.
    * `type`: The `ShareType` (`FIXED`, `ASABA`, etc.).

## Methods

### `public Warith getWarith()`

* **Returns:** The `Warith` object associated with this share.

### `public Fraction getFraction()`

* **Returns:** The fractional portion of the estate.

### `public BigDecimal getAmount()`

* **Returns:** The final monetary value of the share.

### `public ShareType getType()`

* **Returns:** The type of share.