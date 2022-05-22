package com.vinayak.practice.model;

import java.util.Objects;

public class Tile {
    private String value;

    public Tile() {
        value = null;
    }

    public Tile(String val) {
        value = val;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEmpty(){
        return (this.value == null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return Objects.equals(value, tile.value);
    }

    @Override
    public String toString() {
        return value;
    }
}
