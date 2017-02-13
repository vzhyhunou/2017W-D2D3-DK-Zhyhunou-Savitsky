package org.jmp17.calc;

import org.jmp17.figure.BaseFigure;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by antonsavitsky on 2/11/17.
 */
public class CalculatorUtils {
    public static double calculate(List<BaseFigure> complexFigure){
        return complexFigure.stream()
                .map(figure -> figure.calcVolume())
                .collect(Collectors.summingDouble(d->d));
    }
}
