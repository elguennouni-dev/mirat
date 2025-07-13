# Welcome to Mirat

Mirat is a powerful and easy-to-use Java library for calculating Islamic inheritance (`علم الفرائض` => `The science of Inheritance`). It provides a modern, object-oriented approach to a traditionally complex set of rules, making it accessible to developers for integration into their applications.

The library is designed with clarity and accuracy in mind, offering a comprehensive set of tools to model an estate (`Tarika`), define heirs (`Warith`) and their relationships, and compute the precise distribution of shares.

## Key Features

* **Accurate Inheritance Calculation**: Implements the core rules of Islamic inheritance for various types of heirs.
* **Object-Oriented Design**: Provides clear and intuitive classes for representing the `Tarika` (estate), `Warith` (heir), and their `Share`s.
* **Detailed Relationship Modeling**: Includes a comprehensive set of `enum`s to represent the different relationships of heirs to the deceased (e.g., `Usol`, `Forou`, `Ikhwa`, `Zawjiya`).
* **Advanced Scenarios**: Automatically handles complex cases like `Awl` (increase) and `Hajb` (exclusion).
* **Custom Exceptions**: Provides a set of custom exceptions to handle invalid input data, such as `InvalidWealthException`, `InvalidDebtException`, and `InvalidWasiyaException`.
* **Text Export**: The distribution results can be easily exported as a formatted text string.

Whether you are building an educational tool, a financial application, or any other software that requires Islamic inheritance calculations, Mirat provides the foundation you need.