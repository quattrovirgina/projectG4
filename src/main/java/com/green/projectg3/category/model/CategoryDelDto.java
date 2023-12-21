package com.green.projectg3.category.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name="카테고리 목록을 삭제")

public class CategoryDelDto {
    private int categoryPk;
    // category_pk
}
