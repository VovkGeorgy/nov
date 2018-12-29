package main.java.by.home.nov2.entity;

/**
 * Interface Text, with main operations for text entity
 */
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
    void printInConsole();

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
