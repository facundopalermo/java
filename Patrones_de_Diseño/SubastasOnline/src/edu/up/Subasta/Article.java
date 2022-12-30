package edu.up.Subasta;

import java.util.ArrayList;
import java.util.List;

public class Article implements Auction {

    private String description;
    private double initialPrice;
    private double targetPrice;
    private double actualPrice;
    private boolean selled = false;
    private List<UserObserver> observers;

    public Article(String description, double initialPrice, double targetPrice) {
        this.description = description;
        this.initialPrice = initialPrice;
        this.actualPrice = initialPrice;
        this.targetPrice = targetPrice;
        this.observers = new ArrayList<UserObserver>();
    }

    @Override
    public void registerUser(UserObserver observeUser) {
        observers.add(observeUser);
    }

    @Override
    public void removeUser(UserObserver observeUser) {
        observers.remove(observeUser);
        
    }

    @Override
    public void notifyUsers() {
        
        for (UserObserver user : observers) {
            user.update(this);
        }
    }

    public boolean thereAreObservers() {
        return this.observers.size()>0?true:false;
    }

    /*
     * GETTERS Y SETTERS
     */

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(double targetPrice) {
        this.targetPrice = targetPrice;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
        notifyUsers();
    }

    public boolean isSelled() {
        return selled;
    }

    public void setSelled(boolean selled) {
        this.selled = selled;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }
}
