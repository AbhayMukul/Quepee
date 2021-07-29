package com.example.quepee.User.Model;

public class QuepeeModel {
    Double Latitude;
    Double Longitutde;

    String Name;

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitutde() {
        return Longitutde;
    }

    public void setLongitutde(Double longitutde) {
        Longitutde = longitutde;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public QuepeeModel(Double latitude, Double longitutde, String name) {
        Latitude = latitude;
        Longitutde = longitutde;
        Name = name;
    }
}
