package org.NAK.Citronix.Validation;

import org.NAK.Citronix.Entity.Field;
import org.NAK.Citronix.Entity.Tree;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class TreeValidator {

    private static final int TREES_PER_HECTARE = 100;

    public void validateTreeRequest(Tree tree) {
        if (!isValidPlantingSeason(tree.getPlaningDate())) {
            throw new IllegalArgumentException("Trees can only be planted between March and May.");
        }
    }

    public void validateFieldCapacity(Field field) {
        final double SQUARE_METERS_IN_HECTARE = 10000.0;
        double fieldAreaInHectares = field.getArea() / SQUARE_METERS_IN_HECTARE;
        int maxAllowedTrees = (int) (fieldAreaInHectares * TREES_PER_HECTARE);

        if (field.getTrees().size() >= maxAllowedTrees) {
            throw new IllegalArgumentException(
                    String.format("Field '%s' exceeds maximum tree density of %d trees  per hectare and this field can have just %d trees.",
                            field.getName(), TREES_PER_HECTARE ,maxAllowedTrees));
        }
    }

    private boolean isValidPlantingSeason(LocalDate plantingDate) {
        if (plantingDate == null) return false;
        Month month = plantingDate.getMonth();
        return month == Month.MARCH || month == Month.APRIL || month == Month.MAY;
    }
}