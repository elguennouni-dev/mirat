package com.messanger.app.relationship;

public enum Usol implements WarithRelation {
    AB("أب", true) {
        @Override public boolean isFard() { return true; }
        @Override public boolean isAsaba() { return true; }
    },

    OMM("أم", false) {
        @Override public boolean isFard() { return true; }
    },

    JAD("جد", true) {
        @Override public boolean isAsaba() { return true; }
        @Override public boolean isFard() { return true; }
    },

    JADA("جدة", false) {
        @Override public boolean isFard() { return true; }
    };

    private final String arabicName;
    private final boolean isMale;

    Usol(String arabicName, boolean isMale) {
        this.arabicName = arabicName;
        this.isMale = isMale;
    }

    public String getArabicName() { return arabicName; }
    public boolean isMale() { return isMale; }

    @Override
    public String toString() { return arabicName; }
}
