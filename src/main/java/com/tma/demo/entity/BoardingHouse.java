package com.tma.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

import static com.tma.demo.constant.TableName.BOARDING_HOUSE;

/**
 * BoardingHouseController
 * Version 1.0
 * Date: 07/10/2024
 * Copyright
 * Modification Logs
 * DATE          AUTHOR          DESCRIPTION
 * ------------------------------------------------
 * 07/10/2024        NGUYEN             create
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = BOARDING_HOUSE)
public class BoardingHouse extends BaseTimeEntity {
    @ManyToOne
    private User user;
    private String boardingHouseName;
    private String presentAddress;
    private String ward;
    private String city;
    private boolean isDelete;

}
