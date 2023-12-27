package com.green.projectg3.product;

import com.green.projectg3.category.CategoryMapper;
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
    // productmapper
    private final CategoryMapper cMapper;
    // categorymapper

    public ResVo postProduct(ProductInsDto dto) {
        log.info("the result is : {}", dto);

        Integer checkUser = pMapper.checkByUser(dto.getUserPk());
        // checkuser는 dto에서 받은 userpk를 파라미터로 checkByUser 클래스를 적용한 int 값이다

        Integer checkCategory = cMapper.selByCategory(dto.getCategoryPk());
        // checkCatgeory는 cMapper에서 dto에서 받아온 categoryPk를 selByCategory 클래스를 적용한 integer
        // 타입의 결과값이다

        if(checkUser == null) { // checkUser에 값이 없다면
            throw new NoDataExpection(String.format("없는 유저입니다"));
            // 없는 유저라고 예외처리하고
        }

        if(checkCategory == null) { // 마찬가지로 checkCategory에 값이 없다면
            throw new NoDataExpection(String.format("없는 카테고리입니다"));
            // 없는 카테고리라고 예외처리를 발생시킨다
        }

        // 위의 두가지 조건을 충족하지 않는다면
        pMapper.insProduct(dto);
        // pMapper에서 Product를 추가하는 클래스로 간다
        return new ResVo(1);
        // 성공했을 시 1을 리턴하도록 한다
    }

    public List<ProductSelVo> getP(ProductSelDto dto) { // List 타입의 getP 클래스. product 목록을 select해서 가져온다
        Integer checkUser = pMapper.checkByUser(dto.getUserPk());
        // Integer 타입의 checkUser는 pMapper내에서 dto의 userPk가 checkByUser에 적용한 결과값임을 선언한다

        if(checkUser == null) { // checkUser가 null값이라면
            throw new NoDataExpection("존재하지 않는 유저입니다");
            // 존재하지 않는 유저라고 예외처리를 한다
        }

        if(dto.getChoiceList() > 2 || dto.getChoiceList() < 0) {
            throw new NoDataExpection("잘못된 choiceList 입력입니다");
        }
        // dto에서의 ChoiceList가 2 이상이거나 0 미만이라면
        // 잘못된 choiceList라고 예외처리를 발생

        return pMapper.selProduct(dto);
        // pMapper에서 selProduct 클래스를 리턴한다
    }

    public ResVo putP(ProductUpdDto dto) { // dto를 파라미터로 하여 데이터를 수정하는 클래스

        ProductEntity en = pMapper.selEntity(dto.getProductPk());
        // ProductEntity 타입의 en은 pMapper 내에서 selEntity를 적용한 productPk값을 가진다

        Integer ca = cMapper.selByCategory(dto.getCategoryPk());
        // Integer 타입의 ca는 cMapper내에서 dto에서 가져온 selByCategory를 적용한 categoryPk의 결과값이다

        if(en == null || dto.getProductPk() <= 0) { // en이 null이고 productPk가 0보다 작거나 같다면
            throw new NoDataExpection(String.format("존재하지 않는 pk입니다"));
            // 존재하지 않는 pk라고 예외처리
        }

        if(dto.getUserPk() <= 0) { // userpk가 0보다 작거나 같다면
            throw new NoDataExpection(String.format("없는 userpk"));
            // 없는 userpk라고 예외처리할것
        }

        if(ca == null) { // ca가 null값이라면
            throw new NoDataExpection(String.format("없는 categorypk"));
            // 없는 categoryPk라고 예외처리 해둘것
        }

        int result = pMapper.updProduct(dto);

        return new ResVo(1);
        // 위의 조건들을 만족하지 않는다면 1을 리턴하도록 할것
    }


    public ResVo comP(ProductCheckDto dto) { // 구매확정된 상품들을 처리하는 comP

        ProductEntity en = pMapper.selEntity(dto.getProductPk());
        // en은 pMapper 내에서 selEntity를 적용한 productPk의 결과값을 갖는다

        if(en == null) { // en이 null값이라면
            throw new NoDataExpection(String.format("잘못된 물건의 pk입니다"));
            // 잘못된 물건의 pk값임을 예외처리할것
        }

        if(en.getUserPk() != dto.getUserPk()) { // en에서의 userpk와 dto에서의 userpk가 다르다면
           throw new NoDataExpection(String.format("다른 유저의 물건입니다"));
           // 다른 유저의 물건임을 예외처리할것
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
            return new ResVo(2);
        } // 구매확정 되었다면 ResVo를 returnProduct를 통해서
        // 1 -> 0으로 바꿔놓고 결과를 1로 리턴하도록 한다

        pMapper.completeProduct(dto);
        // 그게 아니라면 completeProduct를 실행하도록 하고

        return new ResVo(1);
        // 1을 리턴하도록 하라

    }
    public ResVo delP(ProductDelDto dto) { // 데이터를 삭제하는 delP

        Integer checkUser = pMapper.checkByUser(dto.getUserPk());
        // checkUser라는 Integer 변수는 pMapper 내에서 checkByUser를 적용한 userPk의 결과값을 가진다

        ProductEntity en = pMapper.selEntity(dto.getProductPk());
        // ProductEntity 타입의 en 변수는 pMapper 내에서 selEntity를 적용한 productPk의 결과값을 가진다

        if(checkUser == null) { // checkUser가 null값을 가질경우
            throw new NoDataExpection("없는 유저입니다");
            // 없는 유저라고 예외처리해둘것
        }

        if(en == null) { // en이 null값을 가질경우
            throw new NoDataExpection("없는 물건pk입니다");
            // 없는 물건pk라고 예외처리할것
        }

        if(en.getUserPk() != dto.getUserPk()) { // en에서의 userpk와 dto에서의 userpk가 같지 않다면
            // 그러니까 내가 담아놓은 물건이 아니라면
            throw new NoDataExpection("다른 유저의 물건입니다");
            // 다른 유저의 물건이라고 예외처리를 할것
        }

        if(en.getBuyingCheck() == 2) { // BuyingCheck 값이 2인 경우
            throw new NoDataExpection("이미 삭제처리된 상품입니다");
            // 이미 삭제처리된 상품이라고 예외처리할것
        }
        // 위의 조건들을 만족하지 않는다면
        pMapper.delProduct(dto);
        // pMapper 내에서 dto의 데이터를 삭제하도록 하고
        pMapper.hideProduct(dto);
        // hideProduct로 삭제된 pk를 저장하도록 한다
        return new ResVo(1);
        //
    }


}
