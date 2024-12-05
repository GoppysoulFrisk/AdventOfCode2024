package com.corefrisk.day1;

import com.corefrisk.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class DistanceCalculator {

    public static Integer calculateTotalDistance(String input) {
        List<Integer>[] numbers = parseInputFromFileToArrays(input);
        return calculateSumOfDifferences(numbers[0], numbers[1]);
    }

    private static List<Integer>[] parseInputFromFileToArrays(String input) {
        List<Integer> left = new ArrayList<>(1000);
        List<Integer> right = new ArrayList<>(1000);
        try (InputStream inputStream = Main.class.getResourceAsStream(input);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String currentLine;
            while (((currentLine = br.readLine()) != null)) {
                String[] parts = currentLine.trim().split("\\s+");
                left.add(Integer.valueOf(parts[0]));
                right.add(Integer.valueOf(parts[1]));
            }
            left.sort(Integer::compareTo);
            right.sort(Integer::compareTo);
            return new List[]{left, right};

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static Integer calculateSumOfDifferences(List<Integer> left, List<Integer> right) {
        return IntStream.range(0, left.size())
                .map(i -> Math.abs(left.get(i) - right.get(i)))
                .sum();
    }

    private static List<Integer>[] parseInputToParts(String input) {
        String[] parts = input.trim().split("\\s+");
        List<Integer> left = parts[0].chars()
                .map(Character::getNumericValue)
                .sorted()
                .boxed()
                .toList();
        List<Integer> right = parts[1].chars()
                .map(Character::getNumericValue)
                .sorted()
                .boxed()
                .toList();
        return new List[]{left, right};
    }


}