package com.messanger.app.model;

import com.messanger.app.relationship.Gender;
import com.messanger.app.relationship.WarithRelation;

public class Warith {
    String name;
    WarithRelation relation;
    Gender gender;
    boolean isAlive;
    boolean isMuslim;
    boolean killedDeceased;





    public Warith(String name, WarithRelation relation, Gender gender, boolean isAlive, boolean isMuslim, boolean killedDeceased) {
        if (name == null || relation == null)
            throw new IllegalArgumentException("Missing required info of Al Warith!");

        this.name = name;
        this.relation = relation;
        this.gender = gender;
        this.isAlive = isAlive;
        this.isMuslim = isMuslim;
        this.killedDeceased = killedDeceased;
    }




    public String getName() {
        return name;
    }

    public WarithRelation getRelation() {
        return relation;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isKilledDeceased() {
        return killedDeceased;
    }

    public boolean isMuslim() {
        return isMuslim;
    }



    private void setName(String name) {
        this.name = name;
    }

    private void setAlive(boolean alive) {
        isAlive = alive;
    }

    private void setKilledDeceased(boolean killedDeceased) {
        this.killedDeceased = killedDeceased;
    }

    private void setMale(Gender gender) {
        gender = gender;
    }

    private void setMuslim(boolean muslim) {
        isMuslim = muslim;
    }

    private void setRelation(WarithRelation relation) {
        this.relation = relation;
    }



    public boolean isEligible() {
        return isAlive && isMuslim && !killedDeceased;
    }

    @Override
    public String toString() {
        return "الوارث: " + name +
                " | القرابة: " + relation.toString() +
                " | الجنس: " + gender.getArabicName() +
                " | الحالة: " + (isAlive ? "حي" : "ميت") +
                " | الديانة: " + (isMuslim ? "مسلم" : "غير مسلم") +
                " | قتل المورث: " + (killedDeceased ? "نعم" : "لا");
    }


}
