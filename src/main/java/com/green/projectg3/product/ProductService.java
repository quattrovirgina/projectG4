package com.green.projectg3.product;

import com.green.projectg3.common.Exception.Cody;
import com.green.projectg3.common.Exception.Const;
import com.green.projectg3.common.Exception.NoDataExpection;
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

    public ResVo postProduct(ProductInsDto dto) {
        log.info("dto: {}", dto);
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

        ProductEntity en = pMapper.selEntity(dto.getProductPk());
        Integer ca = pMapper.selByCategory(dto.getCategoryPk());

        if(en == null || dto.getProductPk() <= 0) {
            throw new NoDataExpection(String.format("존재하지 않는 pk입니다"));
        }


        if(en == null )

        if(dto.getUserPk() <= 0) {
            throw new NoDataExpection(String.format("없는 userpk"));
        }
        if(ca == null){
            throw new NoDataExpection(String.format("없는 categorypk"));
        }





        int result = pMapper.updProduct(dto);

        return new ResVo(1);
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