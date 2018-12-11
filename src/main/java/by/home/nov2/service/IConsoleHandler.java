package main.java.by.home.nov2.service;

/**
 * Functional interface who need to send method as a parameter to others methods
 */
public interface IConsoleHandler {

    /**
     * Method who keep link to overrided methods, by some class which call this interface
     */
    void processRequest();

}
