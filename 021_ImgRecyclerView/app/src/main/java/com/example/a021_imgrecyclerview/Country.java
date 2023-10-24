package com.example.a021_imgrecyclerview;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Country {
    String name;
    String detail;
    int image;

    public Country(String name, String detail, int image) {
        this.name = name;
        this.detail = detail;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public int getImage() {
        return image;
    }

    public static List<Country> fillArray(Context applicationContext) {
        List<Country> list = new ArrayList<>();

        for (int i = 0; i <= 16; i++) {
            String name = "avatar_" + i + ".xml";
            Country country = new Country("Pais " + i, "Detalles " + i,
                    applicationContext.getResources().getIdentifier(name, "drawable", applicationContext.getPackageName()));
            list.add(country);
        }

        return list;
    }
}
