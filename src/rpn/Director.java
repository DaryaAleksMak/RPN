/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn;

/**
 *
 * @author darya
 */
public class Director {
    private ExpressionBuilder expressionBuilder;

    public void setExpressionBuilder(ExpressionBuilder expressionBuilder) {
        this.expressionBuilder = expressionBuilder;
    }
    
    public Expression getExpression(){
        return expressionBuilder.getExpression();
        }
    public void constructExpression(String expr){
        expressionBuilder.createNewExpression(expr);    
    }
    
}
