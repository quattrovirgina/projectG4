package com.green.projectg3.product;

import com.green.projectg3.category.CategoryMapper;
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
    private final CategoryMapper cMapper;

    public ResVo postProduct(ProductInsDto dto) {
        log.info("the result is : {}", dto);

        Integer checkUser = pMapper.checkByUser(dto.getUserPk());

        Integer checkCategory = cMapper.selByCategory(dto.getCategoryPk());


        if(checkUser == null) {
            throw new NoDataExpection(String.format("없는 유저입니다"));
        }

        if(checkCategory == null) {
            throw new NoDataExpection(String.format("없는 카테고리입니다"));
        }


        pMapper.insProduct(dto);
        return new ResVo(1);
    }

    public List<ProductSelVo> getP(ProductSelDto dto) {
        Integer checkUser = pMapper.checkByUser(dto.getUserPk());

        if(checkUser == null) {
            throw new NoDataExpection("존재하지 않는 유저입니다");
        }

        if(dto.getChoiceList() > 2 || dto.getChoiceList() < 0) {
            throw new NoDataExpection("잘못된 choiceList 입력입니다");
        }

        return pMapper.selProduct(dto);
    }

    public ResVo putP(ProductUpdDto dto) {

        ProductEntity en = pMapper.selEntity(dto.getProductPk());
        Integer ca = cMapper.selByCategory(dto.getCategoryPk());

        if(en == null || dto.getProductPk() <= 0) {
            throw new NoDataExpection(String.format("존재하지 않는 pk입니다"));
        }

        if(dto.getUserPk() <= 0) {
            throw new NoDataExpection(String.format("없는 userpk"));
        }
        if(ca == null){
            throw new NoDataExpection(String.format("없는 categorypk"));
        }

        int result = pMapper.updProduct(dto);

        return new ResVo(1);
    }


    public ResVo comP(ProductCompleteDto dto) {

        ProductEntity en = pMapper.selEntity(dto.getProductPk());

        if(en == null) {
            throw new NoDataExpection(String.format("잘못된 물건의 pk입니다"));
        }

        if(en.getUserPk() != dto.getUserPk()) {
           throw new NoDataExpection(String.format("다른 유저의 물건입니다"));
        }

        // 1) 먼저 null인지 아닌지 판단하고
        // null값에 대한 조건을 맨위에다 서술하지 않으면
        // "Cannot invoke \"com.green.projectg3.product.model.ProductEntity.getUserPk()\" because \"en\" is null",
        // 라고 뜬다
        // 2) 그담에 나머지 예외처리를 할것


        if(en.getBuyingCheck() == 2) {
            throw new NoDataExpection(String.format("삭제된 상품입니다"));
        }

        if(en.getBuyingCheck() == 1) {
            pMapper.returnProduct(dto);
            return new ResVo(1);
        } // 구매확정 되었다면 ResVo를 returnProduct를 통해서
        // 1 -> 0으로 바꿔놓고 결과를 1로 리턴하도록 한다

        pMapper.completeProduct(dto);
        // 그게 아니라면 completeProduct를 실행하도록 하고

        return new ResVo(1);
        // 1을 리턴하도록 하라

    }
    public ResVo delP(ProductDelDto dto) {

        Integer checkUser = pMapper.checkByUser(dto.getUserPk());

        ProductEntity en = pMapper.selEntity(dto.getProductPk());

        if(checkUser == null) {
            throw new NoDataExpection("없는 유저입니다");
        }

        if(en == null) {
            throw new NoDataExpection("없는 물건pk입니다");
        }

        if(en.getUserPk() != dto.getUserPk()) {
            throw new NoDataExpection("다른 유저의 물건입니다");
        }

        if(en.getBuyingCheck() == 2) {
            throw new NoDataExpection("이미 삭제처리된 상품입니다");
        }

        pMapper.delProduct(dto);
        pMapper.hideProduct(dto);
        return new ResVo(1);
    }


}
