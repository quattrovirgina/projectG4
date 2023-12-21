package com.green.projectg3.category.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

// 카테고리 새로 추가하는 클래스
// 사용 테이블: categoryNm
@Data
public class CategoryInsDto {
    @JsonIgnore
    private int categoryPk;

    private String categoryNm;
    // category_nm
}
