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
public class ExpressionBuilder {

        protected Expression expression;

        public Expression getExpression() {
            return expression;
        }

        public void createNewExpression(String expr) {
            String whitspacelessExpr = trim(expr);
            expression = new Expression(whitspacelessExpr);
            isValide(expression);
        }

        private String trim(String expr) {
            return expr.replaceAll(" ", "");
        }

        private void isValide(Expression expression) {
            if (expression.getExprInfix().isEmpty()
                    || expression.getExprInfix().length() > 400) {
                throw new IllegalArgumentException();
            }
        }

    }
    
