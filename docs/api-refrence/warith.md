# API Reference: Warith Class

The `model.elguennouni.dev.mirat.Warith` class represents an heir.

## Constructor

### `public Warith(String name, WarithRelation relation, Gender gender, boolean isAlive, boolean isMuslim, boolean killedDeceased)`

Creates a new `Warith` instance.

* **Parameters:**
    * `name`: The name of the heir.
    * `relation`: The heir's relationship to the deceased (e.g., `Usol.AB`, `Forou.IBN`).
    * `gender`: The gender of the heir (`Gender.MALE` or `Gender.FEMALE`).
    * `isAlive`: `true` if the heir is alive.
    * `isMuslim`: `true` if the heir is Muslim.
    * `killedDeceased`: `true` if the heir caused the death of the deceased.

## Methods

### `public String getName()`

* **Returns:** The name of the heir.

### `public WarithRelation getRelation()`

* **Returns:** The relationship of the heir to the deceased.

### `public Gender getGender()`

* **Returns:** The gender of the heir.

### `public boolean isAlive()`

* **Returns:** `true` if the heir is alive.

### `public boolean isMuslim()`

* **Returns:** `true` if the heir is Muslim.

### `public boolean isKilledDeceased()`

* **Returns:** `true` if the heir caused the death of the deceased.

### `public boolean isEligible()`

Checks if the heir is eligible for inheritance based on the conditions (`isAlive`, `isMuslim`, `!killedDeceased`).

* **Returns:** `true` if the heir is eligible, `false` otherwise.