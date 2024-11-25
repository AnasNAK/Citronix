package org.NAK.Citronix.Validation;

import org.NAK.Citronix.Entity.Field;
import org.NAK.Citronix.Entity.Farm;
import org.springframework.stereotype.Component;

@Component
public class FieldValidation {

    private static final double MINIMUM_FIELD_AREA = 1000.0;
    private static final double MAXIMUM_FIELD_PERCENTAGE = 0.5;
    private static final int MAXIMUM_FIELDS_PER_FARM = 10;

    public void validateFieldCreation(Field field, Farm farm, double currentFieldArea) {
        validateFieldArea(field.getArea());
        validateMaximumFieldPercentage(field.getArea(), farm);
        validateTotalFarmArea(field.getArea(), currentFieldArea, farm);
        validateMaximumFieldCount(farm);
    }

    public void validateFieldUpdate(Field field, Farm farm, double currentFieldArea) {
        validateFieldArea(field.getArea());
        validateMaximumFieldPercentage(field.getArea(), farm);
        double currentAreaExcludingField = currentFieldArea - field.getArea();
        validateTotalFarmArea(field.getArea(), currentAreaExcludingField, farm);
    }

    private void validateFieldArea(double area) {
        if (area < MINIMUM_FIELD_AREA) {
            throw new IllegalArgumentException("Field area must be at least 1,000 m².");
        }
    }

    private void validateMaximumFieldPercentage(double fieldArea, Farm farm) {
        double maxAllowedArea = farm.getTotalArea() * MAXIMUM_FIELD_PERCENTAGE;
        if (fieldArea > maxAllowedArea) {
            throw new IllegalArgumentException("Field area cannot exceed 50% of the farm's total area.");
        }
    }

    private void validateTotalFarmArea(double newFieldArea, double currentUsedArea, Farm farm) {
        if (currentUsedArea + newFieldArea > farm.getTotalArea()) {
            throw new IllegalArgumentException("Total field area would exceed the total area of the farm.");
        }
    }

    private void validateMaximumFieldCount(Farm farm) {
        if (farm.getFields().size() >= MAXIMUM_FIELDS_PER_FARM) {
            throw new IllegalArgumentException("A farm cannot have more than " + MAXIMUM_FIELDS_PER_FARM + " fields.");
        }
    }
}