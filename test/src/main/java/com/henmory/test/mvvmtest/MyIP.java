package com.henmory.test.mvvmtest;

/**
 * author: henmory
 * time:  3/19/18
 * function:
 * description:
 */

public class MyIP {

    String City;
    String Country;
    String Province;

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    @Override public String toString() {

        return this.getCountry() + "\n" +
                this.getProvince() + "\n" +
                this.getCity() + "\n";
    }
}

