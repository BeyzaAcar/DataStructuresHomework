package homework1;

/**
 * Class for likes on a post.
 * @author BeyzaAcar
 */
public class Like extends Interaction
{
    /**
     * Constructor for Like class
     * @param interactionId
     * @param postToLike
     * @param byWho
     */
    public Like(int interactionId, Post postToLike, Account byWho)
    {
        super(interactionId, byWho.getUsername(), postToLike.getPostId());
    }

    /**
     * Getter for username
     * @return
     */
    public String getUserName()
    {
        return super.getUserName();
    }
}
