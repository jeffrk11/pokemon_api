package com.jeff.pokemon.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.ls.LSProgressEvent;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.jeff.pokemon.model.PokemonList;

public class PokemonSortUtils {
    
    
    /**
     * Given a list of Pokemon names, return a list of Pokemon objects sorted by the length of their
     * names
     * 
     * @param names A list of strings that are the names of the Pokemon.
     * @return A PokemonList object.
     */
    public static PokemonList lenghtSort(List<String> names){
        //counting sort algorithm
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

    public static PokemonList alphabethicSort(List<String> names){
    

        return null;
    }

}
