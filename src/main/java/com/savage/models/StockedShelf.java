package com.savage.models;

import java.util.HashMap;

/**
 * Class used to represent a Stocked Shelf.
 */
public class StockedShelf extends Shelf {
    public int totalValue;
    public HashMap<String, Product> products;

    /**
     * Creates a StockedShelf from an existing Shelf object.
     *
     * @param shelf the Shelf object used to initialize this object.
     */
    public StockedShelf(Shelf shelf) {
        this.row = shelf.row;
        this.capacity = shelf.capacity;
        this.visibility = shelf.visibility;
        this.totalValue = 0;
        products = new HashMap<String, Product>();
    }

    /**
     * Adds any remaining products in the products list passed in to this shelf, starting with the most valuable
     * products in the list first.
     *
     * @param remainingProducts the list of remaining products to be added to shelves.
     */
    public StockedShelf stockShelf(Products remainingProducts) {
        for (Product p : remainingProducts.products) {
            Product currentProduct;
            // while there are more products left and I can fit them on this shelf
            while (p.qty > 0 && this.capacity >= p.size) {
                currentProduct = this.products.get(p.name);
                // if this is the first product of it's kind to be added to this shelf...
                if (currentProduct == null) {
                    currentProduct = new Product(p.name, p.size, p.value);
                    this.products.put(currentProduct.name, currentProduct);
                }
                // add each product to my shelf
                this.capacity -= p.size;
                p.qty--;
                currentProduct.qty++;
                this.totalValue += p.value;
            }
        }
        return this;
    }
}
