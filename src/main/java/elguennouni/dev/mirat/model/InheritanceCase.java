package elguennouni.dev.mirat.model;

import java.util.List;

public class InheritanceCase {
    Tarika tarika;
    List<Warith> heirs;

    public InheritanceCase() {

    }

    public InheritanceCase(Tarika tarika, List<Warith> heirs) {
        this.tarika = tarika;
        this.heirs = heirs;
    }

    public Tarika getTarika() {
        return tarika;
    }

    public List<Warith> getHeirs() {
        return heirs;
    }

    public void setTarika(Tarika tarika) {
        this.tarika = tarika;
    }

    public void setHeirs(List<Warith> heirs) {
        this.heirs = heirs;
    }
}
