package hw3ArrayList;

public class TestClass4 {
    public static void main(String[] args)
    {
        long start = java.lang.System.currentTimeMillis();

        System.out.println("SCENARIO 4");
        System.out.println("THIS SCENARIO IS SEPARATE FROM THE PREVIOUS SCENARIOS !!!");

        Account gizem = new Account(0, "gizemsungu", "10.03.1900", "istanbul");
        Account gokhan = new Account(1, "gokhankaya", "10.03.1900", "istanbul");
        Account sibel = new Account(2, "sibelgulmez", "10.03.1900", "istanbul");
        Account ac0 = new Account(3, "account0", "10.03.1900", "istanbul");
        Account ac1 = new Account(4, "account1", "10.03.1900", "istanbul");
        Account ac2 = new Account(5, "account2", "10.03.1900", "istanbul");
        Account ac3 = new Account(6, "account3", "10.03.1900", "istanbul");
        Account ac4 = new Account(7, "account4", "10.03.1900", "istanbul");
        Account ac5 = new Account(8, "account5", "10.03.1900", "istanbul");
        Account ac6 = new Account(9, "account6", "10.03.1900", "istanbul");
        System.out.println("**************STEP 1 : 10 account has been created**************");
        try{
            sibel.logIn();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        Post post1 = new Post(1, "sibelgulmez", "This is my first post guyysss!!");
        Post post2 = new Post(2, "sibelgulmez", "This is my second post and Im not excited now :(");
        try {
            sibel.addPost(post1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sibel.addPost(post2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("**************STEP 2 :  sibelgulmez add 2 post**************");
        try {
            sibel.follow(gokhan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sibel.follow(gizem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            sibel.logOut();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("**************STEP 3 : sibelgulmez followed gokhan and gizem and logged out**************");
        try{
            gokhan.logIn();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        Like like1 = new Like(1, post1, gokhan);
        try {
            gokhan.likePost(post1, like1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Comment comment1 = new Comment(2, post2, gokhan, "Nice!");
        try {
            gokhan.commentPost(post2, comment1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Comment comment2 = new Comment(3, post1, gokhan, "Keep calm sibel, it is not that exciting :|");
        try {
            gokhan.commentPost(post1, comment2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gokhan.logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("**************STEP 4 : gokhan logged in, comment and like the sibel's post **************");
        try{
            sibel.logIn();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        try{
            sibel.viewActions();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        try {
            sibel.logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("**************STEP 5 : sibel logged in and viewed actions of her account and logged out**************");
        try {
            gokhan.logIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gokhan.unlikePost(post1, like1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gokhan.uncommentPost(post1, comment1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gokhan.logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
        gokhan.viewActions();
        System.out.println("**************STEP 6 : gokhan logged in, unliked and uncommented sibel's post, viewed actions and logged out**************");
        try {
            sibel.logIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            sibel.viewPostInteractions(sibel);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            sibel.logOut();
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("**************STEP 7 : sibel logged in view interactions of her posts**************");
        try{
            gokhan.logIn();
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            gokhan.block(sibel);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            gokhan.logOut();
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            sibel.logIn();
        } catch(Exception e){
            e.printStackTrace();
        }
        Message message1 = new Message(1, "sibelgulmez", "gokhankaya", "I always hate Java gokhan, I love Python you should know that");
        try{
            sibel.addMessageToOutbox(message1, gokhan);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            sibel.logOut();
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            gokhan.logIn();
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            gokhan.viewInbox();
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("**************STEP 8 : gokhan blocked sibel and sibel tried to send a message to him and gokhan viewed his message inbox");
        try{
            gokhan.unblock(sibel);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            gokhan.logOut();
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            sibel.logIn();
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            sibel.addMessageToOutbox(message1, gokhan);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            sibel.logOut();
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            gokhan.logIn();
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            gokhan.viewInbox();
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("**************STEP 9 : gokhan unblocked sibel and sibel tried to send a message to him again and gokhan viewed his message inbox");
        try{
            gokhan.follow(gizem);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            gokhan.viewProfile(gizem);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            gokhan.unfollow(gizem);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            gokhan.viewProfile(gizem);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            gokhan.logOut();
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("**************STEP 10 : gokhan followed gizem and viewed her profile, then gokhan \nunfollowed gizem and view her profile again, there is \none fewer follower due to gokhan's unfollowing*********************");
        try{
            ac0.logIn();
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac0.follow(sibel);
        } catch(Exception e){
            e.printStackTrace();
        }
        Like like2 = new Like(4, post1, ac0);
        try{
            ac0.likePost(post2, like2);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac0.logOut();
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.logIn();
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.follow(sibel);
        } catch(Exception e){
            e.printStackTrace();
        }
        Like like3 = new Like(5, post1, ac1);
        try{
            ac1.likePost(post1, like3);
        } catch(Exception e){
            e.printStackTrace();
        }
        Comment comment3 = new Comment(6, post2, ac0, "Ahh, I'm always tired you know, Im jealous of you actually, probably gokhan is too");
        Comment comment4 = new Comment(7, post2, ac1, "I'm new here, is this message box or everyone can see this?");
        Comment comment5 = new Comment(8, post2, ac1, "I'm so sorry, I didnt know everyone can see these, I'm deleting right now my comments");
        Comment comment6 = new Comment(9, post2, ac1, "No sibel keep being excited !!! Love you <3 ");

        try{
            ac1.commentPost(post2, comment4);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.commentPost(post2, comment3);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.commentPost(post2, comment5);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.viewProfile(sibel);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.viewPostInteractions(sibel);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.viewPostInteractions(sibel);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.uncommentPost(post2, comment3);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.uncommentPost(post2, comment4);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.uncommentPost(post2, comment5);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.commentPost(post2, comment6);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.viewPostInteractions(sibel);
        } catch(Exception e){
            e.printStackTrace();
        }
        try{
            ac1.logOut();
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("**************STEP 11 : account0 liked sibel's post and account1 liked and comment sibel's post twice, removed one of them and viewed her post again*********************");
        System.out.println("\n*******************************************************\n");
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");
    }
}
