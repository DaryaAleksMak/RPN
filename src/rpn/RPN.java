/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author darya
 */
public class RPN {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int numberOfExpr = 0;

        while (true) {
            try {
                System.out.print("Input the number of expressions: ");
                sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Incorrect value! Enter Try again");
                sc.next();
            }
        }

        //TODO Create expresion witn check valid use pattern Builder
        Director director = new Director();
        ExpressionBuilder expressionBuilder = new ExpressionBuilder();
        director.setExpressionBuilder(expressionBuilder);

        for (int i = 1; i <= numberOfExpr; i++) {
            System.out.print("Enter expr №" + i + ":");
            try {
                director.constructExpression(sc.nextLine());
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException! Try again");
                i--;
            }
        }

        Expression.printListExpr();

    }
}
