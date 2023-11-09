package com.example.a028_spinnerexam;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private int img;
    private String name;
    private String city;
    private String country;
    private String year;

    public Team(int img, String name, String city, String country, String year) {
        this.img = img;
        this.name = name;
        this.city = city;
        this.country = country;
        this.year = year;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Team{" +
                "img=" + img +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public static final String[] NAME = {
            "KK Crvena Zvezda", "Maccabi Basketball Club", "Basketball Club Žalgiris",
            "Club Deportivo Baskonia", "PanathinaikosBasketball Club"};

    public static final String[] CITY = {
            "Belgrado", "Tel Aviv", "Kaunas", "Vitoria", "Atenas"};
    public static final String[] COUNTRY = {
            "Serbia", "Israel", "Lituania", "España", "Grecia"};

    public static final String[] YEAR = {
            "1945", "1932", "1944", "1959", "1919"
    };

    public static final int[] SHIELD = {
            R.drawable.avatar_1, R.drawable.avatar_2, R.drawable.avatar_3,
            R.drawable.avatar_4, R.drawable.avatar_5
    };

    public static List<Team> createTeam() {
        List<Team> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Team team = new Team(SHIELD[i], String.valueOf(NAME[i]),
                    String.valueOf(CITY[i]), String.valueOf(COUNTRY[i]), String.valueOf(YEAR[i]));
            list.add(team);
        }
        return list;
    }
}
