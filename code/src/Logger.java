/* Object oriented design patterns
* Creational Patterns:, Structural Patterns:, Behavioral Patterns:
* Creational pattern
Creational patterns deal with object creation mechanisms,
*  providing ways to create objects while hiding the creation logic,
*  making the system more flexible and easy to maintain.
*  Examples include:Singleton pattern

* */


// Logger.java
public class Logger {

    // Private static instance of the logger
    private static Logger instance;

    // Private constructor to prevent instantiation from outside
    private Logger() {
        // Initialization code such as opening log file, setting up connections, etc.
    }

    // Public static method to get the instance of the logger
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Example method to log a message
    public void log(String message) {
        // Example: Print message to console (replace with actual logging implementation)
        System.out.println("Log: " + message);
    }

    // Example method to demonstrate logging functionality
    public void doSomething() {
        // Example usage of the logger
        log("Doing something...");
    }

    // Main method to demonstrate usage of the Logger class
    public static void main(String[] args) {
        // Get instance of the logger
        Logger logger = Logger.getInstance();

        // Use the logger to log messages
        logger.log("Starting application...");
        logger.doSomething();
        logger.log("Application finished.");
    }
}
