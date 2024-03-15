package hw3LinkedList;

/**
 * Class for comments to a post.
 * @author BeyzaAcar
 */
public class Comment extends Interaction
{
    private String content;

    /**
     * Constructor of Comment class
     * @param interactionId
     * @param postToComment
     * @param byWho indicates the account that will comment
     * @param content
     */
    public Comment(int interactionId, Post postToComment, Account byWho, String content)
    {
        super(interactionId, byWho.getUsername(), postToComment.getPostId());
        this.content = content;
    }

    /**
     * Getter for content
     * @return content
     */
    public String getContent()
    {
        return content;
    }

}
