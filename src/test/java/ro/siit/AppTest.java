package ro.siit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test1()
    {
         Calculator calculator = new Calculator();
//         Scanner keyboard = new Scanner(System.in);
//         System.out.println("Insert the number: ");
//         double nr = keyboard.nextInt();
         double a = calculator.convertToMeter(10, "cm");
         double b = calculator.convertToMeter(1, "m");
         double result = calculator.calculate(a, '+', b);
         double c =  calculator.convertToMeter(10,"mm");
         result = calculator.calculate(result, '-',c);
         result = calculator.convertFromMeter(result, "mm");
         assertEquals(calculator.convertFromMeter(a+b-c,"mm"),result,0);

    }
}
