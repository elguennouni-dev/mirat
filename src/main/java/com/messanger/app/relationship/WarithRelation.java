package com.messanger.app.relationship;

public interface WarithRelation {
    String name();

    default boolean isAsaba() {
        return false;
    }

    default boolean isFard() {
        return false;
    }

    default boolean isDoArham() {
        return false;
    }

}
