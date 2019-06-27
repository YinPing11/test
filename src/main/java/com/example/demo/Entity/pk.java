package com.example.demo.Entity;

public class pk {
    private int pkid;
    private String pkname;
    private String pk_personnel;
    private String pk_beggintime;
    private String pk_overtime;
    private int pk_state;
    private String  victory_name;

    public String getPk_personnel() {
        return pk_personnel;
    }

    public void setPk_personnel(String pk_personnel) {
        this.pk_personnel = pk_personnel;
    }

    public String getPk_beggintime() {
        return pk_beggintime;
    }

    public void setPk_beggintime(String pk_beggintime) {
        this.pk_beggintime = pk_beggintime;
    }

    public String getPk_overtime() {
        return pk_overtime;
    }

    public void setPk_overtime(String pk_overtime) {
        this.pk_overtime = pk_overtime;
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getPkname() {
        return pkname;
    }

    public void setPkname(String pkname) {
        this.pkname = pkname;
    }

    public int getPk_state() {
        return pk_state;
    }

    public void setPk_state(int pk_state) {
        this.pk_state = pk_state;
    }

    public String getVictory_name() {
        return victory_name;
    }

    public void setVictory_name(String victory_name) {
        this.victory_name = victory_name;
    }
}
