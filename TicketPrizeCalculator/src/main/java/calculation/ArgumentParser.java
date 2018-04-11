package calculation;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class ArgumentParser {
    public String getLotteryName(String[] args) throws InvalidArgumentException {
        if (args == null || args.length != 3)
            throw new InvalidArgumentException(args);

        return args[0];
    }
}
