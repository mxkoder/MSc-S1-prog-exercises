package org.example;

import java.util.Scanner;
import java.util.*;

public class Main
{
    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args)
    {
        //Session 16 Ex 16.2
        //find the sum of distinct number pairs in a group of integers

        int numbersArray[] = {100, 4, 2, 8, 30, 10, 11, 31, 30, 30, 30, 4};
        PrintNumbersArray(numbersArray);

        SortNumbersInAscendingOrder(numbersArray);

        System.out.printf("after sort :\n");
        PrintNumbersArray(numbersArray);

        int sumOfDistinctPairs = SumAllDistinctNumberPairs(numbersArray);


        System.out.printf("The sum of distinct pairs in the group of integers is %d:\n", sumOfDistinctPairs);
    }

    public static void PrintNumbersArray(int[] numbers)
    {
        for(int num: numbers)
        {
            System.out.printf(num + " ");
        }

        System.out.printf("\n");
    }

    /**
     * Sorts an array of integer numbers into an ascending ordered array of integers
     * @param numbers an array of integer numbers
     */
    public static void SortNumbersInAscendingOrder(int[] numbers)
    {
        Arrays.sort(numbers);
    }

    /**
     * Sums each number in an array of integer that has a distinct number pair in the array
     * For example {1, 2, 4, 5, 5} would have a result of 5, and {1, 1, 2, 4, 5, 5, 5} would have a result
     * of 6.
     * @param numbers an array of integers sorted in ascending order
     * @return an integer sum of the distinct pairs in the input array
     */
    public static int SumAllDistinctNumberPairs (int[] numbers)
    {
        //need to add error handling / exception if array is not sorted

        int NoOfRepeatsOfNumber = 1;
        int NoOfPairsOfNumber;
        int sumOfDistinctPairs = 0;

        for(int i = 0; i < (numbers.length - 1); i++)
        {
            // increase the number of repeats if value at index i is the same as the value at the next index i + 1
            if(numbers[i] == numbers[i + 1])
            {
                NoOfRepeatsOfNumber += 1;
            }

            /* adding up the distinct pairs when we get to the end of a series of identical numbers
            or reach the end of the array*/
            if(numbers[i] != numbers[i + 1] || i == (numbers.length - 2))
            {
                //need to add the distinct number pairs to the sum
                NoOfPairsOfNumber = NoOfRepeatsOfNumber / 2;
                sumOfDistinctPairs += (NoOfPairsOfNumber * numbers[i]);

                // reset NoOfRepeatsOfNumber to 1 when move on to the next distinct number
                NoOfRepeatsOfNumber = 1;
            }
        }

        return sumOfDistinctPairs;

    }
}
