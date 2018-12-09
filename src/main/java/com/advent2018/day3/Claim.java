package com.advent2018.day3;

public class Claim {

    private Integer id;
    private Integer lefInches;
    private Integer topInches;
    private Integer width;
    private Integer height;

    public Claim(Integer id, Integer lefInches, Integer topInches, Integer width, Integer height) {
        this.id = id;
        this.lefInches = lefInches;
        this.topInches = topInches;
        this.width = width;
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLefInches() {
        return lefInches;
    }

    public Integer getTopInches() {
        return topInches;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }
}
