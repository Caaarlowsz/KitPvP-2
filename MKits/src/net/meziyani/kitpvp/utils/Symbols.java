package net.meziyani.kitpvp.utils;

/**
 * Created by yanim on 2017-07-18.
 */
public enum Symbols {

    HEART("❤");

    String symbol;

    Symbols(String symbol){
        this.symbol = symbol;
    }

    public String toString(){
        return symbol;
    }

}
