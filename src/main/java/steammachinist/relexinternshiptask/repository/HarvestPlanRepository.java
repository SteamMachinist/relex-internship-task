package steammachinist.relexinternshiptask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import steammachinist.relexinternshiptask.entity.HarvestPlan;

public interface HarvestPlanRepository extends JpaRepository<HarvestPlan, Long> {
}