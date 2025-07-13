package elguennouni.dev.mirat.relationship;

public enum Zawjiya implements WarithRelation {
    ZAWJ("زوج", true) {
        @Override
        public boolean isFard() {
            return true;
        }
    },

    ZAWJA("زوجة", false) {
        @Override
        public boolean isFard() {
            return true;
        }
    };

    private final String arabicName;
    private final boolean isMale;

    Zawjiya(String arabicName, boolean isMale) {
        this.arabicName = arabicName;
        this.isMale = isMale;
    }

    public String getArabicName() {
        return arabicName;
    }

    public boolean isMale() {
        return isMale;
    }

    @Override
    public String toString() {
        return arabicName;
    }
}
