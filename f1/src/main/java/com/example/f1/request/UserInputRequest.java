package com.example.f1.request;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class UserInputRequest {
    private String raceName;
    private String location;
    private LocalDate date;
    private LocalTime time;
    private String status;
}
