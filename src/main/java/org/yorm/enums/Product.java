package org.yorm.enums;

public enum Product {
    BROCOLLI("Brocolli", 120),
    CAULIFLOWER("Cauliflower", 60),
    CUCUMBER("Cucumber", 48),
    BEETROOT("Beetroot", 32),
    CARROT("Carrot", 56),
    TOMATO("Tomato", 16),
    BEANS("Beans", 82),
    BRINJAL("Brinjal", 35),
    CAPSICUM("Capsicum", 60),
    MUSHROOM("Mushroom", 75),
    POTATO("Potato", 22),
    PUMPKIN("Pumpkin", 48),
    CORN("Corn", 75),
    ONION("Onion", 16),
    APPLE("Apple", 72),
    BANANA("Banana", 45),
    GRAPES("Grapes", 60),
    MANGO("Mango", 75),
    MUSK_MELON("Musk Melon", 36),
    ORANGE("Orange", 75),
    PEARS("Pears", 69),
    POMEGRANATE("Pomegranate", 95),
    RASPBERRY("Raspberry", 160),
    STRAWBERRY("Strawberry", 180),
    WATER_MELON("Water Melon", 28),
    ALMONDS("Almonds", 200),
    PISTA("Pista", 190),
    NUTS_MIXTURE("Nuts Mixture", 950),
    CASHEWS("Cashews", 650),
    WALNUTS("Walnuts", 170);

    private final String name;

    private final int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
