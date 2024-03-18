package steammachinist.relexinternshiptask.service.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import steammachinist.relexinternshiptask.dto.HarvestEntryDto;
import steammachinist.relexinternshiptask.dto.request.AddHarvestEntryRequest;
import steammachinist.relexinternshiptask.entity.HarvestEntry;
import steammachinist.relexinternshiptask.entity.Product;
import steammachinist.relexinternshiptask.entity.User;
import steammachinist.relexinternshiptask.mapper.HarvestEntryMapper;
import steammachinist.relexinternshiptask.repository.HarvestEntryRepository;
import steammachinist.relexinternshiptask.service.authentication.AuthenticationService;

@Service
@RequiredArgsConstructor
public class HarvestEntryService {
    private final HarvestEntryRepository repository;
    private final HarvestEntryMapper harvestEntryMapper;
    private final AuthenticationService authenticationService;
    private final ProductService productService;

    public HarvestEntry add(HarvestEntry harvestEntry) {
        return repository.save(harvestEntry);
    }

    public HarvestEntryDto add(HarvestEntryDto harvestEntry) {
        return harvestEntryMapper.toDto(
                repository.save(harvestEntryMapper.toEntity(harvestEntry)));
    }

    public HarvestEntryDto add(AddHarvestEntryRequest addHarvestEntryRequest) {
        User user = authenticationService.getAuthenticatedUser();
        Product product = productService.getProductByName(addHarvestEntryRequest.getProductName());
        HarvestEntry harvestEntry = new HarvestEntry(user, product, addHarvestEntryRequest.getAmount());
        return harvestEntryMapper.toDto(add(harvestEntry));
    }
}
