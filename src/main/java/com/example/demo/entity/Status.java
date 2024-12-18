package com.example.demo.entity;

import lombok.Getter;

@Getter
public enum Status {
    PENDING("pending"),
    APPROVED("approved"),
    CANCELED("canceled"),
    EXPIRED("expired");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public static Status of(String status) {
        for (Status value : values()) {
            if (value.getValue().equals(status)) {
                return value;
            }
        }

        throw new IllegalArgumentException("올바르지 않은 상태: " + status);
    }
}
