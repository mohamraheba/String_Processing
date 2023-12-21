package org.example;

public class Main {
    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor();
        String password = "Raheba5!";
        System.out.println(processor.isStrongPassword(password));
        String sentence = "Today is December 16, 2023.";
        System.out.println(processor.calculateDigits(sentence));
        String sentence2 = "Hello, World";
        System.out.println(processor.calculateWords(sentence2));
        String expression = "1 + 2 * (5 - 4)";
        System.out.println(processor.calculateExpression(expression));
    }
}