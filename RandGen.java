package com.dsna20.particle201921079;

import java.util.Random;

public final class RandGen {
    private static Random mRandom;
    private static long mSeed;

    static{
        mSeed = System.currentTimeMillis();
        mRandom = new Random(mSeed);
    }
    private RandGen(){}
    public static double uniform(){return mRandom.nextDouble();}
    public static int uniform(int n) {
        if (n <= 0) throw new IllegalArgumentException("Parameter N must be positive");
        return mRandom.nextInt(n);
    }
    public static double uniform(double a, double b){
        if (!(a < b)) throw new IllegalArgumentException("invalid range");
        return a + uniform() * (b - a);
    }
}
