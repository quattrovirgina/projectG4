package com.green.projectg3.category.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="카테고리의 모든 목록을 조회할것")
public class CategorySelVo {

    private int categoryPk;
    // category_pk

    private String categoryNm;
    // product_nm

}
