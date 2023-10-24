package com.example.a021_imgrecyclerview;

import java.util.ArrayList;
import java.util.List;

public class Country {
    String name;
    String detail;

    public Country(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public static List<Country> fillArray() {
        List<Country> list = new ArrayList<>();

        for (int i = 0; i <= 15; i++) {
            Country country = new Country("Pais " + i, "Detalles " + i);
            list.add(country);
        }

        return list;
    }
}
