package hw3LinkedList;

import java.util.LinkedList;

public class TestClass2
{
    public static void main(String[] args) {
        long start = java.lang.System.currentTimeMillis();

        System.out.println("SCENARIO 2");

        System.out.println("STEP 1...");
        Account gizem = new Account(1, "gizemsungu", "10.03.1900", "istanbul");
        Account sibel = new Account(2, "sibelgulmez", "10.03.1800", "istanbul");
        Account gokhan = new Account(3, "gokhankaya", "10.03.1950", "istanbul");

        System.out.println("\n*******************************************************\n");
        System.out.println("STEP 2...");
        try{
            sibel.logIn();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("STEP 3...");
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
        System.out.println("STEP 4...");
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
        System.out.println("STEP 5...");
        try{
            sibel.logOut();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("\n*******************************************************\n");
        System.out.println("STEP 6...");
        try{
            gokhan.logIn();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("STEP 7...");
        try {
            gokhan.viewProfile(sibel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 8...");
        try {
            gokhan.viewPosts(sibel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 9...");
        Like like1 = new Like(1, post1, gokhan);
        try {
            gokhan.likePost(post1, like1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 10...");
        Comment comment1 = new Comment(2, post1, gokhan, "Keep calm sibel, it is not that exciting :|");
        try {
            gokhan.commentPost(post1, comment1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 11...");
        try {
            gokhan.follow(gizem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gokhan.follow(sibel);
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("STEP 12...");
        Message message1 = new Message(1, "gokhankaya", "gizemsungu", "Hey gizem, look how funny the comment I made to sibel's post");
        try {
            gokhan.addMessageToOutbox(message1, gizem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 13...");
        try{
            gokhan.logOut();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("\n*******************************************************\n");
        System.out.println("STEP 14...");
        try {
            gizem.logIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 15...");
        gizem.checkInbox();
        System.out.println("STEP 16...");
        gizem.checkOutbox();
        System.out.println("STEP 17...");
        gizem.viewInbox();
        System.out.println("STEP 18...");
        try {
            gizem.viewProfile(sibel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 19...");
        try {
            gizem.viewPosts(sibel);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("STEP 20...");
        try {
            gizem.viewPostInteractions(sibel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gizem.viewPosts(sibel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 21...");
        Like like2 = new Like(3, post1, gizem);
        try {
            gizem.likePost(post1, like2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 22...");
        try {
            gizem.viewPostInteractions(sibel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gizem.logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n*******************************************************\n");
        System.out.println("CONTINUE FROM HERE");
        System.out.println("\n*******************************************************\n");

        System.out.println("STEP 23...");
        try {
            gizem.logIn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("STEP 24...");
        Post post3 = new Post(3, "gizemsungu", "Guys, can you tell am I gonna pass cse222 class");
        Post post4 = new Post(4, "gizemsungu", "at least I like Java");
        try {
            gizem.addPost(post3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gizem.addPost(post4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 25...");
        try {
            gizem.logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 26...");
        try {
            sibel.logIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 27...");
        Like like3 = new Like(4, post1, sibel);
        try {
            sibel.likePost(post3, like3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 28...");
        try {
            sibel.logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 29...");
        try {
            gokhan.logIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 30...");
        try {
            gokhan.viewProfile(gizem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 31...");
        Comment comment2 = new Comment(5, post4, gokhan, "Nice!");
        try {
            gokhan.commentPost(post4, comment1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 32...");
        Message message2 = new Message(2, "gokhankaya", "gizemsungu", "Hello!");
        try {
            gokhan.addMessageToOutbox(message2, gizem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 33...");
        try {
            gokhan.logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 34...");
        try {
            gizem.logIn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 35...");
        try {
            gizem.viewProfile(gizem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STEP 36...");
        gizem.viewInbox();
        System.out.println("STEP 37...");
        try {
            gizem.logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n*******************************************************\n");
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");
    }
}
