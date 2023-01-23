package org.example.chapter2_search_problems;

import java.util.List;

/**
 * Linear and binary search using Generics.
 */
public class GenericSearch {
    /**
     * Linear search.
     *
     * @param list list of items
     * @param key  search key in list
     * @param <T>  any type
     * @return if find -> true, else -> false
     */
    public static <T extends Comparable<T>> boolean linearContains(
            final List<T> list, final T key) {
        for (T item : list) {
            if (item.compareTo(key) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Binary search.
     *
     * @param list list of items
     * @param key  search key in list
     * @param <T>  any type
     * @return if find -> true, else -> false
     */
    public static <T extends Comparable<T>> boolean binaryContains(
            final List<T> list, final T key) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) { // пока еще есть место для поиска
            int middle = (low + high) / 2;
            int comparison = list.get(middle).compareTo(key);
            if (comparison < 0) { // средний кодон меньше искомого
                low = middle + 1;
            } else if (comparison > 0) { // средний кодон больше искомого
                high = middle - 1;
            } else { // средний кодон равен искомому
                return true;
            }
        }
        return false;
    }
}
