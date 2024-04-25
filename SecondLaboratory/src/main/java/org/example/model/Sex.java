package org.example.model;

public enum Sex {
    MALE("Male"),
    FEMALE("Female"),
    AGENDER("Agender"),
    ANDROGYNE("Androgyne"),
    BIGENDER("Bigender"),
    CIS("Cis"),
    CISGENDER("Cisgender"),
    CIS_FEMALE("Cis Female"),
    CIS_MALE("Cis Male"),
    CIS_MAN("Cis Man"),
    CIS_WOMAN("Cis Woman"),
    CISGENDER_FEMALE("Cisgender Female"),
    CISGENDER_MALE("Cisgender Male"),
    CISGENDER_MAN("Cisgender Man"),
    CISGENDER_WOMAN("Cisgender Woman"),
    FEMALE_TO_MALE("Female to Male"),
    FTM("FTM"),
    GENDER_FLUID("Gender Fluid"),
    GENDER_NONCONFORMING("Gender Nonconforming"),
    GENDER_QUESTIONING("Gender Questioning"),
    GENDER_VARIANT("Gender Variant"),
    GENDERQUEER("Genderqueer"),
    INTERSEX("Intersex"),
    MALE_TO_FEMALE("Male to Female"),
    MTF("MTF"),
    NEITHER("Neither"),
    NEUTROIS("Neutrois"),
    NON_BINARY("Non-binary"),
    OTHER("Other"),
    PANGENDER("Pangender"),
    TRANS("Trans"),
    TRANS_FEMALE("Trans Female"),
    TRANS_MALE("Trans Male"),
    TRANS_MAN("Trans Man"),
    TRANS_WOMAN("Trans Woman"),
    TRANSFEMININE("Transfeminine"),
    TRANSGENDER("Transgender"),
    TRANSGENDER_FEMALE("Transgender Female"),
    TRANSGENDER_MALE("Transgender Male"),
    TRANSGENDER_MAN("Transgender Man"),
    TRANSGENDER_WOMAN("Transgender Woman"),
    TRANSMASCULINE("Transmasculine"),
    TWO_SPIRIT("Two-Spirit"),
    UNKNOWN("Unknown");

    private final String description;

    Sex(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}