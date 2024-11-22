package org.NAK.Citronix.SearchCriteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.NAK.Citronix.Entity.Farm;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class FarmSearch {

    public static Specification<Farm> createSearchSpecification(String name, String location, Double minArea, Double maxArea , LocalDate creationDate) {
        return (Root<Farm> farmRoot, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            Predicate predicate = cb.conjunction();

            if (name != null && !name.isEmpty()) {
                predicate = cb.and(predicate, cb.like(farmRoot.get("name"), "%" + name + "%"));
            }

            if (location != null && !location.isEmpty()) {
                predicate = cb.and(predicate, cb.like(farmRoot.get("location"), "%" + location + "%"));
            }

            if (minArea != null) {
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(farmRoot.get("total_area"), minArea));
            }

            if (maxArea != null) {
                predicate = cb.and(predicate, cb.lessThanOrEqualTo(farmRoot.get("totalArea"), maxArea));
            }

            if (creationDate != null) {
                predicate = cb.and(predicate, cb.equal(farmRoot.get("creationDate"), creationDate));
            }

            return predicate;
        };
    }
}