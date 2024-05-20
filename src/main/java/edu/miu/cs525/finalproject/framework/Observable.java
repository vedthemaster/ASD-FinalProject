package edu.miu.cs525.finalproject.framework;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Transaction transaction);
}
