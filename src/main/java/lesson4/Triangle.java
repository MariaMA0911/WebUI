package lesson4;

public class Triangle {
    public static double TriangleArea (int a, int b, int c) throws TriangleException {
        if(a <= 0 || b <= 0 || c <= 0 || (a + b < c) || (a + c < b) || (b + c < a)) throw new TriangleException("некорретные значения");
        double  pp = (a + b + c)/2;
        double area = Math.sqrt(pp * (pp - a)*(pp - b)*(pp - c));
        return area;
    }
}

