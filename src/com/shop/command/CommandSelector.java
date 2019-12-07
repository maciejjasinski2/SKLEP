package com.shop.command;

import com.shop.util.ListSelector;

import java.util.List;

import static com.shop.util.Precondition.checkArgument;
import static com.shop.util.Precondition.requireNonNulls;

/**
 * ... comment class ...
 *
 * @author maciej.jasinski2@gmail.com
 * @since 30.11.2019
 */
public final class CommandSelector<T> {

    private final List<MenuCommand<T>> commands;
    private final ListSelector listSelector;

    public CommandSelector(List<MenuCommand<T>> commands, ListSelector listSelector) {

        requireNonNulls(commands, listSelector);
        checkArgument(!commands.isEmpty(), "empty commands list");
        this.commands = commands;
        this.listSelector = listSelector;
    }

    public void select(T context) {

        while (true) {
            int selected = listSelector.select(commands);
            MenuCommand<T> command = commands.get(selected - 1);
            command.execute(context);
            if (command.isExit()) {
                return;
            }
        }
    }
}
