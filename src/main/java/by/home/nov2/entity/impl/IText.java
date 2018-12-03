package main.java.by.home.nov2.entity.impl;

public interface IText {

    /**
     * Add text from console in memory
     */
    void addText();

    /**
     * Read text from file in filesystem to memory
     */
    void readFromFile();

    /**
     * Write text from memory in file
     */
    void writeInFile();

    /**
     * Write text from memory into console
     */
    void writeInConsole();

    /**
     * Add cats in text
     */
    void addCats();

    /**
     * Get text file name in console
     * @return - file name
     */
    String getTextFileName();
}
