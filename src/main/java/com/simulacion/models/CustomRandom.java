package com.simulacion.models;

public class CustomRandom {

    private long seed;
    private long a;
    private long c;
    private long m;

    public CustomRandom(long seed) {
        this.seed = seed;
        this.a = 1664525;
        this.c = 1013904223;
        this.m = (long) Math.pow(2, 32);
    }

    public double nextDouble() {
        seed = (a * seed + c) % m;
        return (double) seed / m;
    }

}
