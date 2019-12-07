package com.shop.command;

/**
 * Menu comands intraface
 *
 * @author maciej.jasinski2@gmail.com
 * @since 30.11.2019
 */
public interface MenuCommand <T> {

    void execute (T context);

    default boolean isExit() {
        return false;
    }

}
