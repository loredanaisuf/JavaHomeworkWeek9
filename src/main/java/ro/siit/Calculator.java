package ro.siit;


public class Calculator {

    public double convertToMeter(double value, String format) throws IllegalArgumentException {
        double result;//= value ;
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
            case ("m"): {
                result = value;
                break;
            }
            case ("km"): {
                result = value * 1000.0;
                break;
            }
            default: throw new IllegalArgumentException("The measure have to be mm,cm,dm,m,km ");
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
        try{
            this.validateString(expresion);
        }catch (IllegalArgumentException iae){
            System.out.println("The string is not valid!");
        }
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

    public void validateString(String expresion) throws IllegalArgumentException{
        String[] splitExpresion = expresion.split(" ");
        if(splitExpresion.length<5){
            System.out.println("Number of parameter is too less!");
            throw new IllegalArgumentException("Number of parameter is too less!");
        }

        int i = 0;
        try{
            Double.parseDouble(splitExpresion[i]);
        } catch (Exception e){
            System.out.println("This parameter have to be number!");
            throw new IllegalArgumentException("This parameter:  " + splitExpresion[i] + "have to be number!");
        }
        i++;
        String measure = splitExpresion[i];
        if(!(measure.equals("mm") ||measure.equals("cm") || measure.equals("dm") || measure.equals("m") || measure.equals("km") )){
            System.out.println("This parameter have to be mm, cm, dm, m or km!");
            throw new IllegalArgumentException("This parameter: " + measure + "have to be mm, cm, dm, m or km!");
        }
        i++;
        while(i<splitExpresion.length-3){
            if(!(splitExpresion[i].equals("+") || splitExpresion[i].equals("-"))){
                System.out.println("This parameter: " + splitExpresion[i] + " have to be + or -!");
                throw new IllegalArgumentException("This parameter have to + or -!");
            }
            i++;
            try{
                Double.parseDouble(splitExpresion[i]);
            } catch (Exception e){
                System.out.println("This parameter: " + splitExpresion[i] + "  have to be number!");
                throw new IllegalArgumentException("This parameter have to be number!");
            }
            i++;
            measure = splitExpresion[i];
            if(!(measure.equals("mm") ||measure.equals("cm") || measure.equals("dm") || measure.equals("m") || measure.equals("km") )){
                System.out.println("This parameter: " + splitExpresion[i] + "  have to be mm, cm, dm, m or km!");
                throw new IllegalArgumentException("This parameter have to be mm, cm, dm, m or km!");
            }
            i++;
        }
    }

    public double convertFromMeter(double value, String format) throws IllegalArgumentException{
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
            case ("m"): {
                result = value;
                break;
            }
            case ("km"): {
                result = value * 0.001;
                break;
            }
            default: throw new IllegalArgumentException("The measure have to be mm,cm,dm,m,km ");
        }
        return result;
    }
}
