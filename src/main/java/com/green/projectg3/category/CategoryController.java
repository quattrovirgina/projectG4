package com.green.projectg3.category;

import com.green.projectg3.category.model.CategoryDelDto;
import com.green.projectg3.category.model.CategoryInsDto;
import com.green.projectg3.category.model.CategorySelVo;
import com.green.projectg3.category.model.CategoryUpdDto;
import com.green.projectg3.common.ResVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/category")

public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public List<CategorySelVo> selCategory() {
        return service.getCategory();
    }

    @PostMapping
    public ResVo insCategory(@RequestBody CategoryInsDto dto) {
        return service.CategoryIns(dto);
    }

    @PatchMapping
    public ResVo updCategory(@RequestBody CategoryUpdDto dto) {
        return service.CategoryUpd(dto);
    }

    @DeleteMapping
    public ResVo delCategory(CategoryDelDto dto) {
        return service.categoryDel(dto);
    }


}
