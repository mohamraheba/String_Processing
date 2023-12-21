package org.example;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
public class StringProcessorTest extends TestCase {
    @Test
    public void testIsStrongPassword() {
        StringProcessor string = new StringProcessor();
        assertFalse(string.isStrongPassword("raheba"));
        assertTrue(string.isStrongPassword("Raheba5!"));
        assertFalse(string.isStrongPassword("blue"));
        assertTrue(string.isStrongPassword("blue#7"));
        assertFalse(string.isStrongPassword("123"));

    }
    @Test
    public void testCalculateDigits() {
        StringProcessor string = new StringProcessor();
        assertEquals(2, string.calculateDigits("55"));
        assertEquals(5, string.calculateDigits("37577"));
        assertEquals(0, string.calculateDigits("blue"));
        assertEquals(3, string.calculateDigits("143"));
        assertEquals(4, string.calculateDigits("2023"));
    }
    @Test
    public void testCalculateWords() {
        StringProcessor string = new StringProcessor();
        assertEquals(0, string.calculateWords("125"));
        assertEquals(1, string.calculateWords("hello "));
        assertEquals(2, string.calculateWords("hello world "));
        assertEquals(3, string.calculateWords("hello world hello"));
        assertEquals(4, string.calculateWords("I am from Bishkek"));
    }
    @Test
    public void testCalculateExpression() {
        StringProcessor string = new StringProcessor();
        assertEquals(3.0, string.calculateExpression("2 + 1"));
        assertEquals(1.0, string.calculateExpression("6 - (2+ 3)"));
        assertEquals(100.0, string.calculateExpression("10 * (5 + 5)"));
        assertEquals(-5.0, string.calculateExpression("5 - 10"));
        assertEquals(5.0, string.calculateExpression("20 / 4"));
    }
}