/*
https://www.geeksforgeeks.org/dsa/powet-set-lexicographic-order/
Power Set in Lexicographic order
Last Updated : 23 May, 2024
This article is about generating Power set in lexicographical order. 
Examples : 

Input : abc
Output : a ab abc ac b bc c
The idea is to sort array first. After sorting, one by one fix characters and recursively generates all subsets starting from them. After every recursive call, we remove last character so that next permutation can be generated. 
  */

package com.kamal;

import java.util.*;

public class generatePowerSetProgram {

    // Function to generate the power set of a string
    static void generatePowerSet(String s) {
        char[] original = s.toCharArray();
        Arrays.sort(original);
        String sorted = new String(original);
        int n = sorted.length();

        List<String> subsets = new ArrayList<>();
        for(int i = 0; i < (1<<n); i++)
        {
            int num = i;
            StringBuilder binary = new StringBuilder();

            for(int j = 0; j < n; j++)
            {
                binary.insert(0, num%2);
                num /= 2;
            }

            StringBuilder subset = new StringBuilder();
            for(int j = 0; j < n; j++)
            {
                 if(binary.charAt(j) == '1') {
                     subset.append(sorted.charAt(j));
                 }

            }
            subsets.add(subset.toString()) ;
        }
        subsets.sort(null);
        for(String subset : subsets)
        {
           System.out.print(subset + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "abc";
        generatePowerSet(s);
    }
}
