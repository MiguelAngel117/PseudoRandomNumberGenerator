package com.simulacion.controllers;

import com.simulacion.models.HalfSquares;
import com.simulacion.models.LinearCongruence;
import com.simulacion.models.MultiplicativeCongruence;
import com.simulacion.models.NormalDistri;

public class Controller {
    public Controller(){
        //linearCongruence();
        //multiplicativeCongruence();
        //halfSquares();
        normal();
    }

    public void linearCongruence(){
        LinearCongruence congruence = new LinearCongruence(1, 4, 3, 7, 128);
        for (Double seed : congruence.getAleatory()) {
            System.out.println(seed);
        }
        
        for (Integer seed : congruence.getSeeds()) {
            System.out.println(seed);
        }
    }

    public void multiplicativeCongruence(){
        MultiplicativeCongruence congruence = new MultiplicativeCongruence(5, 2, 10, 129);
        for (Double seed : congruence.getAleatory()) {
            System.out.println(seed);
        }
        
        for (Integer seed : congruence.getSeeds()) {
            System.out.println(seed);
        }
    }

    public void halfSquares(){
        HalfSquares squares = new HalfSquares(3456, 4, 67);
        for (Double seed : squares.getAleatory()) {
            System.out.println(seed);
        }
        
        for (Integer seed : squares.getCenters()) {
            System.out.println(seed);
        }
    }

    public void normal(){
        NormalDistri normal = new NormalDistri(100,10,17,15);
        
        System.out.println(normal.getAverage());
        System.out.println(normal.getDesviation());
        System.out.println(normal.getAleatoryNi().toString());
    }
}