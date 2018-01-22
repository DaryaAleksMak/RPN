/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author darya
 */
public class ConvectorRPN {
    private static final Map<Character, Integer>  PRIORITY_OPERATORS = new LinkedHashMap<>();
    static {
        PRIORITY_OPERATORS.put('+', 1);
        PRIORITY_OPERATORS.put('-', 1);
        PRIORITY_OPERATORS.put('*', 2);
        PRIORITY_OPERATORS.put('/', 3);
        PRIORITY_OPERATORS.put('^', 4);

    }

    private static final List<Character> BRACKETS = new ArrayList<>();
    static {
        BRACKETS.add('(');
        BRACKETS.add(')');
    }
    
    private Deque<Character> stackOperator = new ArrayDeque();
    private StringBuffer outputInRPN = new StringBuffer();
    
    private Expression exp; 
  
        
    public ConvectorRPN(Expression exp) {
        this.exp = exp;        
    }    
    
    
    public  String parser() {
        String inputExpression = exp.getExprInfix();
        char[] tokensExpression = inputExpression.toCharArray();        

        for (char token : tokensExpression) {
            if (isOperands(token)) {
                outputInRPN.append(token);
            }if (isBracket(token)) {
                char bracket = token;
                if (bracket == ')') {
                    while (!(stackOperator.peekLast()).equals('(')) {
                        moveToOutputStr();
                    }
                    stackOperator.removeLastOccurrence('(');
                } else if (bracket == '(') {
                    stackOperator.addLast(bracket);
                }
            }if (isOperator(token)) {
                char currentOperator = token;
                if (stackOperator.peekLast() == (Character)'(' || stackOperator.isEmpty()) {
                    stackOperator.add(currentOperator);
                } else {
                    int compare = comparePriorityOperators(currentOperator);
                    if (compare <= 0) {
                        moveToOutputStr();
                        stackOperator.add(currentOperator);
                    } else if (compare == 1) {
                        stackOperator.add(currentOperator);
                    }
                }
            }   
        }
        
        while (!stackOperator.isEmpty()){
            moveToOutputStr();
        }
        return outputInRPN.toString();
    }
    

    
    private int comparePriorityOperators(char CurrentOperator){
        return PRIORITY_OPERATORS.get(CurrentOperator).compareTo(PRIORITY_OPERATORS.get(stackOperator.peekLast()));
    }
    
    private void moveToOutputStr(){
        outputInRPN.append(stackOperator.getLast());
        stackOperator.removeLast();

    }
        
        
    public static boolean isBracket(char token) {
        return BRACKETS.contains(token);
    }

    public static boolean isOperator(char token) {
        return PRIORITY_OPERATORS.containsKey(token);
    }

    public static boolean isOperands(char token) {
        return Character.isAlphabetic(token);
    }
}
