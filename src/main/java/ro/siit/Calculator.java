package ro.siit;

public class Calculator {

    public double convertToMeter(double value, String format) {
        double result = value ;
        switch (format) {
            case ("mm"): {
                result = value * 0.001;
                break;
            }
            case ("cm"): {
                result = value * 0.01;
                break;
            }
            case ("dm"): {
                result = value * 0.1;
                break;
            }
            case ("km"): {
                result = value * 100.0;
                break;
            }
        }
        return result;
    }

    public double calculate(double operator1, char operand, double operator2){
        double result = 0.0;
        switch (operand){
            case('+'): {
                result = operator1 + operator2;
                break;
            }
            case('-'): {
                result = operator1 - operator2;
                break;
            }
        }
        return result;
    }

    public double calculateFromSring(String expresion){
        String[] splitExpresion = expresion.split(" ");

        double number,result=0.0;
        String formatNumber;
        char operand;

        result = Double.parseDouble(splitExpresion[0]);
        formatNumber = splitExpresion[1];
        result = this.convertToMeter(result,formatNumber);

        for(int i=2; i<splitExpresion.length-2; i = i+3){
            operand = splitExpresion[i].charAt(0);
            number = Double.parseDouble(splitExpresion[i+1]);
            formatNumber = splitExpresion[i+2];
            number = this.convertToMeter(number,formatNumber);
            result = this.calculate(result,operand,number);
        }
        return result;
    }


    public double convertFromMeter(double value, String format) {
        double result = value;
        switch (format) {
            case ("mm"): {
                result = value * 1000;
                break;
            }
            case ("cm"): {
                result = value * 100;
                break;
            }
            case ("dm"): {
                result = value * 10;
                break;
            }
            case ("km"): {
                result = value * 0.001;
                break;
            }
        }
        return result;
    }
}
