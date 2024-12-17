package com.example.demo.entity;

import lombok.Getter;

@Getter
public enum ReservationStatus {
    PENDING("pending"),
    APPROVED("approved"),
    CANCELED("canceled"),
    EXPIRED("expired");

    private final String value;

    ReservationStatus(String value) {
        this.value = value;
    }

    public static ReservationStatus of(String status) {
        for (ReservationStatus reservationStatus : values()) {
            if (reservationStatus.getValue().equals(status)) {
                return reservationStatus;
            }
        }

        throw new IllegalArgumentException("올바르지 않은 상태: " + status);
    }
}
