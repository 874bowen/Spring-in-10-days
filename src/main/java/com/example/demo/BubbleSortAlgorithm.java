package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// When you have two classes with @component you can use @Primary to give more emphasis to a class
@Component
//@Primary
@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm{
    public int[] sort(int[] numbers){
        // Logic for Bubble Sort
        return numbers;
    }
}
