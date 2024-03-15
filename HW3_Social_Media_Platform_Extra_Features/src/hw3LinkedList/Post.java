package hw3LinkedList;
import java.util.LinkedList;

/**
 * Class for posts
 * @author BeyzaAcar
 */
public class Post
{
    private int postId;
    private String username;
    private LinkedList<Like> likes;
    private LinkedList<Comment> comments;
    private String content;

    /**
     * Constructor for Post class
     * @param postId
     * @param username
     * @param content
     */
    public Post(int postId, String username, String content)
    {
        this.postId = postId; this.username = username; this.content = content;
        likes = new LinkedList<Like>();
        comments = new LinkedList<Comment>();
    }

    /**
     * Allows to view Post class
     * @return post id + username + content
     * */
    @Override
    public String toString()
    {
        return "(Post ID : " + postId + ") " + username + ":" + content + "\n";
    }

    /**
     * Allows adding a like to a post
     * @param like
     */
    public void addLike(Like like)
    {
        //System.out.println(like.getUserName() +" liked the post with content : " + this.content);
        likes.addLast(like);
    }

    /**
     * Unlikes a post
     * @param like
     */
    public void unlike(Like like)
    {
        likes.remove(like);
    }

    /**
     * Allows commenting to a post
     * @param comment
     */
    public void addComment(Comment comment)
    {
        comments.addLast(comment);
        //System.out.println("Commenting the post with content : " + this.content);
    }

    /**
     * Removes a comment from a post
     * @param comment
     */
    public void uncomment(Comment comment)
    {
        //System.out.println("Comment is removed from the post with content : " + this.content);
        comments.remove(comment);
    }

    /**
     * Getter for username
     * @return username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Getter for postId
     * @return postId
     */
    public int getPostId(){ return postId; }

    /**
     * Allows viewing a post's interactions
     */
    public void viewPostInteractions()
    {

        System.out.println("(Post ID : "+ postId + ") " + content + ".");
        if(likes.size() == 0) System.out.println("The post has no likes");
        else
        {
            System.out.print("The post was liked by the following account(s) : ");
            for (int i = 0; i < likes.size(); i++)
            {
                System.out.print(likes.get(i).getUserName() + ", ");
            }
            System.out.println();
        }

        if(comments.size() == 0) System.out.println("The post has no comments");
        else
        {
            System.out.println("The post has " + comments.size() + " comment(s)");
            for (int i = 0; i < comments.size(); i++) {
                System.out.println("Comment " + (i+1) + " : ( from : " +comments.get(i).getUserName() + " )"  + comments.get(i).getContent() + ", ");
            }
            System.out.println();
        }
    }
}
