package com.green.projectg3.product.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="장바구니 등록 dto")
public class ProductInsDto {
    @JsonIgnore
    private int productPk;

    private int userPk;

    private int category;

    private String productNm;

    private String memo;
}
