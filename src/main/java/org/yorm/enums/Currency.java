package org.yorm.enums;

public enum Currency {
    INR ("INR"),
    AED("AED"),
    USD("USD"),
    EUR("EUR"),
    GBP("GBP"),
    CAD("CAD"),
    BDT("BDT"),
    SGD("SGD"),
    OMR("OMR"),
    THB("THB"),
    CNY("CNY"),
    HKD("HKD"),
    MYR("MYR"),
    SAR("SAR"),
    LKR("LKR"),
    KWD("KWD");

    Currency(String text) {
        this.text = text;
    }

    private final String text;

    public String getText() {
        return text;
    }
}
