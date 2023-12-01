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
    CHARLIE("Charlie");

    private final String displayName;

    // Приватный конструктор для установки отображаемого имени
    AnimalNames(String displayName) {
        this.displayName = displayName;
    }

    // Метод для получения отображаемого имени
    public String getDisplayName() {
        return displayName;
    }
}