package steammachinist.relexinternshiptask.mapper;

import org.mapstruct.Mapper;
import steammachinist.relexinternshiptask.dto.HarvestEntryDto;
import steammachinist.relexinternshiptask.entity.HarvestEntry;

@Mapper(componentModel = "spring")
public interface HarvestEntryMapper {
    HarvestEntryDto toDto(HarvestEntry harvestEntry);

    HarvestEntry toEntity(HarvestEntryDto harvestEntryDto);
}
