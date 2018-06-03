package com.hua.java8.optional;

import javax.swing.text.html.Option;
import java.util.Optional;

public class NewMan {

    private Optional<Lady> lady = Optional.empty();

    public NewMan() {
    }

    public NewMan(Optional<Lady> lady) {

        this.lady = lady;
    }

    @Override
    public String toString() {
        return "NewMan{" +
                "lady=" + lady +
                '}';
    }

    public Optional<Lady> getLady() {
        return lady;
    }

    public void setLady(Optional<Lady> lady) {
        this.lady = lady;
    }
}
