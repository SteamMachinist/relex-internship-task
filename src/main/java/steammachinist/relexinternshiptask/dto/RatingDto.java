package steammachinist.relexinternshiptask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import steammachinist.relexinternshiptask.entity.User;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    private User user;
    private LocalDate date;
    private int points;
}
