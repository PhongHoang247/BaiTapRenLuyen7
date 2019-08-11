package com.phong.model;

import java.io.Serializable;

public class Contact implements Serializable {
    protected String name;
    protected String sdt;

    public Contact() {
    }

    public Contact(String name, String sdt) {
        this.name = name;
        this.sdt = sdt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
