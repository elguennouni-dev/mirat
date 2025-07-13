package elguennouni.dev.mirat.relationship;

public enum Ikhwa implements WarithRelation {
    AKH_SHAQIQ("أخ شقيق", true) {
        @Override public boolean isAsaba() { return true; }
    },
    OKHT_SHAQIQA("أخت شقيقة", false) {
        @Override public boolean isFard() { return true; }
        @Override public boolean isAsaba() { return true; }
    },

    AKH_AB("أخ من الأب", true) {
        @Override public boolean isAsaba() { return true; }
    },
    OKHT_AB("أخت من الأب", false) {
        @Override public boolean isFard() { return true; }
        @Override public boolean isAsaba() { return true; }
    },

    AKH_OMM("أخ من الأم", true) {
        @Override public boolean isFard() { return true; }
    },
    OKHT_OMM("أخت من الأم", false) {
        @Override public boolean isFard() { return true; }
    },

    AKH("أخ", true),
    OKHT("أخت", false);

    private final String arabicName;
    private final boolean isMale;

    Ikhwa(String arabicName, boolean isMale) {
        this.arabicName = arabicName;
        this.isMale = isMale;
    }

    public String getArabicName() { return arabicName; }
    public boolean isMale() { return isMale; }

    @Override
    public String toString() { return arabicName; }
}
