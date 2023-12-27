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

    private int categoryPk;

    private String productNm;

    private String memo;
}

// pk = 0, Nm = ' ' 혹은 Nm = null, userpk가 없을경우