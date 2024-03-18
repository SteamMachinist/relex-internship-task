package steammachinist.relexinternshiptask.mapper;

import org.mapstruct.Mapper;
import steammachinist.relexinternshiptask.dto.HarvestEntryDto;
import steammachinist.relexinternshiptask.dto.RatingDto;
import steammachinist.relexinternshiptask.entity.HarvestEntry;
import steammachinist.relexinternshiptask.entity.Rating;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    RatingDto toDto(Rating rating);

    Rating toEntity(RatingDto ratingDto);
}
