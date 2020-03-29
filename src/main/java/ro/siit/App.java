package ro.siit;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//        Scanner keyboard = new Scanner(System.in);
//
//       do{
//           System.out.println("Insert the number: ");
//
//       }

        Calculator calculator = new Calculator();
        String expresion = "10 cm + 1 m - 10 mm + 1 m - 0.9 dm";
        String[] splitExpresion = expresion.split(" ");
        for(String s : splitExpresion)
            System.out.println(s);
        double number,result=0.0;
        String formatA;
        char operand;
        System.out.println(splitExpresion.length );
        System.out.println(splitExpresion.length-5);
        result = Double.parseDouble(splitExpresion[0]);
        formatA = splitExpresion[1];
        result = calculator.convertToMeter(result,formatA);
        //System.out.println("nr= " + result);
        //System.out.println("Intermediate result is: " + result);
        System.out.print(result + " ");

        for(int i=2; i<splitExpresion.length-2; i = i+3){

            operand = splitExpresion[i].charAt(0);
            //System.out.println("op is: " + operand);
            System.out.print(operand + " ");

            number = Double.parseDouble(splitExpresion[i+1]);
            formatA = splitExpresion[i+2];
            number = calculator.convertToMeter(number,formatA);
            //System.out.println("nr= " + number);
            System.out.print(number + " = ");
            result = calculator.calculate(result,operand,number);
            //System.out.println("Intermediate result is: " + result);
            System.out.print(result + " ");
        }
        System.out.print("\n");
        System.out.println("Result is: " + result);
    }
}
