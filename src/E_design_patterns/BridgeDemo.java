package E_design_patterns;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
without bridge pattern:
FileLogger, ConsoleLogger, NetworkLogger,
ErrorFileLogger, ErrorConsoleLogger, ErrorNetworkLogger
 */

/*
We have two hierarchies: the abstraction (logger) and the implementation (outputter),
and a bridge between them.
 */

// abstraction (what the client interacts with)
class Logger {
    protected final Outputter outputter;

    public Logger(Outputter outputter) {
        this.outputter = outputter;
    }

    public void log(String message) {
        outputter.output(message);
    }
}

// refined abstraction
class ErrorLogger extends Logger {
    public ErrorLogger(Outputter outputter) {
        super(outputter);
    }

    @Override
    public void log(String message) {
        outputter.output("Error: " + message);
    }
}

// implementation (does the low-level work)
interface Outputter {
    void output(String message);
}

// a concrete implementation
class ConsoleOutputter implements Outputter {
    @Override
    public void output(String message) {
        System.out.println(message);
    }
}

class FileOutputter implements Outputter {
    private PrintStream printStream;

    public FileOutputter(String filename) throws FileNotFoundException {
        printStream = new PrintStream(filename);
    }

    @Override
    public void output(String message) {
        printStream.println(message);
    }
}

class NetworkOutputter implements Outputter {
    @Override
    public void output(String message) {
        System.out.println("outputting to network...."); // TODO
    }
}

public class BridgeDemo {
    public static void main(String[] args) {
        Logger logger = new ErrorLogger(new ConsoleOutputter());
    }
}
