package com.green.projectg3.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductCheckDto {
    @Schema(name="productPk")
    private int productPk;

    @Schema(name="userPk")
    private int userPk;
}
