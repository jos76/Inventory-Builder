package com.savage.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class used to represent Stocked Shelves.
 */
public class StockedShelves {
    public List<StockedShelf> stockedShelves;
    private Products products;
    private Shelves shelves;

    /**
     * Default constructor.
     *
     * @param products the products to be stocked on the shelves.
     * @param shelves  the shelves on which to stock the products.
     */
    public StockedShelves(Products products, Shelves shelves) {
        this.products = products;
        this.shelves = shelves;
        stockedShelves = new ArrayList<StockedShelf>();
    }

    /**
     * This method checks to make sure the products and shelves lists contain data and then sorts both lists and stocks
     * the products on the shelves such that the most valuable products are added to the most visible shelves.
     *
     * @throws IllegalArgumentException if the products list or shelves list are empty.
     */
    public void stockShelves() {
        if (products.products.size() > 0 && shelves.shelves.size() > 0) {
            // sort the products list so that the first product in the list has the highest "adjusted value"
            Collections.sort(products.products);
            // sort the shelves list so that the first shelf in the list has the highest visibility
            Collections.sort(shelves.shelves);

            // stock those shelves!
            for (Shelf shelf : shelves.shelves) {
                stockedShelves.add(new StockedShelf(shelf).stockShelf(products));
            }
        } else {
            throw new IllegalArgumentException("Products or Shelves lists are empty!");
        }
    }
}
