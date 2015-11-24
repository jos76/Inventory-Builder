package com.savage.models;

/**
 * Class used to represent a Shelf.
 */
public class Shelf implements Comparable<Shelf> {
    public String row;
    public int capacity;
    public float visibility;

    /**
     * Returns -1 if this visibility is greater than that visibility, 1 if that visibility is greater than
     * this visibility, and 0 if they are equal.
     *
     * @param s the Shelf object to compare this object to.
     * @return -1 if this visibility is greater than that visibility, 1 if that visibility is greater than
     * this visibility, and 0 if they are equal.
     */
    public int compareTo(Shelf s) {
        if (this.visibility > s.visibility) {
            return -1;
        } else if (this.visibility < s.visibility) {
            return 1;
        } else {
            return 0;
        }
    }
}
