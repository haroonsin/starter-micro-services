package com.trial.micro.room.service;

import com.trial.micro.room.service.domain.Room;
import com.trial.micro.room.service.domain.RoomRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@Api(value = "rooms", description = "Data service operations on rooms.", tags = "rooms")
class RoomResource {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    @ApiOperation(value = "Get all rooms.", notes = "Get all rooms in the system.", nickname = "getRooms")
    List<Room> findRoom(@RequestParam(value = "roomNo", required = false) String roomNumber) {
        if (StringUtils.isNotBlank(roomNumber)) {
            return Collections.singletonList(roomRepository.findByRoomNumber(roomNumber));
        } else {
            return (List<Room>) roomRepository.findAll();
        }
    }
}
