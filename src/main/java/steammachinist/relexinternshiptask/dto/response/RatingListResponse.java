package steammachinist.relexinternshiptask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingListResponse {
    private String email;
    private String date;
    private int points;
}
