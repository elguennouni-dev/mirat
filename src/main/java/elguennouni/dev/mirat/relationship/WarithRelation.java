package elguennouni.dev.mirat.relationship;

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
