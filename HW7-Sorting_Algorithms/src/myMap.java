import java.util.LinkedHashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that stores a LinkedHashMap object and a string to be used in the LinkedHashMap object
 * Created by Beyza Acar on 19.05.2023
 */
public class myMap {
    private LinkedHashMap<String, Info> map;
    private int mapSize;
    private String str;
    private String [] words;

    /**
     * Creates a myMap object with a string
     * @param str
     */
    public myMap(String str)
    {
        //Error handling
        if (str == null)
        {
            System.out.println("String is null, object cannot be created");
            throw new NullPointerException();
        }
        if (str.replaceAll("\\s", "").isEmpty())
        {
            System.out.println("String is empty, object cannot be created");
            throw new IllegalArgumentException();
        }
        this.str = str;
        modifier();
        words = this.str.split(" ");
        map = new LinkedHashMap<>();
        mapSize = 0;
        for(int i = 0;i<words.length;i++)
            for(int j = 0;j<words[i].length();j++)
                put(words[i].substring(j, j+1), new Info(new String[]{words[i]}, 1), i);
    }

    /**
     * Copy constructor
     * Creates a myMap object with a myMap object
     * @param myMapObj
     */
    public myMap(myMap myMapObj)
    {
        this.str = myMapObj.str;
        this.words = myMapObj.words;
        this.map = myMapObj.map;
        this.mapSize = myMapObj.mapSize;
    }

    /**
     * No parameter constructor
     */
    public myMap()
    {
        this.map = new LinkedHashMap<>();
        this.str = null;
        this.words = null;
        this.mapSize = 0;
    }

    /**
     * Convert all uppercase letters to lowercase letters and delete non-alphabetic characters
     */
    private void modifier()
    {
        System.out.println("original string: " + str);
        int i = 0;
        StringBuilder temp_string = new StringBuilder();
        Matcher matcher1 = Pattern.compile("[A-Z]").matcher(str);
        Matcher matcher2 = Pattern.compile("[a-z ]").matcher(str);
        while(i<str.length())
        {
            // set regions to one character
            matcher1.region(i, i+1);
            matcher2.region(i, i+1);
            if(matcher1.find()) // if the character is uppercase, convert it to lowercase
                temp_string.append(matcher1.group().toLowerCase());
            if(matcher2.find()) // if the character is lowercase or space, add it to the stringBuilder(temp_string)
                temp_string.append(matcher2.group());
            i++;
        }
        this.str = temp_string.toString();
        System.out.println("modified string: " + this.str + "\n");
    }


    /**
     * Getter for mapSize
     * Returns the size of the map
     * @return
     */
    public int size() {
        return mapSize;
    }

    /**
     * Getter for map
     * @return
     */
    public LinkedHashMap<String, Info> getMap() {
        return map;
    }

    /**
     * Puts the key and info into the map if the key is not in the map, otherwise adds the word to the info object
     * @param key
     * @param info
     * @param words_count
     */
    public void put(String key, Info info, int words_count)
    {
        if(map.containsKey(key))
            map.get(key).add(words[words_count]);
        else
        {
            map.put(key, info);
            mapSize++; // if the key that we are going to add is unique, increase the mapSize by 1 otherwise we must not increase mapSize
        }
    }

    /**
     * Puts the key and info into the map without checking if the key is in the map
     * Uses LinkedHashMap.put() method directly
     * @param key
     * @param info
     */
    public void put(String key, Info info)
    {
        map.put(key, info);
        mapSize++;
    }

    /**
     * Prints the map
     */
    public void view()
    {
        for(String key : map.keySet())
            System.out.println("Letter: " + key + " - " + map.get(key));
        System.out.println("Map Size: " + mapSize);
    }

    /**
     * Returns the keySet of the map
     * @return
     */
    public Set<String> keySet()
    {
        return map.keySet();
    }

    /**
     * Returns the info object of the key
     * @param key
     * @return
     */
    public Info get(String key)
    {
        return map.get(key);
    }

}

