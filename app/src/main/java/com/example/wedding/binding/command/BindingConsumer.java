package com.example.wedding.binding.command;

/**
 * @author

 */
public interface BindingConsumer<T> {
    void execute(T t);
}
