package com.springbootmybatis.po;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Time {

    private LocalDate date;

    private LocalDateTime datetime;

}
