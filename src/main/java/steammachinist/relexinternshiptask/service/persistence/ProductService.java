package steammachinist.relexinternshiptask.service.persistence;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import steammachinist.relexinternshiptask.dto.ProductDto;
import steammachinist.relexinternshiptask.dto.request.AddProductRequest;
import steammachinist.relexinternshiptask.dto.request.UpdateProductRequest;
import steammachinist.relexinternshiptask.entity.Product;
import steammachinist.relexinternshiptask.mapper.ProductMapper;
import steammachinist.relexinternshiptask.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    private Product add(Product product) {
        return repository.save(product);
    }

    public ProductDto add(ProductDto product) {
        return mapper.toDto(
                add(mapper.toEntity(product)));
    }

    public ProductDto add(AddProductRequest addProductRequest) {
        return mapper.toDto(
                add(mapper.toEntity(addProductRequest)));
    }

    public Product update(Product product) {
        return add(product);
    }

    public ProductDto update(ProductDto product) {
        return add(product);
    }

    public ProductDto update(UpdateProductRequest updateProductRequest) {
        ProductDto productDto = getProductByNameDto(updateProductRequest.getName());
        productDto.setMeasurementUnit(updateProductRequest.getMeasurementUnit());
        productDto.setInteger(updateProductRequest.isInteger());
        return update(productDto);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public List<ProductDto> getAllDtos() {
        return mapper.toDtos(
                getAll());
    }

    public Product getProductByName(String name) {
        return repository.findProductByName(name).orElseThrow(() -> new EntityNotFoundException("No product with name " + name));
    }

    public ProductDto getProductByNameDto(String name) {
        return mapper.toDto(getProductByName(name));
    }
}
