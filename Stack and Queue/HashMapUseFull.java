import java.util.HashMap;
import java.util.Map;

public class HashMapUseFull {

    public static void main(String[] args){
        //commonly used in competitive programming to store key-value pairs,
        // allowing fast lookup, insertion, and deletion of elements.
        // It is based on a hash table and allows for constant-time complexity
        // (O(1)) for most operations, assuming a good hash function with minimal collisions.

        //Key Features
        //Key-Value Pairs: Stores data as key-value pairs.
        //No Duplicate Keys :  If you insert a key that already exists,
            // it will overwrite the old value associated with that key.
        //Null Keys and Values: A HashMap allows one null key and multiple null values.
        //Order: It does not guarantee any specific order of the elements (unless using LinkedHashMap).


        //Basic Operations
        // Creating a HashMap with Integer keys and String values
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        System.out.println(map.get(1));  // Output: One

        if (map.containsKey(2)) {
            System.out.println("Key exists");
        }
        map.remove(2);  // Removes the entry with key 2

        // Iterating over a HashMap:
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        //Using Key Set
        for (Integer key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        System.out.println("Size of map: " + map.size());

        // to clear the map
        //map.clear();

        //Default Values for Missing Keys:
        //used a lot in competitive coding
        String value = map.getOrDefault(5, "Default");


        //Below is the best example
        //FrequencyCounter
        // Sample array of integers
        int[] arr = {4, 5, 6, 7, 4, 8, 4, 6, 7, 8, 9};

        Map<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<arr.length;i++){
            // for every iteration add one
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);//if not present adding  one
        }

        // Iterating using entrySet()
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            System.out.println("key : "+entry.getKey()+ " count : "+entry.getValue());
        }

        //using for each loop on  Key set
        for(Integer key : hm.keySet()){
            System.out.println("key : "+key+" value : "+hm.get(key));
        }

        //for each loop with values :for (V value : map.values()) {


        //Using forEach with Lambda Expression

        hm.forEach((k,v) -> {
            System.out.println(" Key  : "+k+" value "+v);
        });
    }
}
