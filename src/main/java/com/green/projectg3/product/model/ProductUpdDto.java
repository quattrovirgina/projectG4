package com.green.projectg3.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title="장바구니에서 수정할 목록이 있을경우")
public class ProductUpdDto {
    private int productPk;

    private int userPk;

    private String productNm;

    private int categoryPk;

    private String memo;

}
