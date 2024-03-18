package steammachinist.relexinternshiptask.mapper;

import org.mapstruct.Mapper;
import steammachinist.relexinternshiptask.dto.ProductDto;
import steammachinist.relexinternshiptask.dto.request.AddProductRequest;
import steammachinist.relexinternshiptask.entity.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);

    List<ProductDto> toDtos(List<Product> products);

    Product toEntity(ProductDto productDto);

    Product toEntity(AddProductRequest addProductRequest);
}
