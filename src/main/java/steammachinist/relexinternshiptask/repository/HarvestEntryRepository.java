package steammachinist.relexinternshiptask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import steammachinist.relexinternshiptask.entity.HarvestEntry;
import steammachinist.relexinternshiptask.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface HarvestEntryRepository extends JpaRepository<HarvestEntry, Long> {
//    @Query("SELECT p.id as productId, SUM(h.amount) as totalAmount " +
//            "FROM HarvestEntry h " +
//            "JOIN h.product p " +
//            "WHERE DATE(h.dateTime) = :date " +
//            "GROUP BY p.id")
//    List<Object[]> findSumOfAmountsByProductForDate(@Param("date") LocalDate date);
//
//    @Query("SELECT p.id as productId, SUM(h.amount) as totalAmount " +
//            "FROM HarvestEntry h " +
//            "JOIN h.product p " +
//            "WHERE user.id = :user.id " +
//            "GROUP BY p.id")
//    List<Object[]> findSumOfAmountsByProductForUser(@Param("user") User user);
}