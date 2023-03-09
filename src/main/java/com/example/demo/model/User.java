package com.example.demo.model;

public class User {
    private int id;
    private String name;
    private Province province_id;

    public User(int id, String name, String p_name) {
    }

    public User(int id, String name, Province province) {
        this.id = id;
        this.name = name;
        this.province_id = province;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province_id;
    }

    public void setProvince(Province province) {
        this.province_id = province;
    }
}
