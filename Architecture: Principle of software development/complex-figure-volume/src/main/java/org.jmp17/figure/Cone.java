package org.jmp17.figure;

/**
 * Created by antonsavitsky on 2/11/17.
 */
public class Cone extends BaseFigure {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double calcVolume() {
        return Math.PI * Math.sqrt(radius) * height/3;
    }
}
