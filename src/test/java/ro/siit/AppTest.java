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

         assertEquals(a+b,result,0);

    }

    @Test
    public void test2()
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
        assertEquals(a+b-c,result,0);
    }

    @Test
    public void test3()
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

    @Test
    public void test4()
    {
        Calculator calculator = new Calculator();
//         Scanner keyboard = new Scanner(System.in);
//         System.out.println("Insert the number: ");
//         double nr = keyboard.nextInt();
        double a = calculator.convertToMeter(10, "cm");
        double b = calculator.convertToMeter(1, "m");
        double c =  calculator.convertToMeter(10,"dm");
        double d =  calculator.convertToMeter(0.2,"km");

        double result = calculator.calculate(a, '+', b);
        result = calculator.calculate(result, '-',c);
        result = calculator.calculate(result, '-',d);

        result = calculator.convertFromMeter(result, "km");
        assertEquals(calculator.convertFromMeter(a+b-c-d,"km"),result,0);
    }

    @Test
    public void test5()
    {
        Calculator calculator = new Calculator();
//         Scanner keyboard = new Scanner(System.in);
//         System.out.println("Insert the number: ");
//         double nr = keyboard.nextInt();
        double a = calculator.convertToMeter(10, "cm");
        double b = calculator.convertToMeter(1, "m");
        double c =  calculator.convertToMeter(10,"dm");
        double d =  calculator.convertToMeter(0.2,"km");

        double result = calculator.calculate(a, '+', b);
        result = calculator.calculate(result, '-',c);
        result = calculator.calculate(result, '-',d);

        result = calculator.convertFromMeter(result, "km");
        assertEquals(calculator.convertFromMeter(a+b-c-d,"km"),result,0);

    }

    @Test
    public void test6()
    {
        Calculator calculator = new Calculator();
        String expresion = "10 cm + 1 m - 10 mm + 1 km - 0.9 dm";
        double expected = calculator.convertToMeter(10, "cm") + 1 - calculator.convertToMeter(10, "mm") + calculator.convertToMeter(1, "km") - calculator.convertToMeter(0.9, "dm");
        String[] splitExpresion = expresion.split(" ");
        for(String s : splitExpresion)
            System.out.println(s);
        double number,result=0.0;
        String formatNumber;
        char operand;
        System.out.println(splitExpresion.length );
        System.out.println(splitExpresion.length-5);
        result = Double.parseDouble(splitExpresion[0]);
        formatNumber = splitExpresion[1];
        result = calculator.convertToMeter(result,formatNumber);

        for(int i=2; i<splitExpresion.length-2; i = i+3){
            operand = splitExpresion[i].charAt(0);
            number = Double.parseDouble(splitExpresion[i+1]);
            formatNumber = splitExpresion[i+2];
            number = calculator.convertToMeter(number,formatNumber);
            result = calculator.calculate(result,operand,number);
        }

        assertEquals(expected,result,0);
    }

    @Test
    public void test7()
    {
        Calculator calculator = new Calculator();
        String expresion = "10 cm + 1 m - 10 mm + 1 km - 0.9 dm";
        double expected = calculator.convertToMeter(10, "cm") + 1 - calculator.convertToMeter(10, "mm") + calculator.convertToMeter(1, "km") - calculator.convertToMeter(0.9, "dm");
        String[] splitExpresion = expresion.split(" ");
//        for(String s : splitExpresion)
//            System.out.println(s);
        double number,result=0.0;
        String formatNumber;
        char operand;

        result = Double.parseDouble(splitExpresion[0]);
        formatNumber = splitExpresion[1];
        result = calculator.convertToMeter(result,formatNumber);

        for(int i=2; i<splitExpresion.length-2; i = i+3){
            operand = splitExpresion[i].charAt(0);
            number = Double.parseDouble(splitExpresion[i+1]);
            formatNumber = splitExpresion[i+2];
            number = calculator.convertToMeter(number,formatNumber);
            result = calculator.calculate(result,operand,number);
        }

        result = calculator.convertFromMeter(result, "dm");
        assertEquals(calculator.convertFromMeter(expected, "dm"),result,0);
    }
}
