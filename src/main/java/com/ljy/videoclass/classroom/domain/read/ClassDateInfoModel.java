package com.ljy.videoclass.classroom.domain.read;

import lombok.Builder;

import java.time.DayOfWeek;

public class ClassDateInfoModel {
    private DayOfWeek dayOfWeek;
    private int startHour, endHour;

    @Builder
    public ClassDateInfoModel(DayOfWeek dayOfWeek, int startHour, int endHour) {
        this.dayOfWeek = dayOfWeek;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }
}
