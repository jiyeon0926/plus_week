package com.example.demo.dto;

import com.example.demo.entity.Reservation;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReservationStatusResponseDto {
    private Long id;
    private String nickname;
    private String itemName;
    private String status;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    public ReservationStatusResponseDto(Long id, String nickname, String itemName, String status, LocalDateTime startAt, LocalDateTime endAt) {
        this.id = id;
        this.nickname = nickname;
        this.itemName = itemName;
        this.status = status;
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public static ReservationStatusResponseDto toDto(Reservation reservation) {
        return new ReservationStatusResponseDto(
                reservation.getId(),
                reservation.getUser().getNickname(),
                reservation.getItem().getName(),
                reservation.getStatus().getValue(),
                reservation.getStartAt(),
                reservation.getEndAt()
        );
    }
}
