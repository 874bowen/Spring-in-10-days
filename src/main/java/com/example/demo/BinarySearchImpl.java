package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
// @Component is used to tell Spring that this is a bean
@Component
public class BinarySearchImpl {
    //to make binarySearch use the algorithms dynamically
    // make this class use the interface instead of the implementation
    // to tell spring that this is a dependency use @Autowired
    @Autowired
    private SortAlgorithm sortAlgorithm;
    // constructor injection
//    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
//        this.sortAlgorithm = sortAlgorithm;
//    }


    // setter injection
    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int binarySearch(int[] numbers, int numberToSearchFor){
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        System.out.println(sortAlgorithm);
        // Sorting an array - Sorting Logic
        // Search an array - Bubble Sort Algorithm
        // Return an array
        return 3;
    }
}
