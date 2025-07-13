package elguennouni.dev.mirat;

import elguennouni.dev.mirat.model.*;
import elguennouni.dev.mirat.util.MathUtils;

import java.math.BigDecimal;
import java.util.List;

public class Mirat {

    private Tarika tarika;
    private List<Warith> heirs;
    private MathUtils mathUtils;
    private DistributionResult result;

    public Mirat(Tarika tarika, List<Warith> heirs) {
        this.tarika = tarika;
        this.heirs = heirs;
        this.mathUtils = new MathUtils();
    };

    public DistributionResult calculate() {
        this.result = mathUtils.calculate(new InheritanceCase(tarika,heirs));
        return this.result;
    };

    public List<Share> getShares() {
        if (result == null) throw new IllegalStateException("Call calculate() first");
        return result.getShares();
    };

    public List<Warith> getExcludedHeirs() {
        if (result == null) throw new IllegalStateException("Call calculate() first");
        return result.getExcludedHeirs();
    };

    public BigDecimal getNetEstates() {
        if (result == null) throw new IllegalStateException("Call calculate() first");
        return result.getNetEstate();
    };

    public boolean hasAwl() {
        if (result == null) throw new IllegalStateException("Call calculate() first");
        return result.isHasAwl();
    };


    public String exportAsText() {
        if (result == null) throw new IllegalStateException("Call calculate() first");
        StringBuilder sb = new StringBuilder();
        sb.append("صافي التركة: ").append(result.getNetEstate()).append("\n\n");
        sb.append("تفاصيل الحصص:\n");
        for (Share share : result.getShares()) {
            sb.append(share.getWarith().getName())
                    .append(" : ")
                    .append(share.getFraction())
                    .append(" = ")
                    .append(share.getAmount())
                    .append(" (")
                    .append(share.getType())
                    .append(")\n");
        }
        return sb.toString();
    };

    // public String exportAsJson();
    // public String exportAsHtml();


}
