package com.green.projectg3.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="리스트 응답 vo")
public class ProductSelVo {

    private int productPk;

    private int categoryPk;

    private String categoryNm;

    private String productNm;

    private String memo;

    private String createdAt;

    private int buyingCheck;

    private String buyingDate;
}
