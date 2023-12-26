package com.green.projectg3.common.Exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Const {
    private int code;
    private String message;
}
