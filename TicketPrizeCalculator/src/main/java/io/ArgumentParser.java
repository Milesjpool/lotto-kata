package io;

public interface ArgumentParser<T> {
    T parse(String[] args) throws InvalidArgumentException;
}
