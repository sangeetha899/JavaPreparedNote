package org.example;


import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
       String input="java concept of the day";

      Map<Character,Long> frequencyMap= input.chars()//covert each character into stream of IntStreams [j-118,a-97,v-78,a-98] ASCII value of each alphabet
               .filter(c->!Character.isWhitespace(c)) // Exclude space
               .mapToObj(c->(char) c) // Convert to Stream<Character>
               .collect(Collectors.groupingBy(Function.identity(),// Group by character
                       Collectors.counting()));// Count occurrences as Integer

       // Collectors.groupingBy(Function.identity(), ...):
       // Groups the stream elements (Character) by their identity (the character itself).
       // For example: {j=[j], a=[a, a], v=[v]}.

      //  Counts the number of elements in each group.
       // For example: {j=1, a=2, v=1}.

      frequencyMap.forEach((character,count)-> System.out.println(character+"-"+count));
    }
}