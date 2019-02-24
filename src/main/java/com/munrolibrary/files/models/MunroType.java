package com.munrolibrary.files.models;

public enum MunroType {
    MUNRO("Munro"),
    MUNROTOP("Munro Top");

    private String munroType;

    MunroType(String type) {
        this.munroType = type;
    }

    public String getMunroType() {
        return munroType;
    }
}
