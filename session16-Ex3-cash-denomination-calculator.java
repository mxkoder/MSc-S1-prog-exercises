package org.example;

import java.util.Scanner;
import java.util.*;

public class Main {
    private static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {
        //Session 16 Ex 16.3
        //Cash denomination calculator
        //Takes value in GBP and returns the way to represent it with the smallest quantity of standard notes & coins

        double valueGBP = 47.65;

        CashDenominationCalculatorPrint(valueGBP);

    }

    public static void CashDenominationCalculatorPrint(double valueGBP) {
        double valueInPenceDouble = valueGBP * 100;

        int valueInPenceInt = (int) valueInPenceDouble;

        // array of denominations is in descending order so that we can check for the largest denominations first
        int notesAndCoinsArray[] = {5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        int remainder = 0;
        int multiplier = 0;

        for (int i = 0; i < notesAndCoinsArray.length; i++) {

            remainder = valueInPenceInt % notesAndCoinsArray[i];

            // checks how many of the denomination can be used to represent the value
            multiplier = (valueInPenceInt - remainder) / notesAndCoinsArray[i];

            if (multiplier != 0)
            {
                if (notesAndCoinsArray[i] >= 100)
                {
                    System.out.printf("£%d: %d\n", (notesAndCoinsArray[i] / 100), multiplier);
                }
                else
                {
                    System.out.printf("%dp: %d\n", notesAndCoinsArray[i], multiplier);
                }
            }

            // the leftover value to assign to denominations is calculated before moving on to the next denomination
            valueInPenceInt = valueInPenceInt - (multiplier * notesAndCoinsArray[i]);

        }
    }
}
