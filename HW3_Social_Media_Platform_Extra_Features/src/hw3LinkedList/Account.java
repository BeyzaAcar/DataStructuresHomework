package hw3LinkedList;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Class for the Accounts
 * @author BeyzaAcar
 */

public class Account
{
    private final int accountId;
    private final String username;
    private final String birthdate;
    private final String location;
    private LinkedList<Post> posts;
    private LinkedList<Message> outbox;
    private LinkedList<Message> inbox;
    private LinkedList<Account> followings; //this indicates the accounts following by this user.
    private LinkedList<Account> followers; // this indicates the accounts following this user.
    private LinkedList<Account> blockedAccounts;
    private LinkedList<String> actions;
    private boolean isOpen; //This variable indicates whether the account is open or not.
    //private boolean isViewed; // This variable indicates whether the account's profile is being viewed or not

    /**
     * Constructor of Account class
     * @param accountId
     * @param username
     * @param birthdate
     * @param location
     */
    public Account(int accountId, String username, String birthdate, String location)
    {
        isOpen =false;
        this.accountId = accountId;
        this.username = username;
        this.birthdate = birthdate;
        this.location = location;
        this.posts = new LinkedList<Post>();
        this.outbox = new LinkedList<Message>();
        this.inbox = new LinkedList<Message>();
        this.followings = new LinkedList<Account>();
        this.followers = new LinkedList<Account>();
        this.blockedAccounts = new LinkedList<Account>();
        this.actions = new LinkedList<String>();
        //System.out.println("An account with username " + username + "has been created...");
    }
    /**
     * Checks two objects by looking at their values
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return accountId == account.accountId && username.equals(account.username) && birthdate.equals(account.birthdate);
    }

    /**
     *  It generates a hash code based on the accountId, username, and birthdate values.
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(accountId, username, birthdate);
    }

    /**
     * Just returns username
     * @return username
     */
    @Override
    public String toString()
    {
        return username;
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
     *Getter for blocked accounts.
     * @return blockedAccounts[]
     */
    public LinkedList<Account> getBlockedAccounts()
    {
        return blockedAccounts;
    }

    /**
     * Allows to log into this account
     * @throws Exception
     */
    public void logIn() throws Exception
    {
        if(isOpen) {throw new Exception("You cannot re-login to an account that is already logged in.");}

        //System.out.printf("Login into an account (username : %s)...\n", username);
        isOpen = true;
    }

    /**
     * Allows to log out of this account
     * @throws Exception
     */
    public void logOut() throws Exception
    {
        if(!isOpen) {throw new Exception("You cannot re-logout to an account that is already logged out.");}

        //System.out.printf("Logout of an account (username : %s)...\n", username);
        isOpen = false;
    }

    /**
     * to add a post to this account
     * @param postToAdd is post to be added
     * @throws Exception
     */
    public void addPost(Post postToAdd) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}

