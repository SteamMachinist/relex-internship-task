package steammachinist.relexinternshiptask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import steammachinist.relexinternshiptask.entity.HarvestEntry;

public interface HarvestEntryRepository extends JpaRepository<HarvestEntry, Long> {
}