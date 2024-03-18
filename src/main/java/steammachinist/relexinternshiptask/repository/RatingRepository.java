package steammachinist.relexinternshiptask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import steammachinist.relexinternshiptask.entity.Rating;
import steammachinist.relexinternshiptask.entity.RatingKey;

public interface RatingRepository extends JpaRepository<Rating, RatingKey> {
}