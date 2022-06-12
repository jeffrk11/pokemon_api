package com.jeff.pokemon.utils;

import java.util.Arrays;
import java.util.List;

import com.jeff.pokemon.model.PokemonList;

public class PokemonSortUtils {
    
    
    /**
     * <p>Given a list of Pokemon names, return a list of Pokemon objects sorted by the length of their
     * names</p>
     * 
     * 
     * <b>Counting sort algorithm</b>
     * 
     * <p>Big-Ω: Best -  Ω(n+k) | Average - Θ(n+k) | Worst - O(n+k) </p>
     * It works by counting the number of objects with distinct key values. 
     * Then doing some operation to calculate the position of each object in the output sequence.
     * @see https://www.geeksforgeeks.org/counting-sort/
     * @param names A list of strings that are the names of the Pokemon.
     * @return A PokemonList object.
     */
    public static PokemonList lenghtSort(List<String> names){
        //get the first element only to know any size
        int max = names.get(0).length();
        int min = names.get(0).length();
  
        for(var name : names){
            //changing value if names max and min exists
            max = name.length() > max ? name.length() : max;
            min = name.length() < min ? name.length() : min;
        }
        //and with a min and max values i need a frequency array, because i wont comparing elements
        // i know the min and max values, so i know what numbers will be in frequency array 
        int[] frequency = new int[max+1];
        for(var name : names){
            frequency[name.length()] += 1;
        }
        //now i need to know how many numbers are less than or equal to a number
        for(int i = 1; i < frequency.length; i++){
            frequency[i] += frequency[i - 1];
        }
        //i have an array with the frequency numbers by index
        //now i able to sort the numbers
        //i will make a reverse array so i dont lose stability
        String[] sorted = new String[names.size()];
        for(int i = names.size()-1; i >= 0; i--){
            //for a better visualization the variables are separated

            //name size that will be finded in frequency
            int name_lenght = names.get(i).length();
            //position that will be placed in the sorted array
            int position_order = frequency[name_lenght];
            //name that will be placed in the correct position
            //     decrement 1, because the algorithm doesnt use 0 position 
            sorted[position_order-1] = names.get(i);
            //and we need to decrement the frequency current number once the number is in right place
            frequency[name_lenght] -= 1;
        }
        return new PokemonList(Arrays.asList(sorted));
    }

    
    /**
    * <p>
     * Given a list of Pokemon names, return a list of Pokemon objects sorted alphabetically by name.
     *</p>
     *  <b>Selection sort</b>
     * 
     * <p>Big-Ω - Best - Ω(n^2) | Average - Θ(n^2) | Worst - O(n^2)</p>
     * Find the minimum element in each run of the array and swap it with the element at the current index is compared.
     * 
     * @see https://www.geeksforgeeks.org/selection-sort/
     * @param names A list of strings that are the names of the Pokemon you want to sort.
     * @return A PokemonList object.
     */
    public static PokemonList alphabeticalSort(List<String> names){


        //temp variable to hold some string
        String temp ="";
        //outer loop
        for (int i = 0; i < names.size(); i++) {
            //inner loop
            for (int j = i + 1; j < names.size(); j++) {
                
                //compare strings, if it is bigger, change positions
                if (names.get(i).compareTo(names.get(j)) > 0) {
                    //replace using a temporary variable
                    temp = names.get(i);
                    names.set(i,names.get(j));
                    names.set(j,temp);
                }
            }
        }
        return new PokemonList(names);
    }

}
