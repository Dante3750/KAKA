package com.globals.netconnect.kaka.Model;

public class OptionModel {

    private String Name,id;

    public OptionModel(String name, String id) {
        Name = name;
        this.id = id;
    }

    public OptionModel() {

    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
