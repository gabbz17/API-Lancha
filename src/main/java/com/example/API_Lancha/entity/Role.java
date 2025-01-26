package com.example.API_Lancha.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {
    ROLE_MORROSP,
    ROLE_BOIPEBA,
    ROLE_CAIRU,
    ROLE_GAMBOA;

    @JsonCreator
    public static Role fromString(String value) {
        if (value != null) {
            switch (value.toUpperCase()) {
                case "ROLE_MORROSP":
                case "MORROSP":
                    return ROLE_MORROSP;
                case "ROLE_BOIPEBA":
                case "BOIPEBA":
                    return ROLE_BOIPEBA;
                case "ROLE_CAIRU":
                case "CAIRU":
                    return ROLE_CAIRU;
                case "ROLE_GAMBOA":
                case "GAMBOA":
                    return ROLE_GAMBOA;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Role: " + value);
    }
}
