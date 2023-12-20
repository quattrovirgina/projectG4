package com.green.projectg3.product;

import com.green.projectg3.common.ResVo;
import com.green.projectg3.product.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service

public class ProductService {
    private final ProductMapper pMapper;

    public ResVo postIt(ProductInsDto dto) {
        int result = pMapper.insProduct(dto);

        if(result == 0) {
            return new ResVo(0);

        }
        return new ResVo(1);
    }

    public List<ProductSelVo> getP(ProductSelDto dto) {
        return pMapper.selProduct(dto);
    }

    public ResVo putP(ProductUpdDto dto) {
        int result = pMapper.updProduct(dto);

        if(result == 1) {
            return new ResVo(1);
        }
        return new ResVo(0);
    }

    public ResVo delP(ProductDelDto dto) {
        int result = pMapper.delProduct(dto);
        int result2 = pMapper.deletedProduct(dto);

        if(result == 0 && result2 == 0) {
            return new ResVo(0);
        }
        return new ResVo(1);
    }

    public ResVo comP(ProductCompleteDto dto) {
        int result = pMapper.completeProduct(dto);

        if(result == 0) {
            return new ResVo(0);
        }
        return new ResVo(1);
    }
}
