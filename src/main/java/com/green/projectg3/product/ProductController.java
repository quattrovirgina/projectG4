package com.green.projectg3.product;

import com.green.projectg3.common.ResVo;
import com.green.projectg3.product.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/product")

public class ProductController {
    private final ProductService service;

    @PostMapping
    public ResVo postProduct(@RequestBody ProductInsDto dto) {
        log.info("result: {}", dto);
        return service.postProduct(dto);
    }

    @GetMapping
    public List<ProductSelVo> Getit(ProductSelDto dto) {
        return service.getP(dto);
    }

    @PutMapping
    public ResVo putIt(@RequestBody ProductUpdDto dto) {
        return service.putP(dto);
    }

    @DeleteMapping
    public ResVo Deleteit(ProductDelDto dto) {
        return service.delP(dto);
    }

    @PatchMapping
    public ResVo Completeit(ProductCompleteDto dto) {
        return service.comP(dto);
    }
}
