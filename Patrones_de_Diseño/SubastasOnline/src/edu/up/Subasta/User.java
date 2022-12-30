package edu.up.Subasta;

import java.util.Random;

/**
 * User
 */
public abstract class User implements UserObserver{

    protected String name;
    protected String source;
    protected Random random = new Random();

    protected User (String name, String source) {
        this.name = name;
        this.source = source;
    }

    protected Article createAuction(String description, double initialPrice, double targetPrice) {
        return new Article(description, initialPrice, targetPrice);
    }

    protected void joinAuction(Auction auction) {
        auction.registerUser(this);
    }

    protected void leaveAuction(Auction auction) {
        auction.removeUser(this);
    }

    protected boolean acceptOffer(double actualPrice) {
        return random.nextInt(100)==1?true:false;
    }

    protected double toOffer(double actualPrice) {
        /*ofertan un valor random entre el 1 y 10% */
        return !leave()?(actualPrice + (actualPrice * (random.nextInt(1, 11)))/100):0;
    }

    protected boolean leave() {
        return random.nextInt(50)==1?true:false;
    }

    /*
     * GETTERS Y SETTERS
     */
    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getSource() {
        return source;
    }

    protected void setSource(String source) {
        this.source = source;
    }
    
}