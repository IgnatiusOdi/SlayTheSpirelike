package com.SlayTheSpirelike.Achivement;

public class Achivement {
    private String name;
    private String desc;
    private boolean achive ;

    public Achivement(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.achive = false;
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

    public boolean isAchive() {
        return achive;
    }

    public void setAchive(boolean achive) {
        this.achive = achive;
    }
}
