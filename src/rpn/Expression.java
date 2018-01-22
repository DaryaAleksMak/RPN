/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Expression {
    
    public static Set<Expression> listExpressions = new LinkedHashSet<>(); 

    private String exprInfix;
    private String expressionRPN;
    

    public Expression(String expr) {
        this.exprInfix = expr;
        listExpressions.add(this);
    }

    public String getExprInfix() {
        return exprInfix;
    }

    public void setExprInfix(String exprInfix) {
        this.exprInfix = exprInfix;
    }

    public String getExpressionRPN() {
        return expressionRPN;
    }
    
    public static void printListExpr(){
        for(Expression expr: Expression.listExpressions){
            String outputInRPN = new ConvectorRPN(expr).parser();
            System.out.println(outputInRPN);
        }
        
    }
    
    
    
    
    
    
    
    

    
}
