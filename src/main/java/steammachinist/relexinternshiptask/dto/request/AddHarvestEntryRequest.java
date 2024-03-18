package steammachinist.relexinternshiptask.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddHarvestEntryRequest {
    private String productName;
    private double amount;
}
