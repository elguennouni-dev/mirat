<div align="center">
<img src="[https://raw.githubusercontent.com/elguennouni-dev/mirat/main/docs/assets/logo.png](https://www.google.com/search?q=https://raw.githubusercontent.com/elguennouni-dev/mirat/main/docs/assets/logo.png)" alt="Mirat Logo" width="150"/>
<h1>MiratLib (ميراث)</h1>
<p><strong>An Accurate and Modern Islamic Inheritance Calculation Library for Java</strong></p>
<p>
<a href="[https://github.com/elguennouni-dev/mirat/actions/workflows/maven.yml](https://www.google.com/search?q=https://github.com/elguennouni-dev/mirat/actions/workflows/maven.yml)">
<img src="[https://github.com/elguennouni-dev/mirat/actions/workflows/maven.yml/badge.svg](https://www.google.com/search?q=https://github.com/elguennouni-dev/mirat/actions/workflows/maven.yml/badge.svg)" alt="Java CI with Maven"/>
</a>
<a href="[https://opensource.org/licenses/MIT](https://opensource.org/licenses/MIT)">
<img src="[https://img.shields.io/badge/License-MIT-yellow.svg](https://www.google.com/search?q=https://img.shields.io/badge/License-MIT-yellow.svg)" alt="License: MIT"/>
</a>
<a href="[https://maven-badges.herokuapp.com/maven-central/elguennouni.dev.mirat/mirat](https://www.google.com/search?q=https://maven-badges.herokuapp.com/maven-central/elguennouni.dev.mirat/mirat)">
<img src="[https://img.shields.io/maven-central/v/elguennouni.dev.mirat/mirat.svg?label=Maven%20Central](https://www.google.com/search?q=https://img.shields.io/maven-central/v/elguennouni.dev.mirat/mirat.svg%3Flabel%3DMaven%2520Central)" alt="Maven Central"/>
</a>
</p>
</div>

