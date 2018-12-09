package com.advent2018.day3;

public final class Fabric {

    private final Integer columns;
    private final Integer rows;
//    private static Map<Position,String> positions;

    private final String[][] pos;

    public Fabric(Integer columns, Integer rows) {
        this.columns = columns;
        this.rows = rows;

        this.pos = new String[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                pos[i][j] = ".";
            }
        }
    }

    public void markPosition(int x, int y, String value) {
        String str = pos[x][y];
        if(str.equals(".")) {
            pos[x][y] = value;
        } else {
            pos[x][y] = "X";
        }
        System.err.println("finish marking position.");
    }

    public Integer getNumberOfOverlapInches() {
        Integer result = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(pos[i][j].equals("X")) {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean isOverlaped(Claim c) {
        String claimId = c.getId().toString();
        for(int i = c.getLefInches(); i < c.getLefInches() + c.getWidth(); i++) {
            for(int j = c.getTopInches(); j < c.getTopInches() + c.getHeight(); j++) {
                if(!pos[i][j].equals(claimId)) {
                    return true;
                }
            }
        }
        return false;
    }
}
