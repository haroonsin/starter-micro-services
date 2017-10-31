package com.trial.micro.reservation.service;

import com.trial.micro.reservation.service.client.RoomService;
import com.trial.micro.reservation.service.domain.Room;
import com.trial.micro.reservation.service.domain.RoomReservation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "RoomReservations", description = "Business process service operations on rooms and reservations", tags = ("roomReservations"))
public class ReservationResource {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomReservationBusinessProcess businessProcess;

    @GetMapping(value = "/rooms")
    @ApiOperation(value = "Get All Rooms", notes = "Gets all rooms in the system", nickname = "getRooms")
    public List<Room> getAllRooms(@RequestParam(name = "roomNumber", required = false) String roomNumber) {
        return this.roomService.findAll(roomNumber);
    }

    @GetMapping(value = "/roomReservations/{date}")
    @ApiOperation(value = "Get Room Reservations", notes = "Gets all reservations for a specific date", nickname = "getReservationsForDate")
    public List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date) {
        return this.businessProcess.getRoomReservationsForDate(date);
    }
}
