package homework1;

/**
 * Class for posts
 * @author BeyzaAcar
 */
public class Post
{
    private int postId;
    private String username;
    private Like[] likes;
    private Comment[] comments;
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
        likes = new Like[10];
        comments = new Comment[10];
    }

    /**
     * Returns the first empty index in the like array
     * @param like
     * @return the index
     */
    private int emptyIndex(Like[] like)
    {
        int i;
        for(i=0;i<like.length;i++)
        {
            if(like[i] == null) return i;
        }
        return -1;
    }

    /**
     * Returns the first empty index in the comment array
     * @param comment
     * @return the index
     */
    private int emptyIndex(Comment[] comment)
    {
        int i;
        for(i=0;i<comment.length;i++)
        {
            if(comment[i] == null) return i;
        }
        return -1;
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
        System.out.println(like.getUserName() +" liked the post with content : " + this.content);
        int likeNum = emptyIndex(likes);
        likes[likeNum] = like;
    }

    /**
     * Allows commenting to a post
     * @param comment
     */
    public void addComment(Comment comment)
    {
        System.out.println("Commenting the post with content : " + this.content);
        int commentNum = emptyIndex(comments);
        comments[commentNum] = comment;
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
        int likeNum = emptyIndex(likes);
        int commentNum = emptyIndex(comments);

        System.out.println("(Post ID : "+ postId + ") " + content + ".");
        if(likeNum == 0) System.out.println("The post has no likes");
        else
        {
            System.out.print("The post was liked by the following account(s) : ");
            for (int i = 0; i < likeNum; i++)
            {
                System.out.print(likes[i].getUserName() + ", ");
            }
            System.out.println();
        }

        if(commentNum == 0) System.out.println("The post has no comments");
        else
        {
            System.out.println("The post has " + commentNum + " comment(s)");
            for (int i = 0; i < commentNum; i++) {
                System.out.print("Comment " + i+1 + " : ( from : " +comments[i].getUserName() + " )"  + comments[i].getContent() + ", ");
            }
            System.out.println();
        }
    }
}
