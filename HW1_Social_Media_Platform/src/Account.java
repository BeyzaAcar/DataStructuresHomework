package homework1;

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
    private Post[] posts;
    private Message[] outbox;
    private Message[] inbox;
    private Account[] followings; //this indicates the accounts following by this user.
    private Account[] followers; // this indicates the accounts following this user.
    private Account[] blockedAccounts;
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
        this.posts = new Post[15];
        this.outbox = new Message[15];
        this.inbox = new Message[15];
        this.followings = new Account[15];
        this.followers = new Account[15];
        this.blockedAccounts = new Account[15];
        System.out.println("An account with username " + username + "has been created...");
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
    public Account[] getBlockedAccounts()
    {
        return blockedAccounts;
    }

    /**
     * Returns the first empty index in a message array
     * @param message is a Message array
     * @return empty index
     * @throws IndexOutOfBoundsException
     */
    public int emptyIndex(Message[] message) throws IndexOutOfBoundsException
    {
        int i;
        for(i=0;i<message.length;i++)
        {
            if(message[i] == null) return i;
        }
        throw new IndexOutOfBoundsException("No empty space in message array.");
    }
    /**
     * Returns the first empty index in a post array
     * @param post is a Post array
     * @return empty index
     * @throws IndexOutOfBoundsException
     */
    public int emptyIndex(Post[] post) throws IndexOutOfBoundsException
    {
        int i;
        for(i=0;i<post.length;i++)
        {
            if(post[i] == null) return i;
        }
        throw new IndexOutOfBoundsException("No empty space in post array.");
    }
    /**
     * Returns the first empty index in an account array
     * @param account is an Account array
     * @return empty index
     * @throws IndexOutOfBoundsException
     */
    public int emptyIndex(Account[] account) throws IndexOutOfBoundsException
    {
        int i;
        for(i=0;i<account.length;i++)
        {
            if(account[i] == null) return i;
        }
        throw new IndexOutOfBoundsException("No empty space in account array.");
    }

    /**
     * Allows to log into this account
     * @throws Exception
     */
    public void logIn() throws Exception
    {
        if(isOpen) {throw new Exception("You cannot re-login to an account that is already logged in.");}

        System.out.printf("Login into an account (username : %s)...\n", username);
        isOpen = true;
    }

    /**
     * Allows to log out of this account
     * @throws Exception
     */
    public void logOut() throws Exception
    {
        if(!isOpen) {throw new Exception("You cannot re-logout to an account that is already logged out.");}

        System.out.printf("Logout of an account (username : %s)...\n", username);
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
        System.out.println("Being shared a post from an account named "+ username);
        int postNum;

        System.out.println("Sharing posts...");
        postNum = emptyIndex(posts);
        posts[postNum] = postToAdd;
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

        int followingNum;
        followingNum = emptyIndex(followings);
        followings[followingNum] = toFollow;
        toFollow.addFollowers(this);
        System.out.println("An account named " + toFollow.getUsername() +  " has been followed...");
    }

    /**
     *Allows another account to follow this account
     * @param followRequest is the Account that wants to follow this account
     */
    public void addFollowers(Account followRequest)
    {
        int followersNum = emptyIndex(followers);
        followers[followersNum] = followRequest;
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
    public void viewProfile()
    {
        int followingNum = emptyIndex(followings);
        int followersNum = emptyIndex(followers);
        int postNum = emptyIndex(posts);
        System.out.println("Viewing account...");
        System.out.println("-------------------------");
        System.out.println("accountId is : " + accountId);
        System.out.println("location is : " + location);
        System.out.println("username is : " + username);
        System.out.println("birth date is : "+ birthdate);

        if(followersNum == 0) System.out.println("There is not any followers of this account.");
        else
        {
            System.out.print("The followers of " + username + " are :");
            for (int i = 0; i < followersNum; i++) {
                System.out.print(followers[i] + " ");
            }
        }
        System.out.println();

        if(followingNum == 0) System.out.println("This account does not following any account.");
        else
        {
            System.out.println(username + " is following " + followingNum + "  account(s) and has " + followersNum + " follower(s)");
            System.out.print(username + " is following : ");
            for (int i = 0; i < followingNum; i++) {
                System.out.print(followings[i] + " ");
            }
            System.out.println();
        }

        System.out.println(username + " has " + postNum + " post(s)");
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
    public void viewPosts()
    {
        int postNum = emptyIndex(posts);
        if(postNum == 0)
        {
            System.out.println("There is not a post here");
            return;
        }
        System.out.println("Viewing posts ...");
        System.out.println("-------------------------");
        int i;
        for(i=0;i<postNum;i++)
        {
            System.out.println(posts[i]);
        }
    }

    /**
     * Allows liking a post
     * @param interactionId
     * @param post is post to like
     * @throws Exception
     */
    public void likePost(int interactionId, Post post) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}

        Like like = new Like(interactionId, post, this);
        post.addLike(like);
    }

    /**
     * Allows commenting to a post
     * @param interactionId
     * @param post is post to comment
     * @param content is the content of comment
     * @throws Exception
     */
    public void commentPost(int interactionId, Post post , String content) throws Exception
    {
        if(!isOpen) {throw new Exception("You are not logged in");}
        Comment comment = new Comment(interactionId, post, this, content);
        post.addComment(comment);
    }

    /**
     * Allows adding a message to inbox of this account
     * @param message
     */
    public void addMessageToInbox(Message message)
    {
        int messageNum = emptyIndex(inbox);
        inbox[messageNum] = message;
        System.out.println("Message is sent!");

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

        int followingNum = emptyIndex(followings), flag = 0; /*if flag would be 1 that means the account we are trying to send a message is followed, so we can send the message, otherwise we can not*/
        for(int i = 0;i<followingNum;i++)
        {
            if(followings[i].equals(toWho)) flag = 1;
        }
        if(flag == 0) {throw new Exception("You do not follow this account, you can not send this account a message");}
        if(isBlocked(toWho) == true)
        {
            System.out.println("You can not send a message to this account because this account has blocked you. :(");
            return;
        }
        int messageNum = emptyIndex(outbox);
        outbox[messageNum] = message;
        toWho.addMessageToInbox(message);
    }

    /**
     * Allows viewing inbox of this account
     */
    public void viewInbox()
    {
        int i, inboxNum = emptyIndex(inbox);
        if(inboxNum == 0)
        {
            System.out.println("There is not a message in the inbox.");
            return;
        }
        System.out.println("...Viewing inbox...");
        System.out.println("-------------------------");
        for(i=0;i<inboxNum;i++)
        {
            System.out.print(inbox[i]);
        }
        System.out.println();
    }

    /**
     * Allows viewing outbox of this account
     */
    public void viewOutbox()
    {
        int i, outboxNum = emptyIndex(outbox);
        if(outboxNum == 0)
        {
            System.out.println("There is not a message in the outbox.");
            return;
        }
        System.out.println("...Viewing outbox...");
        System.out.println("-------------------------");
        for(i=0;i<outboxNum;i++)
        {
            System.out.print(outbox[i]);
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
        int messageNum = emptyIndex(inbox);
        System.out.println("There is/are " + messageNum + " message(s) in the inbox");
    }
    /**
     * Checks how many messages in the outbox
     */
    public void checkOutbox()
    {
        System.out.println("...........Checking outbox..........");
        System.out.println("------------------------------------------");
        int messageNum = emptyIndex(outbox);
        System.out.println("There is/are " + messageNum + " message(s) in the outbox");
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
    public void viewPostInteractions()
    {
        int postNum = emptyIndex(posts);
        if(postNum == 0)
        {
            System.out.println("There is not a post in this account.");
            return;
        }
        System.out.println("Viewing post interactions");
        System.out.println("----------------------");
        for(int i = 0;i<postNum;i++)
        {
            posts[i].viewPostInteractions();
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
        int blockNum = emptyIndex(blockedAccounts);
        blockedAccounts[blockNum] = accountToBlock;
        System.out.println(username + " has blocked an account named " + accountToBlock.getUsername());
    }

    /**
     * Checks whether if @param accountToCheck is blocked or not.
     * @param accountToCheck is an account to check if it is blocked by this account or not.
     * @return a boolean indicates the account is blocked or not. (If yes returns true, otherwise false)
     */
    public boolean isBlocked(Account accountToCheck)
    {
        int blockNum = emptyIndex(accountToCheck.getBlockedAccounts());
        for(int i = 0;i<blockNum;i++)
        {
            if(this.equals(accountToCheck.getBlockedAccounts()[i])) return true;
        }
        return false;
    }
}