package elguennouni.dev.mirat.relationship;

public enum Gender {
    MALE("ذكر"),
    FEMALE("أنثى");

    private final String arabicName;

    Gender(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getArabicName() {
        return arabicName;
    }
}
