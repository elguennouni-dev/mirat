# API Reference: Exceptions

The Mirat library uses custom exceptions to handle invalid input and other error conditions.

### `InvalidWealthException`

* **Description:** Thrown by the `Tarika` constructor if the `totalWealth` value is negative.
* **Parent Class:** `RuntimeException`

### `InvalidDebtException`

* **Description:** Thrown by the `Tarika` constructor if the `debts` value is negative.
* **Parent Class:** `RuntimeException`

### `InvalidWasiyaException`

* **Description:** Thrown by the `Tarika` constructor if the `wasiya` value is negative or exceeds one-third of the net wealth.
* **Parent Class:** `RuntimeException`

### `RuleConflictException`

* **Description:** A placeholder for potential future use where a conflict in inheritance rules might occur.
* **Parent Class:** `RuntimeException`