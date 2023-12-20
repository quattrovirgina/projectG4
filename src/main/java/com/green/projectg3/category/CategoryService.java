package com.green.projectg3.category;

import com.green.projectg3.category.model.CategoryInsDto;
import com.green.projectg3.category.model.CategorySelDto;
import com.green.projectg3.category.model.CategorySelVo;
import com.green.projectg3.common.ResVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service

public class CategoryService {
    private final CategoryMapper Cmapper;

    public List<CategorySelVo> getCategory(CategorySelDto dto) {
        return Cmapper.selCategory(dto);
    }

    public ResVo CategoryIns(CategoryInsDto dto) {
        return new ResVo(Cmapper.insCategory(dto));
    }

    public ResVo


}
