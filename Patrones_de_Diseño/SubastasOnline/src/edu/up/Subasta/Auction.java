package edu.up.Subasta;

/* Subject */
public interface Auction {
    
    public void registerUser(UserObserver observeUser);
    public void removeUser(UserObserver observeUser);
    public void notifyUsers();

}
