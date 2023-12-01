package com.taxah.jj.dz2.task1;

public enum AnimalNames {
    WHISKERS("Whiskers"),
    MITTENS("Mittens"),
    LUNA("Luna"),
    TIGER("Tiger"),
    SOCKS("Socks"),
    MAX("Max"),
    BELLA("Bella"),
    ROCKY("Rocky"),
    LOLA("Lola"),
    CHARLIE("Charlie"),
    OREO("Oreo"),
    COCO("Coco"),
    TEDDY("Teddy"),
    ZOEY("Zoey"),
    OLIVER("Oliver"),
    PEPPER("Pepper"),
    CASIE("Casie"),
    RUBY("Ruby"),
    SAMMY("Sammy"),
    NOVA("Nova");

    private final String displayName;

    AnimalNames(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}