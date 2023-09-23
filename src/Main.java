import Factory.OperationsFactory;
import Models.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calc=new Calculator();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the string to be calculated");
        String equation=scanner.next();
        System.out.println("do you want to save it");
        boolean flag=scanner.nextBoolean();
        String name="";
        System.out.println(flag);
        if(flag){
            System.out.println("enter name to save");
            name=scanner.next();
        }
        System.out.println(calc.calculate(equation,name));
        System.out.println(calc.getOperations(name));
    }
}