package steammachinist.relexinternshiptask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import steammachinist.relexinternshiptask.entity.Product;
import steammachinist.relexinternshiptask.entity.User;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HarvestEntryDto {
    private Long id;
    private LocalDateTime dateTime;
    private User user;
    private Product product;
    private double amount;
}
