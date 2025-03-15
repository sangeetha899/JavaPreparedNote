Difference between map and flatmap: 
Example programs
package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


class Institute{
    private String name;
    private List<String> locations;

    public Institute(String name,List<String> locations ){
        this.name=name;
        this.locations=locations;
    }

    public String getName(){
        return name;
    }
    public List<String> getLocations(){
        return locations;
    }
        }
public class Main {

    public static void main(String[] args) {

        List<Institute> instituteList= new ArrayList<>();

        instituteList.add( new Institute("IIT",Arrays.asList("Ahmedabad","Kozhikode","Chennai","Bangalore")));
        instituteList.add( new Institute("NIT",Arrays.asList("Delhi","Chennai","patna")));

        List<String> names=instituteList.stream().map(Institute::getName).collect(Collectors.toList());

        Set<String> locations= instituteList.stream().flatMap(institute -> institute.getLocations().stream()).collect(Collectors.toSet());


        System.out.println(names);
        System.out.println(locations);

    }
}
