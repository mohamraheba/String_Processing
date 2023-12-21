package org.example;
import java.util.Stack;

public class StringProcessor
{
    public boolean isStrongPassword(String password)
    {
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isDigit = false;
        boolean isSpecialSymbol = false;
        for(int i = 0; i < password.length(); i++)
        {
            char character = password.charAt(i);
            if(character >= 65 && character <= 90)
            {
                isUpperCase = true;
            }
            if(character >= 97 && character <= 122)
            {
                isLowerCase = true;
            }
            if(character >= 48 && character <= 57)
            {
                isDigit = true;
            }
            if(character >= 33 && character <= 47 || character >= 58 && character <=64)
            {
                isSpecialSymbol = true;
            }
        }
        return isUpperCase && isLowerCase && isDigit && isSpecialSymbol;
    }

    public int calculateDigits(String sentence)
    {
        int digitCounter = 0;
        for(int i = 0; i < sentence.length(); i++)
        {
            char character = sentence.charAt(i);
            if(character >= 48 && character <= 57)
            {
                digitCounter++;
            }
        }
        return digitCounter;
    }

    public int calculateWords(String sentence) {
        int wordCounter = 0;
        boolean inWord = false;

        for (int i = 0; i < sentence.length(); i++) {
            char character = sentence.charAt(i);

            if (Character.isWhitespace(character)) {

                inWord = false;
            } else {

                if (!inWord) {
                    wordCounter++;
                    inWord = true;
                }
            }
        }
        return wordCounter;
    }


    public double calculateExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (Character.isDigit(character)) {

                char[] numArray = new char[expression.length()];
                int numIndex = 0;
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numArray[numIndex++] = expression.charAt(i);
                    i++;
                }
                i--;


                String numString = new String(numArray, 0, numIndex);
                double numValue = Double.parseDouble(numString);
                numbers.push(numValue);
            } else if (character == '+' || character == '-' || character == '*' || character == '/') {

                operators.push(character);
            } else if (character == '(') {

                operators.push(character);
            } else if (character == ')') {

                while (!operators.isEmpty() && operators.peek() != '(') {
                    evaluateExpression(numbers, operators);
                }
                operators.pop();
            }
        }


        while (!operators.isEmpty()) {
            evaluateExpression(numbers, operators);
        }


        return numbers.pop();
    }

    private void evaluateExpression(Stack<Double> numbers, Stack<Character> operators) {
        char operator = operators.pop();
        double operand2 = numbers.pop();
        double operand1 = numbers.pop();

        switch (operator) {
            case '+':
                numbers.push(operand1 + operand2);
                break;
            case '-':
                numbers.push(operand1 - operand2);
                break;
            case '*':
                numbers.push(operand1 * operand2);
                break;
            case '/':
                numbers.push(operand1 / operand2);
                break;
        }
    }
}