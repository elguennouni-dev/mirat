package elguennouni.dev.mirat;

import elguennouni.dev.mirat.model.DistributionResult;
import elguennouni.dev.mirat.model.Share;
import elguennouni.dev.mirat.model.Tarika;
import elguennouni.dev.mirat.model.Warith;
import elguennouni.dev.mirat.relationship.*;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Define the Tarika (Estate)
            Tarika tarika = new Tarika(
                    new BigDecimal("100000"),
                    new BigDecimal("10000"),
                    new BigDecimal("5000"),
                    new BigDecimal("2000")
            );

            // 2. Create a list of Heirs
            List<Warith> heirs = List.of(
                    new Warith("الأب", Usol.AB, Gender.MALE, true, true, false),
                    new Warith("الزوجة", Zawjiya.ZAWJA, Gender.FEMALE, true, true, false),
                    new Warith("الإبن", Forou.IBN, Gender.MALE, true, true, false),
                    new Warith("الإبنة", Forou.IBNA, Gender.FEMALE, true, true, false),
                    new Warith("الأخ الشقيق", Ikhwa.AKH_SHAQIQ, Gender.MALE, true, true, false)
            );

            // 3. Instantiate Mirat and calculate the shares
            Mirat mirat = new Mirat(tarika, heirs);
            DistributionResult result = mirat.calculate();

            // 4. Print the Results
            System.out.println("صافي التركة: " + mirat.getNetEstates());
            System.out.println("هل هناك عول؟ " + (mirat.hasAwl() ? "نعم" : "لا"));
            System.out.println("\nتفاصيل الحصص:");
            for (Share share : mirat.getShares()) {
                System.out.printf("الوارث: %s - النسبة: %s - المبلغ: %s - النوع: %s\n",
                        share.getWarith().getName(),
                        share.getFraction(),
                        share.getAmount(),
                        share.getType());
            }

            System.out.println("\nتصدير كـ نص:");
            System.out.println(mirat.exportAsText());

        } catch (Exception e) {
            System.err.println("خطأ أثناء الحساب: " + e.getMessage());
            e.printStackTrace();
        }
    }
}