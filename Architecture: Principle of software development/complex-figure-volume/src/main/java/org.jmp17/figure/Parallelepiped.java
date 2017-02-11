package org.jmp17.figure;

/**
 * Created by antonsavitsky on 2/11/17.
 */
public class Parallelepiped extends BaseFigure {
    private double a;
    private double b;
    private double c;

    public Parallelepiped(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calcVolume() {
        return a*b*c;
    }
}
