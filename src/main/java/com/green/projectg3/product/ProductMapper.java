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

    int deletedProduct(ProductDelDto dto);

    ProductEntity selEntity(int productPk);

    Integer selByCategory(int categoryPk);
    //Entity




}
