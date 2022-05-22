package com.example.demo.springin10days.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Primary
// If one of the candidate among the algorithms and the candidate is favorite in all the situations then use @Primary(Most efficient)
// If at some point we prefer a certain candidate to another then @Primary is not the most suitable way
// You can then use autowiring by name or by @Qualifier()
// Another option to be able to resolve multiple candidates available is by using @Qualifier("....")
@Qualifier("quick")
public class QuickSortAlgorithm implements SortAlgorithm {
    public int[] sort(int[] numbers){
        // Logic for Bubble Sort
        return numbers;
    }
}
