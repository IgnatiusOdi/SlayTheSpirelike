package com.SlayTheSpirelike.Achivement;

public class Achivement {
    private String name;
    private String desc;


    public Achivement(String name, String desc) {
        this.name = name;
        this.desc = desc;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
