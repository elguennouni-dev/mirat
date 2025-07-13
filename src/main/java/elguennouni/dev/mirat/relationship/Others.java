package elguennouni.dev.mirat.relationship;

public enum Others implements WarithRelation {
    MOTA3ATIQ("المُعتِق") {
        @Override
        public boolean isDoArham() {
            return true;
        }
    },

    KHONTA("الخنثى") {
        @Override
        public boolean isDoArham() {
            return true;
        }
    },

    DO_AR7AM("ذو رحم") {
        @Override
        public boolean isDoArham() {
            return true;
        }
    };

    private final String arabicName;

    Others(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicName() {
        return arabicName;
    }

    @Override
    public String toString() {
        return arabicName;
    }
}
