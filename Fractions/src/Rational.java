import java.util.Scanner;

public class Rational {

    public static final String DELIMITER = "/";
    public static final long PRECISION = 100000000L;

    private long numerator;
    private long denominator;

    /**
     * Constructors
     */
    public Rational() {
        numerator = 0;
        denominator = 1;
    }

    /**
     * GDC calculates the greatest common devisor
     *
     * @param a (positive value)
     * @param b (positive value)
     * @return greatest common devisor
     */
    private static long gdc(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a < b) {
            return gdc(b, a);
        }
        if (b == 0) {
            return a;
        }
        long c = 1;
        while (c != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    private void norm() {
        long gdc = gdc(numerator, denominator);
        numerator /= gdc;
        denominator /= gdc;

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }


    /**
     * Creates the fraction with numerator 'num' and denominator 'den'
     *
     * @param num numerator
     * @param den denominator
     */
    public Rational(long num, long den) {
        numerator = num;
        denominator = den;
        norm();
    }

    /**
     * Creates whole fraction 'val/1'
     *
     * @param val
     */
    public Rational(long val) {
        this(val, 1);
    }

    /**
     * Same as above but with double-values rather than long values
     *
     * @param val
     */
    public Rational(double val) {
        this((long) (val * PRECISION), PRECISION);
    }

    /**
     * Same as above but with String rather than double values 'x/y'
     *
     * @param val String
     */
    public Rational(String val) {
        //useDelimiter() separates two values. Separator is given in the parameter (DELIMITER)
        Scanner scanner = new Scanner(val).useDelimiter(DELIMITER);
        numerator = scanner.nextLong();
        denominator = scanner.nextLong();
        norm();
    }


    // get-methods
    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    /**
     * Divides numerator/denominator
     *
     * @return value in double
     */
    public double doubleValue() {
        return ((double) numerator / denominator);

    }

    /**
     * Values of the numerator and denominator are returned as a String
     *
     * @return String "a/b"
     */
    public String toString() {
        return numerator + DELIMITER + denominator;
    }

    /**
     * Negates the values. Equal result would be achieved by multiplying value with -1
     *
     * @return negation of fraction
     */
    public Rational negate() {
        return new Rational(-numerator, denominator);
    } // Multiplikation mit -1

    /**
     * Inverting fraction by switching numerator with denominator
     *
     * @return new fraction (inverted)
     */
    public Rational invert() {
        return new Rational(denominator, numerator);
    }

    // calculation

    /**
     * Adding two fractions.
     *
     * @param val new fraction
     * @return sum of the two fractions
     */
    public Rational add(Rational val) {
        return new Rational(
                this.numerator * val.denominator +
                        val.numerator * this.denominator,
                this.denominator * val.denominator);
    }

    /**
     * Subtracting two fractions.
     *
     * @param val new fraction
     * @return sum of the two fractions
     */
    public Rational subtract(Rational val) {
        return add(val.negate());
    }

    /**
     * Multiplication of two fractions
     *
     * @param val new fraction
     * @return result of multiplicated fractions
     */
    public Rational multiply(Rational val) {
        return new Rational(
                this.numerator * val.numerator,
                this.denominator * val.denominator);
    }

    /**
     * Division of two fractions
     *
     * @param val faction to be divised with
     * @return new fraction
     */
    public Rational divide(Rational val) {
        return multiply(val.invert());
    }
}

