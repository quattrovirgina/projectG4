package com.green.projectg3.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="장바구니 삭제 dto")
public class ProductDelDto {
    private int ProductPk;

    private int userPk;
    //리스트별로 삭제하는 것이 아닌 낱개별로 선택하여 삭제할것
}
