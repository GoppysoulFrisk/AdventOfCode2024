package com.corefrisk.day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderAndComparatorOfTwoPairsOfNumbers {

    public Long howFarItIs() throws FileNotFoundException {
        String s = null;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
                s = currentLine;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         return Long.parseLong(s);
    }
}
