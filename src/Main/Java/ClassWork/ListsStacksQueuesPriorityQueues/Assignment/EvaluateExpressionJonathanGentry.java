/*
  Jonathan Gentry
  COSC 2336-48F
  Instructor: Dr. Doerschuk
  Programming Assignment 3
  Due: 9/15/2020
  Submitted: 9/15/2020
  Programming language: Java JDK 14
  This is a program prompt the user to enter an expression and then to evaluate and return the results.
 */

package Main.Java.ClassWork.ListsStacksQueuesPriorityQueues.Assignment;

import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpressionJonathanGentry {

    /**
     Class name: main
     Jonathan Gentry
     External packages: java.util.Scanner
     Package: ain.Java.ClassWork.ListsStacksQueuesPriorityQueues.Assignment
     Main method is used to create a scanner and ask the user for an expression, then to test the evaluateExpression() method.
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the expression to be evaluated: ");

        String askExpression = scan.nextLine();

        System.out.println(askExpression + " = " + evaluateExpression(askExpression));
    }

    /**
     Method name: gdc
     Purpose: Evaluate an expression
     Pre Conditions: String
     Post Condition: One int
     Return condition: The processed operands and operators
     Parameters: expression
     The method takes a string and breaks it down to check for operands and operators to add to their respective stacks,
     then it will evaluate the expression.
     */
    public static int evaluateExpression(String expression) {
        // Create operandStack to store operands
        Stack<Integer> operandStack = new Stack<>();

        // Create operatorStack to store operators
        Stack<Character> operatorStack = new Stack<>();

        // Insert blanks around (, ), +, -, /, and *
        expression = insertBlanks(expression);

        // Extract operands and operators
        String[] tokens = expression.split(" ");

        // Phase 1: Scan tokens
        for (String token: tokens) {
            if (token.length() == 0) // Blank space
                continue; // Back to the for loop to extract the next token
            else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                // Process all +, -, *, / in the top of the operator stack
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' ||
                                operatorStack.peek() == '-' ||
                                operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/' ||
                                operatorStack.peek() == '%' ||
                                operatorStack.peek() == '^')) {
                    processAnOperator(operandStack, operatorStack);
                }

                // Push the + or - operator into the operator stack
                operatorStack.push(token.charAt(0));
            }
            else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%') {
                // Process all *, / in the top of the operator stack
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/' ||
                                operatorStack.peek() == '%' ||
                                operatorStack.peek() == '^')) {
                    processAnOperator(operandStack, operatorStack);
                }

                // Push the * or / operator into the operator stack
                operatorStack.push(token.charAt(0));
            }
            else if (token.charAt(0) == '^') {
                // Process all ^ in the top of the operator stack
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '^')) {
                    processAnOperator(operandStack, operatorStack);
                }

                // Push the * or / operator into the operator stack
                operatorStack.push(token.charAt(0));
            }
            else if (token.trim().charAt(0) == '(') {
                operatorStack.push('('); // Push '(' to stack
            }
            else if (token.trim().charAt(0) == ')') {
                // Process all the operators in the stack until seeing '('
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }

                operatorStack.pop(); // Pop the '(' symbol from the stack
            }
            else { // An operand scanned
                // Push an operand to the stack
                operandStack.push(Integer.valueOf(token));
            }
        }

        // Phase 2: process all the remaining operators in the stack
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }

        // Return the result
        return operandStack.pop();
    }

    /** Process one operator: Take an operator from operatorStack and
     *  apply it on the operands in the operandStack */
    public static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();

        if (op == '+')
            operandStack.push(op2 + op1);
        else if (op == '-')
            operandStack.push(op2 - op1);
        else if (op == '*')
            operandStack.push(op2 * op1);
        else if (op == '/')
            operandStack.push(op2 / op1);
        else if (op == '%')
            operandStack.push(op2 % op1);
        else if (op == '^')
            operandStack.push((int)Math.pow(op2, op1));
    }

    public static String insertBlanks(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                    s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    s.charAt(i) == '*' || s.charAt(i) == '/' ||
                    s.charAt(i) == '%' || s.charAt(i) == '^')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }

        return result;
    }
}

