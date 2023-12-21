package com.green.projectg3.category.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="지정된 카테고리를 수정하는 dto")

public class CategoryUpdDto {
    private int categoryPk;
    // category_pk

    private String categoryNm;
    // category_nm
}
