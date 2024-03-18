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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    private Product add(Product product) {
        return productRepository.save(product);
    }

    public ProductDto add(ProductDto product) {
        return mapper.toProductDto(
                add(mapper.toProduct(product)));
    }

    public ProductDto add(AddProductRequest addProductRequest) {
        return mapper.toProductDto(
                add(mapper.toProduct(addProductRequest)));
    }

    public Product update(Product product) {
        return add(product);
    }

    public ProductDto update(ProductDto product) {
        return add(product);
    }

    public ProductDto update(UpdateProductRequest updateProductRequest) {
        ProductDto productDto = getProductByName(updateProductRequest.getName())
                .orElseThrow(() -> new EntityNotFoundException("No product with name " + updateProductRequest.getName()));
        productDto.setMeasurementUnit(updateProductRequest.getMeasurementUnit());
        productDto.setInteger(updateProductRequest.isInteger());
        return update(productDto);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<ProductDto> getAllResponses() {
        return mapper.toProductDtos(
                getAll());
    }

    public Optional<ProductDto> getProductByName(String name) {
       return productRepository.findProductByName(name)
               .map(mapper::toProductDto);
    }
}
