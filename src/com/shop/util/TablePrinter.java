package com.shop.util;

import java.util.List;

import static com.shop.util.Precondition.checkArgument;
import static com.shop.util.Precondition.requireNonNulls;

/**
 * Table Printer
 *
 * @author maciej.jasinski2@gmail.com
 * @since 30.11.2019
 */
public abstract class TablePrinter<T> {

    protected final int[] columnsWidth;


    protected TablePrinter(int[] columnsWidth, int numberOfColumns) {
        requireNonNulls(columnsWidth);
        checkArgument(columnsWidth.length == numberOfColumns, "Columns array length is less than " + numberOfColumns);

        for (int column : columnsWidth) {
            checkArgument(column > 7, "Column width is less than 8");
        }
        this.columnsWidth = columnsWidth;
    }

    public String print(List<T> list) {
        StringBuilder builder = new StringBuilder();
        buildHeader(builder);
        buildRows(list, builder);
        return builder.toString();
    }

    protected abstract void buildHeader(StringBuilder builder);

    protected abstract void buildRows(List<T> list, StringBuilder builder);

    protected String field(String text, int width) {

        String trimmed = text == null ? "-" : text.trim();
        if (trimmed.length() > width) {
            return trimmed.substring(0, width - 3) + "...";
        }
        int availableSpace = width - trimmed.length();
        int left = availableSpace / 2;
        int right = availableSpace - left;
        return " ".repeat(left) + trimmed + " ".repeat(right);
    }

    protected int tableWidth() {
        int sum = 0;
        for (int width : columnsWidth) {
            sum += width;
        }
        return sum + columnsWidth.length;
    }
}
