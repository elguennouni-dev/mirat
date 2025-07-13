# Getting Started with Mirat

This guide will walk you through setting up the Mirat library in your project and running your first inheritance calculation.

## Installation

Mirat is built with Apache Maven, making it easy to include in your Java projects.

### Maven Dependency

Add the following dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>com.messanger.app</groupId>
    <artifactId>Mirat</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

**Your First Calculation**

Here is a simple example of how to use Mirat to calculate inheritance, based on the Main.java file.
1. Define the Tarika (Estate): Specify the total wealth, debts, bequests (wasiya), and funeral costs. 
2. Create the Warith (Heirs) List: Define each heir with their name, relationship, gender, and other relevant details. 
3. Instantiate Mirat and Calculate: Create an instance of the Mirat class and call the calculate() method. 
4. View the Results: Access the distribution results, including the shares of each heir and the net estate.

### Example Code

```java
import elguennouni.dev.mirat.Mirat;
import elguennouni.dev.mirat.model.DistributionResult;
import elguennouni.dev.mirat.model.Share;
import elguennouni.dev.mirat.model.Tarika;
import elguennouni.dev.mirat.model.Warith;
import elguennouni.dev.mirat.relationship.Forou;
import elguennouni.dev.mirat.relationship.Gender;
import elguennouni.dev.mirat.relationship.Usol;
import elguennouni.dev.mirat.relationship.Zawjiya;

import java.math.BigDecimal;
import java.util.List;

public class MyFirstCalculation {
    public static void main(String[] args) {
        try {
            // 1. Define the Tarika (Estate)
            Tarika tarika = new Tarika(
                    new BigDecimal("100000"), // Total Wealth
                    new BigDecimal("10000"),  // Debts
                    new BigDecimal("5000"),   // Wasiya (Bequest)
                    new BigDecimal("2000")    // Funeral Costs
            );

            // 2. Create a list of Heirs
            List<Warith> heirs = List.of(
                    new Warith("الأب", Usol.AB, Gender.MALE, true, true, false),
                    new Warith("الزوجة", Zawjiya.ZAWJA, Gender.FEMALE, true, true, false),
                    new Warith("الإبن", Forou.IBN, Gender.MALE, true, true, false)
            );

            // 3. Instantiate Mirat and calculate the shares
            Mirat mirat = new Mirat(tarika, heirs);
            DistributionResult result = mirat.calculate();

            // 4. Print the results
            System.out.println("Net Estate: " + mirat.getNetEstates());
            System.out.println("Has Awl? " + (mirat.hasAwl() ? "Yes" : "No"));
            System.out.println("\nShare Details:");
            for (Share share : mirat.getShares()) {
                System.out.printf("Heir: %s, Fraction: %s, Amount: %s, Type: %s\n",
                        share.getWarith().getName(),
                        share.getFraction(),
                        share.getAmount(),
                        share.getType());
            }

        } catch (Exception e) {
            System.err.println("Error during calculation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```