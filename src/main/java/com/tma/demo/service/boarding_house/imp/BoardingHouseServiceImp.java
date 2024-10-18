package com.tma.demo.service.boarding_house.imp;

import com.tma.demo.dto.BoardingHouseDto;
import com.tma.demo.entity.BoardingHouse;
import com.tma.demo.repository.BoardingHouseRepository;
import com.tma.demo.service.boarding_house.BoardingHouseService;
import com.tma.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * BoardingHouseServiceImp
 * Version 1.0
 * Date: 18/10/2024
 * Copyright
 * Modification Logs
 * DATE          AUTHOR          DESCRIPTION
 * ------------------------------------------------
 * 18/10/2024        NGUYEN             create
 */
@Service
@RequiredArgsConstructor
public class BoardingHouseServiceImp implements BoardingHouseService {
    private final BoardingHouseRepository boardingHouseRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public BoardingHouseDto register(BoardingHouseDto request) {
        BoardingHouse boardingHouse = BoardingHouse.builder()
                .boardingHouseName(request.getBoardingHouseName())
                .user(userService.getUserDetails())
                .city(request.getCity())
                .ward(request.getWard())
                .isDelete(false)
                .presentAddress(request.getPresentAddress())
                .build();
        boardingHouse = boardingHouseRepository.saveAndFlush(boardingHouse);
        return modelMapper.map(boardingHouse, BoardingHouseDto.class);
    }

    private Boolean isBoardingHouseNameExists(String boardingHouseName) {
        return
    }

    public BoardingHouse getBoardingHouse(String id){
        return boardingHouseRepository.findBoardingHouseById(UUID.fromString(id));
    }
}
