//package com.journaldev.readfileslinebyline;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class q2 {

    public static void sortbykey(HashMap<Character, Integer> map) {
        // TreeMap to store values of HashMap
        TreeMap<Character, Integer> sorted = new TreeMap<>();

        // Copy all data from hashMap into TreeMap
        sorted.putAll(map);

        boolean first = true;
        // Display the TreeMap which is naturally sorted
        for (Map.Entry<Character, Integer> entry : sorted.entrySet()) {
            if (first) {
                System.out.print(entry.getKey() + "=" + entry.getValue());
                first = false;
            } else {
                System.out.print("," + entry.getKey() + "=" + entry.getValue());
            }
        }
        System.out.print("\n");

    }

    public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer>> list = new LinkedList<Map.Entry<Character, Integer>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    static void characterCount(String inputString) {
        // Creating a HashMap containing char
        // as a key and occurrences as a value
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

        // Converting given string to char array

        char[] strArray = inputString.toCharArray();
        boolean lineHasalpha = false;
        // checking each char of strArray
        for (char c : strArray) {
            if ((int) c >= 97 && (int) c <= 122) {
                lineHasalpha = true;
                if (charCountMap.containsKey(c)) {

                    // If char is present in charCountMap,
                    // incrementing it's count by 1
                    charCountMap.put(c, charCountMap.get(c) + 1);
                } else {

                    // If char is not present in charCountMap,
                    // putting this char to charCountMap with 1 as it's value
                    charCountMap.put(c, 1);
                }
            }

        }
        if (!lineHasalpha) {
            System.out.println(inputString);
        }
        boolean first = true;
        int value = 0;
        Map<Character, Integer> hm1 = sortByValue(charCountMap);
        // for (Map.Entry<Character, Integer> en : hm1.entrySet()) {
        // if (first) {
        // System.out.print(en.getKey() + "=" + en.getValue());
        // value = en.getValue();
        // first = false;
        // } else if (value == en.getValue())
        // System.out.print("," + en.getKey() + "=" + en.getValue());
        // else {
        // System.out.print("\n");
        // break;
        // }

        // }
        HashMap<Character, Integer> lexico = new HashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> en : hm1.entrySet()) {
            if (first || value == en.getValue()) {
                lexico.put(en.getKey(), en.getValue());
                value = en.getValue();
                first = false;
            } // else if (value == en.getValue())
              // lexico.put(en.getKey(), en.getValue());
            else {
                // System.out.print("\n");
                break;
            }
        }
        if (lexico.size() >= 1) {
            sortbykey(lexico);
        }
        // Printing the charCountMap
        // for (Map.Entry entry : charCountMap.entrySet()) {
        // System.out.println(entry.getKey() + " " + entry.getValue());
        // }
        // System.out.println("------------------------------");

    }

    public static void main(String[] args) throws IOException {

        // Instantiating the File class
        File fileO = new File("output.txt");
        // Instantiating the PrintStream class
        PrintStream stream = new PrintStream(fileO);
        // System.out.println("From now on " + file.getAbsolutePath() + " will be your
        // console");
        System.setOut(stream);

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            while (line != null) {
                // System.out.println(line);
                // read next line
                line = line.toLowerCase();
                characterCount(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}