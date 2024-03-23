package com.simulacion.models;

import java.util.ArrayList;
import java.util.List;

public class ReduceLinear {

    private long seed;
    private long a;
    private long c;
    private long m;
    private List<Double> listRi;

    public ReduceLinear(int quantity) {
        initLogical();
        listRi = new ArrayList<>();
        generateNumbersRi(quantity);
    }

    public ReduceLinear() {
        initLogical();
    }

    public void initLogical(){
        this.seed = System.currentTimeMillis();
        this.a = 1664525;
        this.c = 7;
        this.m = (long) Math.pow(2, 32);
    }

    private void generateNumbersRi(int quantity){
        for (int i = 0; i < quantity; i++) {
            double randomNumber = generateRi();
            listRi.add(randomNumber);
        }
    }

    public double generateRi() {
        seed = ((a * seed) + c) % m;
        return (double) seed / m;
    }

    public List<Double> getListRi(){
        return listRi;
    }
}

