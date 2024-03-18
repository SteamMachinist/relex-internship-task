package steammachinist.relexinternshiptask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import steammachinist.relexinternshiptask.dto.ProductDto;
import steammachinist.relexinternshiptask.dto.request.AddProductRequest;
import steammachinist.relexinternshiptask.dto.request.UpdateProductRequest;
import steammachinist.relexinternshiptask.service.persistence.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<Void> addProduct(@RequestBody AddProductRequest request) {
        productService.add(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<Void> updateProduct(@RequestBody UpdateProductRequest request) {
        productService.update(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllDtos());
    }
}
