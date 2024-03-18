package steammachinist.relexinternshiptask.mapper;

import org.mapstruct.Mapper;
import steammachinist.relexinternshiptask.dto.ProductDto;
import steammachinist.relexinternshiptask.dto.request.AddProductRequest;
import steammachinist.relexinternshiptask.dto.request.UpdateProductRequest;
import steammachinist.relexinternshiptask.entity.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toProductDto(Product product);

    List<ProductDto> toProductDtos(List<Product> products);

    Product toProduct(ProductDto productDto);

    Product toProduct(AddProductRequest addProductRequest);

    Product toProduct(UpdateProductRequest updateProductRequest);
}
