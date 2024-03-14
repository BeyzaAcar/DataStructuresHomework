package homework1;

/**
 * An abstract class for interactions (e.g. like and comments for this project)
 * @author BeyzaAcar
 */
abstract class Interaction
{
    private final int interactionId;
    private String username;
    private int postId;

    /**
     * Constructor for Interaction abstract class
     * @param interactionId
     * @param username
     * @param postId
     */
    public Interaction(int interactionId, String username, int postId)
    {
        this.interactionId = interactionId;
        this.username = username;
        this.postId = postId;
    }

    /**
     * Getter for username
     * @return username
     */
    public String getUserName()
    {
        return username;
    }

}
