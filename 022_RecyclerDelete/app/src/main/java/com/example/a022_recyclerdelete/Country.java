package com.example.a022_recyclerdelete;

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

    public static List<Country> fillArray() {
        List<Country> list = new ArrayList<>();

        for (int i = 0; i <= 16; i++) {
            int avatar = R.drawable.avatar_1;
            Country country = new Country("Pais " + i, "Detail " + i, avatar + i);
        }

        return list;
    }
}
