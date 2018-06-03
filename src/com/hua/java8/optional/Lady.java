package com.hua.java8.optional;

public class Lady {

    private String name;

    public Lady(String name) {
        this.name = name;
    }

    public Lady() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lady{" +
                "name='" + name + '\'' +
                '}';
    }
}
