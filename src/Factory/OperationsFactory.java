package Factory;

import Models.*;

public class OperationsFactory {
    public static Operations returnOperation(char op){
        if(op=='+'){
            return new Addition();
        }else if(op=='-'){
            return new Substraction();
        }else if(op=='/'){
            return new Division();
        }else if(op=='*'){
            return new Multiplication();
        }else{
            return null;
        }
    }
}
