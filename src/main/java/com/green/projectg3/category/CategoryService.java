package com.green.projectg3.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service

public class CategoryService {
    private final CategoryMapper Cmapper;
}