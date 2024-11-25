package org.NAK.Citronix.Validation;

import org.NAK.Citronix.Entity.Harvest;
import org.NAK.Citronix.Enum.Season;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class HarvestValidator {

    public void validateNewHarvest(Harvest harvest, List<Harvest> existingHarvests) {

        for (Harvest existingHarvest : existingHarvests) {
            if (existingHarvest.getSeason() == harvest.getSeason() &&
                    existingHarvest.getHarvestDate().getYear() == harvest.getHarvestDate().getYear()) {
                throw new IllegalArgumentException("A harvest already exists for this season in the same year");
            }
        }

        validateHarvestDate(harvest.getHarvestDate(), harvest.getSeason());
    }

    public void validateSeasonForUpdate(Season newSeason, Long currentHarvestId, List<Harvest> existingHarvests) {
        boolean seasonExistsForOtherHarvest = existingHarvests.stream()
                .anyMatch(harvest -> !harvest.getId().equals(currentHarvestId) &&
                        harvest.getSeason() == newSeason);

        if (seasonExistsForOtherHarvest) {
            throw new IllegalArgumentException("A harvest already exists for this season");
        }
    }

    public void validateHarvestDate(LocalDate harvestDate, Season season) {
        if (harvestDate == null) {
            throw new IllegalArgumentException("Harvest date cannot be null");
        }

        if (harvestDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Harvest date cannot be in the future");
        }

        if (!isDateMatchingSeason(harvestDate, season)) {
            throw new IllegalArgumentException("Harvest date does not match the specified season");
        }
    }

    private boolean isDateMatchingSeason(LocalDate date, Season season) {
        int month = date.getMonthValue();

        return switch (season) {
            case WINTER -> (month == 12 || month == 1 || month == 2);
            case SPRING -> (month >= 3 && month <= 5);
            case SUMMER -> (month >= 6 && month <= 8);
            case AUTUMN -> (month >= 9 && month <= 11);
        };
    }
}