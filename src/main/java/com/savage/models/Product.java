package com.savage.models;

/**
 * Class used to represent a Product.
 */
public class Product implements Comparable<Product> {

    public String name;
    public int size;
    public int value;
    public int qty;

    public float getAdjustedValue() {
        return (float) this.value / (float) this.size;
    }

    /** Default constructor **/
    public Product() {
        // needed for jackson object mapper
    }

    /**
     * Creates a Product object initialized to the information passed in.
     *
     * @param name  the name of the product
     * @param size  the size of the product
     * @param value the value of the product
     */
    public Product(String name, int size, int value) {
        this.name = name;
        this.size = size;
        this.value = value;
        this.qty = 0;
    }

    /**
     * Returns -1 if this adjustedValue is greater than that adjustedValue, 1 if that adjustedValue is greater than
     * this adjustedValue, and 0 if they are equal.
     *
     * @param p the Product object to compare this object to.
     * @return -1 if this adjustedValue is greater than that adjustedValue, 1 if that adjustedValue is greater than
     * this adjustedValue, and 0 if they are equal.
     */
    public int compareTo(Product p) {
        if (this.getAdjustedValue() > p.getAdjustedValue()) {
            return -1;
        } else if (this.getAdjustedValue() < p.getAdjustedValue()) {
            return 1;
        } else {
            return 0;
        }
    }
}
