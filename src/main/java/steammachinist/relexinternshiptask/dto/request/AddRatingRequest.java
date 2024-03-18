package steammachinist.relexinternshiptask.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddRatingRequest {
    private String employeeEmail;
    private String date;
    private int points;
}
