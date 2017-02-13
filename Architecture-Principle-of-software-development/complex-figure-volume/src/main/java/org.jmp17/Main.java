package org.jmp17;

import org.jmp17.calc.CalculatorUtils;
import org.jmp17.figure.BaseFigure;
import org.jmp17.figure.Cone;
import org.jmp17.figure.Cylinder;
import org.jmp17.figure.Parallelepiped;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonsavitsky on 2/11/17.
 */
public class Main {

    public static void main(String[] args) {
        Cone cone = new Cone(2, 5);
        Cylinder cylinder = new Cylinder(5, 10);
        Parallelepiped parallelepiped = new Parallelepiped(4, 3, 8);

        List<BaseFigure> complexFigure = new ArrayList<>();
        complexFigure.add(cone);
        complexFigure.add(cylinder);
        complexFigure.add(parallelepiped);

        System.out.println( CalculatorUtils.calculate(complexFigure));
    }
}
