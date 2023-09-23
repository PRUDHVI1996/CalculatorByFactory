package Models;

import Factory.OperationsFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Pair{
    String text;
    int value;
    public Pair(String text,int value){
        this.text=text;
        this.value=value;
    }
}
public class Calculator {
    public HashMap<String,Pair> operations=null;
    public Calculator(){
        operations=new HashMap<String,Pair>();
    }
    public void setOperations(String name,Pair p){
        this.operations.put(name,p);
    }
    public String getOperations(String temp){
        return this.operations.get(temp).text;
    }
    public int helper(String first,int index,String str,int output){
        if(str.length()==0){
            return output;
        }else{
            char operation=str.charAt(index);
            index+=1;
            StringBuilder sb2=new StringBuilder("");
            while(index<str.length() && (str.charAt(index)>='0' && str.charAt(index)<='9')){
                sb2.append(str.charAt(index));
                index++;
            }
            Operations op= OperationsFactory.returnOperation(operation);
            int val=op.calculate(Integer.parseInt(first),Integer.parseInt(sb2.toString()));
            return helper(val+"",0,str.substring(index),val);
        }
    }
    public int calculate(String str,String name){
        String temp=str;
        StringBuilder sb1=new StringBuilder("");
        int index =0;
        while(index<str.length() && (str.charAt(index)>='0' && str.charAt(index)<='9')){
            sb1.append(str.charAt(index));
            index++;
        }
        int valueReq=helper(sb1.toString(),0,str.substring(index),0);
         if(name.length()!=0){
             setOperations(name,new Pair(temp,valueReq));
         }
         return valueReq;
    }
}
