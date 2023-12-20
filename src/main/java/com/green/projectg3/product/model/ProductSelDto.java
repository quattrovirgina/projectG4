package com.green.projectg3.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="리스트 응답 dto")
public class ProductSelDto {
    private int userPk;

    private int isList;
    // isList는 프론트에서 0, 1, 2를 받는 변수
}
