package io;

import com.sun.javaws.exceptions.InvalidArgumentException;

public interface ArgumentParser<T> {
    T parse(String[] args) throws InvalidArgumentException;
}
