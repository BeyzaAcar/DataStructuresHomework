import java.util.Arrays;

/**
 * Class that stores how many times a letter appears in the given string and the words that contain that letter
 * Created by Beyza Acar on 19.05.2023
 */
public class Info {
    private int counts;
    String [] words;

    /**
     * Constructor that takes a string array for words and an integer for counts
     * @param words
     * @param counts
     */
    public Info(String [] words, int counts)
    {
        this.words = words;
        this.counts = counts;
    }

    /**
     * No parameter contructor
     */
    public Info()
    {
        this.words = null;
        this.counts = 0;
    }

    /**
     * Sets the words and counts of the Info object
     * @param words
     * @param counts
     */
    public void setData(String [] words, int counts)
    {
        this.words = words;
        this.counts = counts;
    }

    public int getCount() {
        return counts;
    }

    /**
     * Checks if the two Info objects are equal or not
     * @param obj
     * @return
     */
    public boolean equals(Info obj)
    {
        if (this.counts != obj.counts)
            return false;
        for (int i = 0; i < this.words.length; i++)
        {
            if (!this.words[i].equals(obj.words[i]))
                return false;
        }
        return true;
    }

    /**
     * returns a string that contains all the words in the string array and the count at the end
     * @return String
     */
    public String toString()
    {
        String str = "";
        for (int i = 0; i < this.words.length; i++)
        {
            str += this.words[i] + " ";
        }
        str = "Count: " + this.counts + " - Words: [" + str + "\b]";
        return str;
    }

    /**
     * Readjusts the Info object by adding a new word to the string array and increasing the count by 1
     * The reason that method's name is repeat is because it is called when the key info is already in the map
     * @param toAdd
     */
    public void add(String toAdd)
    {
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = toAdd;
        counts++;
    }
}
