package com.qaprosoft.carina.demo.streams.models;

public class NumberPair {

    private int firstInt;

    private int secondInt;

    public NumberPair(int firstInt, int secondInt) {
        this.firstInt = firstInt;
        this.secondInt = secondInt;
    }

    public int getFirstInt() {
        return firstInt;
    }

    public void setFirstInt(int firstInt) {
        this.firstInt = firstInt;
    }

    public int getSecondInt() {
        return secondInt;
    }

    public void setSecondInt(int secondInt) {
        this.secondInt = secondInt;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NumberPair))
            return false;
        return this.firstInt == ((NumberPair) obj).firstInt && this.secondInt == ((NumberPair) obj).secondInt;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(firstInt).hashCode();
    }
}
