package com.shop.command;

/**
 * Exiting menu command
 *
 * @author maciej.jasinski2@gmail.com
 * @since 30.11.2019
 */
public final class ExitMenuCommand<T> implements MenuCommand<T> {
    @Override
    public void execute(Object context) {

    }

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public String toString() {
        return "EXIT";
    }
}
