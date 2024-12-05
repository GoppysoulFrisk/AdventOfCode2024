package com.corefrisk;

import com.corefrisk.day1.DistanceCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer l = DistanceCalculator.calculateTotalDistance("/input.txt");
        System.out.println(l);
    }
}