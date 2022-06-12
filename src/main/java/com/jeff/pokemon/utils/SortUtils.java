package com.jeff.pokemon.utils;

import java.util.List;

import com.jeff.pokemon.model.enums.SortType;

public class SortUtils {

    /**
    * <p>
     * Given a list of words, return a list of words sorted by SorType.
     *</p>
     *  <b>Selection sort</b>
     * 
     * <p>Big-Ω - Best - Ω(n^2) | Average - Θ(n^2) | Worst - O(n^2)</p>
     * Find the minimum element in each run of the array and swap it with the element at the current index is compared.
     * 
     * @see https://www.geeksforgeeks.org/selection-sort/
     * @param words A list of strings that you want to sort.
     * @return A List of Strings.
     */
    public static List<String> sort(List<String> words, SortType type){
        //temp variable to hold some string
        String temp ="";
        //outer loop
        for (int i = 0; i < words.size(); i++) {
            //inner loop
            for (int j = i + 1; j < words.size(); j++) {
                
                //compare strings, if it is bigger, change positions
                if (comparate(type,words.get(i),words.get(j))) {
                    //replace using a temporary variable
                    temp = words.get(i);
                    words.set(i,words.get(j));
                    words.set(j,temp);
                }
            }
        }
        return words;
    }
    //method auxilary, its given the result of the comparation needed from given sort
    private static boolean comparate(SortType sort, String a, String b){
        //if it is LENGtH
        if(sort == SortType.LENGTH){
            return a.compareTo(b) > 0;
        }else{
            return a.length() > b.length();
        }
    }
}