Mirat is a modern, object-oriented Java library designed to accurately calculate the distribution of an estate according to the principles of Islamic inheritance law (Ilm al-Fara'id).

The library provides a clean and intuitive API for developers to model inheritance cases, define the estate (Tarika) and heirs (Warith), and compute precise fractional shares for each eligible individual. It is built to be robust, accurate, and easy to integrate into any Java application.

## Table of Contents

* Features
* Core Concepts
* Getting Started
* Installation
* Usage Example


* API Overview
* Contributing
* License

## Features

* **Accurate and Rule-Based:** Implements the core rules of Sunni inheritance for various types of heirs.
* **Object-Oriented Design:** Provides clear and type-safe classes for Tarika (estate), Warith (heir), and Share.
* **Comprehensive Relationship Modeling:** Includes a rich set of enums to represent heir relationships (Usol, Forou, Ikhwa, Zawjiya, etc.).
* **Handles Complex Scenarios:** Automatically manages advanced cases such as:
* **Hajb (حجب):** Exclusion rules where certain heirs block others from inheriting.
* **Awl (عول):** Proportional reduction of shares when the total exceeds the estate.
* **Asaba (عصبة):** Distribution of the remainder to residuary heirs.


* **Clear Exception Handling:** Throws custom exceptions for invalid input data (InvalidWealthException, InvalidWasiyaException, etc.).
* **Text Export:** Provides a simple method to export the final distribution results as a formatted, human-readable string.

## Core Concepts

To use the library effectively, it is helpful to understand these key terms from Islamic law:

* **Tarika (التركة):** The net estate of the deceased after deducting debts, funeral costs, and bequests.
* **Warith (الوارث):** An heir who is potentially eligible to inherit.
* **Fard (فرض):** A prescribed, fixed fractional share of the estate (e.g., 1/2, 1/4, 1/8).
* **Asaba (عصبة):** Residuary heirs who inherit the remainder of the estate after the Fard shares have been distributed.
* **Hajb (حجب):** The principle of exclusion, where a closer heir can partially or fully exclude a more distant heir.
* **Awl (عول):** The principle of "increase," applied when the sum of Fard shares exceeds 1. All shares are proportionally reduced.

## Getting Started

### Installation

Mirat is built with Apache Maven. To include it in your project, add the following dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>elguennouni.dev.mirat</groupId>
    <artifactId>mirat</artifactId>
    <version>1.0.0</version> </dependency>

```

Then, run `mvn clean install` to download the dependency.

### Usage Example

Here is a quick example of how to calculate an inheritance case.

#### 1. Define the Estate (Tarika)

First, create a Tarika object with the financial details of the deceased.

```java
import elguennouni.dev.mirat.model.Tarika;
import java.math.BigDecimal;

// The estate includes total wealth, debts, bequests (wasiya), and funeral costs.
Tarika tarika = new Tarika(
        new BigDecimal("120000"), // Total Wealth
        new BigDecimal("10000"),  // Debts
        new BigDecimal("5000"),   // Wasiya (Bequest)
        new BigDecimal("2000")    // Funeral Costs
);

```

#### 2. Define the Heirs (Warith)

Next, create a list of all potential heirs with their relationship to the deceased.

```java
import elguennouni.dev.mirat.model.Warith;
import elguennouni.dev.mirat.relationship.*;
import java.util.List;

List<Warith> heirs = List.of(
    // A living, Muslim father who did not kill the deceased.
    new Warith("Father", Usol.AB, Gender.MALE, true, true, false),
    // A living, Muslim wife.
    new Warith("Wife", Zawjiya.ZAWJA, Gender.FEMALE, true, true, false),
    // A living, Muslim son.
    new Warith("Son", Forou.IBN, Gender.MALE, true, true, false),
    // A living, Muslim daughter.
    new Warith("Daughter", Forou.IBNA, Gender.FEMALE, true, true, false),
    // A full brother, who will be excluded (Hajb) by the son and father.
    new Warith("Full Brother", Ikhwa.AKH_SHAQIQ, Gender.MALE, true, true, false)
);

```

#### 3. Calculate and Display the Result

Finally, instantiate the Mirat class and call `calculate()` to get the distribution.

```java
import elguennouni.dev.mirat.Mirat;
import elguennouni.dev.mirat.model.DistributionResult;

try {
    Mirat mirat = new Mirat(tarika, heirs);
    DistributionResult result = mirat.calculate();

    System.out.println("--- Inheritance Calculation Result ---");
    System.out.println(mirat.exportAsText());

    System.out.println("\n--- Detailed Information ---");
    System.out.println("Net Estate for Distribution: " + mirat.getNetEstates());
    System.out.println("Was 'Awl' applied? " + mirat.hasAwl());

    System.out.println("\nExcluded Heirs:");
    mirat.getExcludedHeirs().forEach(heir -> System.out.println("- " + heir.getName()));

} catch (Exception e) {
    System.err.println("An error occurred during calculation: " + e.getMessage());
    e.printStackTrace();
}

```

## Expected Output

### Inheritance Calculation Result

صافي التركة: 103000.00

**تفاصيل الحصص:**

| الوريث | الحصة | القيمة | نوع الحصة |
| --- | --- | --- | --- |
| الأب | 1/6 | 17166.67 | ASABA |
| الزوجة | 1/8 | 12875.00 | FIXED |
| الابن | 14/48 | 30041.67 | ASABA |
| البنت | 7/48 | 15020.83 | ASABA |

### Detailed Information

| المعلومات | القيمة |
| --- | --- |
| Net Estate for Distribution | 103000.00 |
| Was 'Awl' applied? | false |

**Excluded Heirs:**

* Full Brother

## API Overview

* **Mirat:** The main class and entry point. It orchestrates the calculation.
* **Tarika:** Represents the estate of the deceased.
* **Warith:** Represents a single heir and their attributes.
* **WarithRelation:** An interface implemented by enums (Usol, Forou, Ikhwa, etc.) that define relationships.
* **DistributionResult:** A data object containing the results and a list of Share objects.
