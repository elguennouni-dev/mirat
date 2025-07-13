package elguennouni.dev.mirat.relationship;

public enum A3mam implements WarithRelation {
    _3AM_SHAQIQ("عم شقيق", true) {
        @Override public boolean isAsaba() { return true; }
    },
    _3AM_AB("عم الأب", true) {
        @Override public boolean isAsaba() { return true; }
    },
    _3AM("عم", true) {
        @Override public boolean isAsaba() { return true; }
    },
    IBN_3AM("ابن العم", true) {
        @Override public boolean isAsaba() { return true; }
    },
    IBN_AKH("ابن الأخ", true) {
        @Override public boolean isAsaba() { return true; }
    };

    private final String arabicName;
    private final boolean isMale;

    A3mam(String arabicName, boolean isMale) {
        this.arabicName = arabicName;
        this.isMale = isMale;
    }

    public String getArabicName() { return arabicName; }
    public boolean isMale() { return isMale; }

    @Override
    public String toString() { return arabicName; }
}
