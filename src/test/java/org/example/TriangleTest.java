package org.example;

import lesson4.Triangle;
import lesson4.TriangleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {

    static Logger logger = LoggerFactory.getLogger(AppTest.class);

    @ParameterizedTest
    @CsvSource({ "2, 2, 2, 1.7320508075688772","5, 6, 7, 14.696938456699069"})
    void testValidMean(int a, int b, int c, double area) throws TriangleException {
        logger.info("Инфо");
        logger.error("ошибка");
        Triangle triangle = new Triangle();
        Assertions.assertEquals(area,Triangle.TriangleArea(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({ "10, 2, 3","100, 1, 300", "1, 3, 20"})
    void testBigValidMean (int a, int b, int c) throws TriangleException {
       Triangle triangle = new Triangle();
        TriangleException triangleException = Assertions.assertThrows(TriangleException.class, () -> Triangle.TriangleArea(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({ "-1, 2, 3","5, -6, 7", "3, 3, -3"})
    void testNegativeValidMean (int a, int b, int c) throws TriangleException {
        Triangle triangle = new Triangle();
        TriangleException triangleException = Assertions.assertThrows(TriangleException.class, () -> Triangle.TriangleArea(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({ "0, 2, 3","100, 0, 300", "1, 3, 0"})
    void testInvalidMean (int a, int b, int c) throws TriangleException {
        Triangle triangle = new Triangle();
        TriangleException triangleException = Assertions.assertThrows(TriangleException.class, () -> Triangle.TriangleArea(a, b, c));
    }
}
