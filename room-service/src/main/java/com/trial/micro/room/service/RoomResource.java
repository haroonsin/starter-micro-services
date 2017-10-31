package com.trial.micro.room.service;

import com.trial.micro.room.service.domain.Room;
import com.trial.micro.room.service.domain.RoomRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Api(value = "rooms", description = "Data service operations on rooms.", tags = "rooms")
class RoomResource {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("rooms")
    @ApiOperation(value = "Get All Rooms", notes = "Gets all rooms in the system", nickname = "getRooms")
    public List<Room> findAll(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
        if (StringUtils.isNotEmpty(roomNumber)) {
            return Collections.singletonList(this.roomRepository.findByRoomNumber(roomNumber));
        }
        return (List<Room>) this.roomRepository.findAll();
    }

    @GetMapping(value = "rooms/{id}")
    @ApiOperation(value = "Get Room", notes = "Gets a single room based on its unique id", nickname = "getRoom")
    public Room findOne(@PathVariable("id") long id) {
        return this.roomRepository.findOne(id);
    }
}
