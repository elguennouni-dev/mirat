package elguennouni.dev.mirat.relationship;

public enum Forou implements WarithRelation {
    IBN("إبن", true) {
        @Override
        public boolean isAsaba() {
            return true;
        }
    },

    IBNA("إبنة", false) {
        @Override
        public boolean isFard() {
            return true;
        }

        @Override
        public boolean isAsaba() {
            return true;
        }
    },

    IBN_IBN("إبن الإبن", true) {
        @Override
        public boolean isAsaba() {
            return true;
        }
    },

    BINT_IBN("بنت الإبن", false) {
        @Override
        public boolean isFard() {
            return true;
        }

        @Override
        public boolean isAsaba() {
            return true;
        }
    };

    private final String arabicName;
    private final boolean isMale;

    Forou(String arabicName, boolean isMale) {
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