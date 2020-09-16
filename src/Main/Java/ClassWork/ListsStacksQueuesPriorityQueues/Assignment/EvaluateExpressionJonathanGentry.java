/*
  Jonathan Gentry
  COSC 2336-48F
  Instructor: Dr. Doerschuk
  Programming Assignment 3
  Due: 9/16/2020
  Submitted: 9/16/2020
  Programming language: Java JDK 14
  This is a program prompt the user to enter an expression and then to evaluate and return the results while using stacks.
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
        // Create a scanner object to hold console input
        Scanner scan = new Scanner(System.in);

        // Prompt user to input an expression and store it in String variable askExpression
        System.out.println("Enter the expression to be evaluated: ");
        String askExpression = scan.nextLine();

        // Try block to catch if a wrong expression was entered
        try {
            // Send to console the user's expression and the evaluated results
            System.out.println(askExpression + " = " + evaluateExpression(askExpression));
        } catch (Exception ex) {
            System.out.println("Wrong expression: " + askExpression);
        }
    }

    /**
     Method name: evaluateExpression
     Purpose: Evaluate an expression
     Pre Conditions: Expression
     Post Condition: Computed Expression
     Return condition: The last Integer in operandStack after evaluation.
     Parameters: String
     The method takes a string and breaks it down to check for operands and operators to add to their respective stacks,
     then it will evaluate the expression and return the value.
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

    /**
     Method name: processAnOperator
     Purpose: To process one operator
     Pre Conditions: operandStack and operatorStack
     Post Condition: Push evaluated Integer to operandStack
     Return condition: void
     Parameters: Stack<Integer> and Stack<Character>
     The method takes an operator from operatorStack and applies it on the operands in the operandStack, then return
     results to the operandStack.
     */
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

    /**
     Method name: insertBlanks
     Purpose: Insert blank character around the expression operators
     Pre Conditions: String s
     Post Condition: String result
     Return condition: result
     Parameters: Stack<Integer> and Stack<Character>
     The method takes a string and inserts " " around operators.
     */
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

