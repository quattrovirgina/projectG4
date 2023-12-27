package com.green.projectg3.product;

import com.green.projectg3.common.ResVo;
import com.green.projectg3.product.model.*;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "상품등록", description = "상품등록 처리")
    public ResVo postProduct(@RequestBody ProductInsDto dto) {
        log.info("result: {}", dto);
        return service.postProduct(dto);
    }

    @GetMapping
    public List<ProductSelVo> getIt(ProductSelDto dto) {
        return service.getP(dto);
    }

    @PutMapping
    public ResVo putIt(@RequestBody ProductUpdDto dto) {
        return service.putP(dto);
    }

    @DeleteMapping
    public ResVo deleteIt(ProductDelDto dto) {
        return service.delP(dto);
    }

    @PatchMapping
    @Operation(summary = "구매확정", description = "구매확정 처리")
    public ResVo completeIt(ProductCompleteDto dto) {
        log.info("the result is : {}", dto);
        return service.comP(dto);
    }
}