package elguennouni.dev.mirat.relationship;

import java.util.ArrayList;
import java.util.List;

public abstract class AllRelations {
    public static final Class<?>[] ALL_RELATION_ENUMS = new Class<?>[] {
            Usol.class, Forou.class, Ikhwa.class, Zawjiya.class, Others.class
    };

    public static List<WarithRelation> getAllRelations() {
        List<WarithRelation> list = new ArrayList<>();
        for (Class<?> clazz : ALL_RELATION_ENUMS) {
            for (Object constant : clazz.getEnumConstants()) {
                list.add((WarithRelation) constant);
            }
        }
        return list;
    }

}
