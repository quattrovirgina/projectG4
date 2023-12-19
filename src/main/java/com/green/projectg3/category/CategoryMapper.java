package com.green.projectg3.category;

import com.green.projectg3.category.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

//category mapper클래스
// insert: insCategory, select: selCategory, update: updCategory, delete: delCategory
public interface CategoryMapper {
    int insCategory(CategoryInsDto dto);

    List<CategorySelVo> selCategory(CategorySelDto dto);

    int updCategory(CategoryUpdDto dto);

    int delCategory(CategoryDelDto dto);
}
