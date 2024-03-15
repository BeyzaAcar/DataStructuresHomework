/**
 * keyValuePair class that holds a string for key and an Info object for value
 * Created by Beyza Acar on 19.05.2023
 */
class keyValuePair
{
    private String key;
    private Info value;

    /**
     * Constructor that takes a string for key and an Info object for value
     * @param key
     * @param value
     */
    protected keyValuePair(String  key, Info value)
    {
        this.key = key;
        this.value = value;
    }

    /**
     * No parameter constructor for keyValuePair
     */
    protected keyValuePair()
    {
        this.key = null;
        this.value = null;
    }

    /**
     * Sets the key and value of the keyValuePair object
     * @param key
     * @param value
     */
    protected void setData(String key, Info value)
    {
        this.key = key;
        this.value = value;
    }

    /**
     * Getter for key
     * @return
     */
    protected String getKey()
    {
        return key;
    }

    /**
     * Getter for value
     * @return
     */
    protected Info getValue()
    {
        return value;
    }
}
