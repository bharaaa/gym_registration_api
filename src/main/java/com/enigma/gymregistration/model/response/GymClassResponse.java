package com.enigma.gymregistration.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class GymClassResponse {
    private String id;
    private String className;
    private Date date;
    private LocalTime startTime;
    private LocalTime endTime;
}
