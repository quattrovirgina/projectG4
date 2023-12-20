package com.green.projectg3.product.model;

import lombok.Data;

@Data
// productPk 만으로 해당 pk에 들어있는 모든 컬럼을 조회하라
// 들어가야 할것: productPk, userPk, categoryPk, productNm,
// memo, createdAt, updatedAt, buyingCheck, buyingDate
// 날짜 타입들은 죄다 string으로 해놓을것

public class ProductEntity {
    private int productPk;

    private int userPk;

    private int categoryPk;

    private String productNm;

    private String memo;

    private String createdAt;

    private String updatedAt;

    private int buyingCheck;

    private String buyingDate;
}
