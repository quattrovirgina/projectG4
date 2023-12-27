package com.green.projectg3.product;
// product controller 클래스
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
    @Operation(summary="리스트 선택", description="상품 선택처리")
    public List<ProductSelVo> getIt(ProductSelDto dto) {
        return service.getP(dto);
    }

    @PutMapping
    @Operation(summary="상품 수정", description="상품 수정처리")
    public ResVo putIt(@RequestBody ProductUpdDto dto) {
        return service.putP(dto);
    }

    @DeleteMapping
    @Operation(summary="상품 삭제", description="상품 삭제처리")
    public ResVo deleteIt(ProductDelDto dto) {
        return service.delP(dto);
    }

    @PatchMapping
    @Operation(summary = "구매확정", description = "구매확정 처리")
    public ResVo completeIt(ProductCheckDto dto) {
        log.info("the result is : {}", dto);
        return service.comP(dto);
    }
}