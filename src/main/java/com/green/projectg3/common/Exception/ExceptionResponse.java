package com.green.projectg3.common.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    private LocalDateTime timestamp; // 에러가 발생한 시간
    private int httpStatusCode;
    private String message; // 메세지 담을 필드
    private String details; // 상세내용 담을 필드
}









