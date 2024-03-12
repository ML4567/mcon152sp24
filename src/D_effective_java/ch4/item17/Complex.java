package D_effective_java.ch4.item17;

import java.util.Date;
import java.util.Objects;

/**
 * @author Josh Bloch
 * @author Moshe Lach
 */
public final class Complex {
    private final double realPart;
    private final double imaginaryPart;

    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE  = new Complex(1, 0);
    public static final Complex I    = new Complex(0, 1);

    private Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public static Complex of(double realPart, double imaginaryPart) {
        return new Complex(realPart, imaginaryPart);
    }

    public static Complex ofReal(double real) {
        return new Complex(real, 0);
    }

    public static Complex ofImaginary(double imaginary) {
        return new Complex(0, imaginary);
    }

    public double realPart()      { return realPart; }
    public double imaginaryPart() { return imaginaryPart; }

    public Complex plus(Complex c) {
        return new Complex(realPart + c.realPart, imaginaryPart + c.imaginaryPart);
    }

    // if this method would exist, the class would not be immutable
//    public void addInPlace(Complex other) {
//        this.realPart += other.realPart;
//        this.imaginaryPart += other.imaginaryPart;
//    }

    public Complex minus(Complex c) {
        return new Complex(realPart - c.realPart, imaginaryPart - c.imaginaryPart);
    }

    public Complex times(Complex c) {
        return new Complex(realPart * c.realPart - imaginaryPart * c.imaginaryPart,
                realPart * c.imaginaryPart + imaginaryPart * c.realPart);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.realPart * c.realPart + c.imaginaryPart * c.imaginaryPart;
        return new Complex((realPart * c.realPart + imaginaryPart * c.imaginaryPart) / tmp,
                (imaginaryPart * c.realPart - realPart * c.imaginaryPart) / tmp);
    }

    @Override public boolean equals(Object o) {
        if (o instanceof Complex) {
            Complex other = (Complex) o;
            // See page 47 to find out why we use compare instead of ==
            return Double.compare(other.realPart, realPart) == 0 && Double.compare(other.imaginaryPart, imaginaryPart) == 0;
        } else {
            return false;
        }
    }

    @Override public int hashCode() {
        return Objects.hash(realPart, imaginaryPart);
    }

    @Override public String toString() {
        return "(" + realPart + " + " + imaginaryPart + "i)";
    }
}

/*
class MaliciousSubclass extends Complex {
    private double myReal;

    public void setReal(double real) {
        this.myReal = real;
    }

    @Override
    public double realPart() {
        return myReal;
    }
}
 */

class DateInterval {
    private final Date start, end;

    public DateInterval(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}

class ComplexDemo {
    public static void main(String[] args) {
        Complex c1 = Complex.of(1, 2);
        Complex c2 = Complex.of(3, 4);

        Complex product = c1.times(c2);
        System.out.println(product);

        Complex c3 = Complex.I;

        final StringBuilder sb = new StringBuilder("a");
        sb.append("b");
        System.out.println(sb);

        Complex c4 = Complex.I;
    }
}