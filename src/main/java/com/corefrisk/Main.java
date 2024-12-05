package com.corefrisk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        File myFile = new File("word.txt");
//        System.out.println("Attempting to read from file in: "+myFile.getCanonicalPath());
//
//        Scanner input = new Scanner(myFile);
//        String in = "";
//        in = input.nextLine();
        String s = null;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\CoreFrisk\\IdeaProjects\\AdventOfCode\\src\\main\\resources\\input.txt"))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
                s = currentLine;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}