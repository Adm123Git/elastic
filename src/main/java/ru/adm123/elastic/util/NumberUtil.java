package ru.adm123.elastic.util;

/**
 * @author Dmitry Ushakov at 14.01.2022
 */
public abstract class NumberUtil {

    public static int getRandomInt(int min,
                             int max) {
        return Math.round((max - min) * (float) Math.random()) + min;
    }

}
