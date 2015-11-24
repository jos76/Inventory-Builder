package com.savage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.savage.models.Products;
import com.savage.models.Shelves;
import com.savage.models.StockedShelves;

import java.io.File;
import java.io.IOException;

/**
 * The {@code InventoryBuilder} class simply reads input from 2 files in JSON format and stocks shelves
 * for optimal inventory according to the products and shelves information listed in the files.
 */
public class InventoryBuilder {

    /**
     * Main entry point for this application. Reads information in from the files passed in on the command line.
     *
     * @param args command line arguments passed in to this program
     */
    public static void main(String args[]) {

        // default file names
        String shelvesFilename;
        String productsFilename;
        String outputFilename;

        try {
            if (args.length < 3) {
                System.out.println("Please specify the full path to the shelves file as the first argument, the " +
                        "full path to the products file as the second argument, and the full path to the file " +
                        "in which to save the output. \nPlease surround all path in quotes in case there are spaces " +
                        "in the file paths.");
                return;
            } else {
                shelvesFilename = args[0];
                productsFilename = args[1];
                outputFilename = args[2];
            }

            // read in the products and shelves files and parse to POJOs
            ObjectMapper mapper = new ObjectMapper();
            Products products = mapper.readValue(new File(productsFilename), Products.class);
            Shelves shelves = mapper.readValue(new File(shelvesFilename), Shelves.class);

            // create a new stocked shelves object and pass in the products and shelves objects
            StockedShelves stockedShelves = new StockedShelves(products, shelves);
            stockedShelves.stockShelves(); // stock those shelves!

            mapper.writeValue(new File(outputFilename), stockedShelves);
            System.out.println("Products successfully sorted to shelves!");

        } catch (IOException ioe) {
            // Yikes, something went wrong!
            System.err.println("An unexpected error occurred!");
            ioe.printStackTrace();
        }
    }
}