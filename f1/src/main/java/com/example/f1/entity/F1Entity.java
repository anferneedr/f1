package com.example.f1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class F1Entity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "Racetrack")
        private String raceName;

        @Column(name = "location")
        private String location;

        @Column(name = "date")
        private LocalDate date;

        @Column(name = "time")
        private LocalTime time;

        @Column(name = "status")
        private String status;
}