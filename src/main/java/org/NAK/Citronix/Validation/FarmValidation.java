package org.NAK.Citronix.Validation;

import org.NAK.Citronix.Entity.Farm;
import org.springframework.stereotype.Component;

@Component
public class FarmValidation {

    private static final double minimum_area = 2000.0;

    public void validateFarm(Farm farm) {

        validateFarmArea(farm);
    }

    private void validateFarmArea(Farm farm) {
        if (farm.getTotalArea() < minimum_area) {
            throw new IllegalArgumentException("Farm area should be greater than the minimum area 2000 m");
        }
    }
}
