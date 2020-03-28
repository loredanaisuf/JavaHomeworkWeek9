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
