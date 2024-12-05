package com.corefrisk.day2;

import com.corefrisk.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReportsMethods {


    public static long readReports(String input) {

        List<List<Integer>> listList = new ArrayList<>();

        try (InputStream inputStream = Main.class.getResourceAsStream(input);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            String currentLine;

            while (((currentLine = br.readLine()) != null)) {

                List<Integer> numberList =
                        Arrays.stream(currentLine.trim().split("\\s+"))
                                .map(Integer::valueOf)
                                .collect(Collectors.toList());

                listList.add(numberList);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listList.stream().filter(ReportsMethods::filterReports).count();
    }

    public static boolean filterReports(List<Integer> list) {
        if (canBeMonotonic(list)) {
            return true;
        }

        for (int i = 0; i < list.size(); i++) {
            List<Integer> newList = new ArrayList<>(list);
            newList.remove(i);
            if (canBeMonotonic(newList)) {
                return true;
            }
        }
        return false;
    }

    private static boolean canBeMonotonic(List<Integer> list) {
        if (list.size() < 2) return true;

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < list.size() - 1; i++) {
            int current = list.get(i);
            int next = list.get(i + 1);
            int difference = Math.abs(current - next);

            if (current == next || difference > 3) {
                return false;
            }

            if (current < next) {
                isDecreasing = false;
            } else {
                isIncreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }
}