        //System.out.println("Being shared a post from an account named "+ username);
        //System.out.println("Sharing posts...");
        posts.addLast(postToAdd);
        actions.addLast("You add a post. PostID : " + postToAdd.getPostId());
    }

    /**
     * Allows this account to follow another account
     * @param toFollow is account to be followed
     * @throws Exception
     */
    public void follow(Account toFollow /* (Variable of "toFollow" is the account to follow*/) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}
        if(isBlocked(toFollow) == true)
        {
            System.out.println("You can not follow this account because this account has blocked you. :(");
            return;
        }
        followings.addLast(toFollow);
        toFollow.addFollowers(this);
        //System.out.println("An account named " + toFollow.getUsername() +  " has been followed...");
        actions.addLast("An account named " + toFollow.getUsername() +  " has been followed...");
    }

    /**
     * unfollows an account
     * @param toUnfollow
     * @throws Exception
     */
    public void unfollow(Account toUnfollow ) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}
        followings.remove(toUnfollow);
        toUnfollow.removeFollowers(this);
        //System.out.println("An account named " + toUnfollow.getUsername() +  " has been unfollowed...");
        actions.addLast("An account named " + toUnfollow.getUsername() +  " has been unfollowed...");
    }


    /**
     *Allows another account to follow this account
     * @param followRequest is the Account that wants to follow this account
     */
    public void addFollowers(Account followRequest)
    {
        followers.addLast(followRequest);
        actions.addLast("An account named " + followRequest.getUsername() + " followed you");
    }

    /**
     * Removes an account from followers when someone unfollows this account
     * @param unfollowRequest
     */
    public void removeFollowers(Account unfollowRequest)
    {
        followers.remove(unfollowRequest);
        actions.addLast("An account named " + unfollowRequest.getUsername() + " unfollowed you");
    }

    /**
     *Allows view someone else's account
     * @param otherAccount is the account that is about to be viewed
     * @throws Exception
     */
    public void viewProfile(Account otherAccount) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}
        if(isBlocked(otherAccount) == true)
        {
            System.out.println("You can not view this account because this account has blocked you. :(");
            return;
        }
        otherAccount.viewProfile();
    }

    /**
     * Allows this account to be viewed
     */
    private void viewProfile()
    {
        System.out.println("Viewing account...");
        System.out.println("-------------------------");
        System.out.println("accountId is : " + accountId);
        System.out.println("location is : " + location);
        System.out.println("username is : " + username);
        System.out.println("birth date is : "+ birthdate);

        if(followers.size() == 0) System.out.println("There is not any followers of this account.");
        else
        {
            System.out.println(username + " is following " + followings.size() + "  account(s) and has " + followers.size() + " follower(s)");

            System.out.print("The followers of " + username + " are :");
            for (int i = 0; i < followers.size(); i++) {
                System.out.print(followers.get(i)+ " ");
            }
        }
        System.out.println();

        if(followings.size() == 0) System.out.println("This account does not following any account.");
        else
        {
            System.out.print(username + " is following : ");
            for (int i = 0; i < followings.size(); i++) {
                System.out.print(followings.get(i) + " ");
            }
            System.out.println();
        }

        System.out.println(username + " has " + posts.size() + " post(s)");
    }

    /**
     * Allows viewing posts of another account
     * @param otherAccount is the account to be viewed
     * @throws Exception
     */
    public void viewPosts(Account otherAccount) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}
        if(isBlocked(otherAccount) == true)
        {
            System.out.println("You can not view posts of this account because this account has blocked you. :(");
            return;
        }
        otherAccount.viewPosts();
    }

    /**
     * Allows viewing post of this account
     */
    private void viewPosts()
    {
        if(posts.size() == 0)
        {
            System.out.println("There is not a post here");
            return;
        }
        System.out.println("Viewing posts ...");
        System.out.println("-------------------------");
        int i;
        for(i=0;i< posts.size();i++)
        {
            System.out.println(posts.get(i));
        }
    }

    /**
     * Likes a post
     * @param post is post to like
     * @throws Exception
     */
    public void likePost(Post post, Like like) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}
        post.addLike(like);
        actions.addLast("You liked a post. PostID : " + post.getPostId());
    }

    /**
     * Unlikes a post
     * @param post
     * @throws Exception
     */
    public void unlikePost(Post post, Like like) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}

        post.unlike(like);
        actions.addLast("You unliked a post belongs to " + post.getUsername() + " PostID : " + post.getPostId());
    }

    /**
     * Comments a post
     * @param post is post to comment
     * @throws Exception
     */
    public void commentPost(Post post , Comment comment) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}
        post.addComment(comment);
        actions.addLast("You commented a post. Post id : " + post.getPostId());
    }

    /**
     * Removes a comment from a post
     * @param post
     * @throws Exception
     */
    public void uncommentPost(Post post , Comment comment) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}
        post.uncomment(comment);
        actions.addLast("You uncommented a post. Post id : " + post.getPostId());
    }

    /**
     * Allows adding a message to inbox of this account
     * @param message
     */
    private void addMessageToInbox(Message message)
    {
        inbox.addLast(message);
        System.out.println("Message is sent!");
        actions.addLast("You recieved a message from " + message.getSenderUserName());
    }

    /**
     * Allows adding a message to the outbox of an account
     * @param message
     * @param toWho is the owner account of the sent message
     * @throws Exception
     */
    public void addMessageToOutbox(Message message, Account toWho) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}

        int flag = 0; /*if flag would be 1 that means the account we are trying to send a message is followed, so we can send the message, otherwise we can not*/
        for(int i = 0;i<followings.size();i++)/*checks the account we are trying to message is followed or not, if not we can not send a message to that account*/
        {
            if(followings.get(i).equals(toWho)) flag = 1;
        }
        if(flag == 0) {throw new Exception("You do not follow this account, you can not send this account a message");}
        if(isBlocked(toWho) == true)
        {
            System.out.println("You can not send a message to this account because this account has blocked you. :(");
            return;
        }
        outbox.addLast(message);
        toWho.addMessageToInbox(message);
        actions.addLast("You sent a message to " + message.getReceiverUserName());
    }

    /**
     * Allows viewing inbox of this account
     */
    public void viewInbox()
    {
        if(inbox.size() == 0)
        {
            System.out.println("There is not a message in the inbox.");
            return;
        }
        System.out.println("...Viewing inbox...");
        System.out.println("-------------------------");
        for(int i=0;i<inbox.size();i++)
        {
            System.out.print(inbox.get(i));
        }
        System.out.println();
    }

    /**
     * Allows viewing outbox of this account
     */
    public void viewOutbox()
    {
        if(outbox.size() == 0)
        {
            System.out.println("There is not a message in the outbox.");
            return;
        }
        System.out.println("...Viewing outbox...");
        System.out.println("-------------------------");
        for(int i=0;i<outbox.size();i++)
        {
            System.out.print(outbox.get(i));
        }
        System.out.println();
    }

    /**
     * Checks how many messages in the inbox
     */
    public void checkInbox()
    {
        System.out.println("...Checking inbox...");
        System.out.println("-------------------------");
        System.out.println("There is/are " + inbox.size() + " message(s) in the inbox");
    }
    /**
     * Checks how many messages in the outbox
     */
    public void checkOutbox()
    {
        System.out.println("...........Checking outbox..........");
        System.out.println("------------------------------------------");
        System.out.println("There is/are " + outbox.size() + " message(s) in the outbox");
    }

    /**
     * Allows viewing post's interactions of another account
     * @param other is the account to be viewed its post's interactions
     * @throws Exception
     */
    public void viewPostInteractions(Account other) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}
        other.viewPostInteractions();
    }

    /**
     * Allows viewing post's interactions of this account
     */
    private void viewPostInteractions()
    {
        if(posts.size() == 0)
        {
            System.out.println("There is not a post in this account.");
            return;
        }
        System.out.println("Viewing post interactions");
        System.out.println("----------------------");
        for(int i = 0;i< posts.size();i++)
        {
            posts.get(i).viewPostInteractions();
        }
    }

    /**
     * Allows block an account
     * @param accountToBlock is the account to be blocked
     * @throws Exception
     */
    public void block(Account accountToBlock) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}
        blockedAccounts.addLast(accountToBlock);
        //.out.println(username + " has blocked an account named " + accountToBlock.getUsername());
        actions.addLast("You blocked " + accountToBlock.getUsername());
    }

    /**
     * Unblocks an account
     * @param toUnblock the account to be unblocked
     */
    public void unblock(Account toUnblock) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}
        blockedAccounts.remove(toUnblock);
        //System.out.println(username + " has unblocked an account named " + toUnblock.getUsername());
        actions.addLast("You unblocked " + toUnblock.getUsername());
    }

    /**
     * Checks whether if @param accountToCheck is blocked or not.
     * @param accountToCheck is an account to check if it is blocked by this account or not.
     * @return a boolean indicates the account is blocked or not. (If yes returns true, otherwise false)
     */
    public boolean isBlocked(Account accountToCheck)
    {
        for(int i = 0;i<accountToCheck.getBlockedAccounts().size();i++)
        {
            if(this.equals(accountToCheck.getBlockedAccounts().get(i))) return true;
        }
        return false;
    }

    /**
     * Views user actions
     */
    public void viewActions()
    {
        System.out.println("----------------------Viewing Actions --------------------");
        for(int i = 0;i< actions.size();i++)
        {
            System.out.println(actions.get(i));
        }
    }
}