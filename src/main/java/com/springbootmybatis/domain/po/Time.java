package com.springbootmybatis.domain.po;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Time {

    private LocalDate date;

    private LocalDateTime datetime;

}
