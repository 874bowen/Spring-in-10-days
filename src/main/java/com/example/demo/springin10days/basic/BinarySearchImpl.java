package com.example.demo.springin10days.basic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// @Component is used to tell Spring that this is a bean
// @Scope -> Since by default Spring uses the 'singleton' we are hardcoding our Container to use 'prototype' Scope @Scope("prototype")
// hardcoding this is not a good idea -> we'll then use the ConfigurableBeanFactory
@Component
//@Scope("prototype")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {
    //to make binarySearch use the algorithms dynamically
    // make this class use the interface instead of the implementation
    // to tell spring that this is a dependency use @Autowired

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Autowired
    @Qualifier("bubble")
    // this type of autowiring allows for only one type of algorithm not either just the bubbleSortAlgorithm
    // by using the name of the instance variable to solve the conflict when you have two matches when autoWiring
    // @Primary will always take precedence no matter what even if we are using AUTO-WIRING BY NAME bubbleSort as below
//    private SortAlgorithm bubbleSortAlgorithm;
    private SortAlgorithm sortAlgorithm;
    // constructor injection
//    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
//        this.sortAlgorithm = sortAlgorithm;
//    }
    // setter injection
//    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//        this.sortAlgorithm = sortAlgorithm;
//    }

    public int binarySearch(int[] numbers, int numberToSearchFor){
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        System.out.println(sortAlgorithm);
        // Sorting an array - Sorting Logic
        // Search an array - Bubble Sort Algorithm
        // Return an array
        return 3;
    }

    // let's say you need something which needs all the dependencies are populated
    // as soon as the bean is created the postConstruct method would be called
    @PostConstruct
    public void postConstruct(){
        LOGGER.info("PostConstruct");
    }
    // the PreDestroy annotation is used on methods as a callback notification to signal that
    // the instance is in the process of being removed by the container
    @PreDestroy
    public void preDestroy(){
        LOGGER.info("PreDestroy");
    }
}
