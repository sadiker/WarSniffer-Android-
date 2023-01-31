package com.example.warsnifffer.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ülkeler")
public class Country {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String name;
    private  int tank;
    private int artillery;
    private int warplane;
    private int navy;
    private Long manpower;
    private int flag;

    private Long power;

    private String detail;

    public Country() {

    }

    public Country(String name, int tank, int artillery, int warplane, int navy, Long manpower, int flag) {
        this.name = name;
        this.tank = tank;
        this.artillery = artillery;
        this.warplane = warplane;
        this.navy = navy;
        this.manpower = manpower;
        this.flag = flag;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTank() {
        return tank;
    }

    public void setTank(int tank) {
        this.tank = tank;
    }

    public int getArtillery() {
        return artillery;
    }

    public void setArtillery(int artillery) {
        this.artillery = artillery;
    }

    public int getWarplane() {
        return warplane;
    }

    public void setWarplane(int warplane) {
        this.warplane = warplane;
    }

    public int getNavy() {
        return navy;
    }

    public void setNavy(int navy) {
        this.navy = navy;
    }

    public Long getManpower() {
        return manpower;
    }

    public void setManpower(Long manpower) {
        this.manpower = manpower;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }


    public void setPowerDefault(){
        this.power=this.artillery*PowerRate.ARTİLLERY_POWER+
                this.navy*PowerRate.NAVY_POWER+
                this.tank*PowerRate.TANK_POWER+
                this.manpower*PowerRate.MAN_POWER+
                this.warplane*PowerRate.WARPLANE_POWER;
    }
}
