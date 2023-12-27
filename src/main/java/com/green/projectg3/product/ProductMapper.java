package com.green.projectg3.product;


import com.green.projectg3.product.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

// product에 관한 mapper 클래스
// insert: insProduct, select: selProduct, update1: updProduct, delete: delProduct, update2: completeProduct
// update3: deletedProduct
public interface ProductMapper {
    int insProduct(ProductInsDto dto);

    List<ProductSelVo> selProduct(ProductSelDto dto);

    int updProduct(ProductUpdDto dto);

    int delProduct(ProductDelDto dto);

    int completeProduct(ProductCompleteDto dto);

    int returnProduct(ProductCompleteDto dto);

    int hideProduct(ProductDelDto dto);

    ProductEntity selEntity(int productPk);


    Integer checkByUser(int userPk);
    // Integer는 주소값까지 같이 불러올수 있음
    // 만약 불러오는 값이 없으면 null이 들어감

    //Entity





}
