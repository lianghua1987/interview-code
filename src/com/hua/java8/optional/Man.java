package com.hua.java8.optional;

public class Man {

    private Lady lady;

    public Man(Lady lady) {
        this.lady = lady;
    }

    public Man() {
    }

    public Lady getLady() {
        return lady;
    }

    public void setLady(Lady lady) {
        this.lady = lady;
    }

    @Override
    public String toString() {
        return "Man{" +
                "lady=" + lady +
                '}';
    }
}
