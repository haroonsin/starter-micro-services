package com.trial.micro.reservation.web.client;

import com.trial.micro.reservation.web.domain.Room;
import com.trial.micro.reservation.web.domain.RoomReservation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("RESERVATIONBUSINESSSERVICES")
public interface RoomReservationService {

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<Room> getAllRooms(@RequestParam(name = "roomNumber", required = false) String roomNumber);

    @RequestMapping(value = "/roomReservations/{date}", method = RequestMethod.GET)
    public List<RoomReservation> getRoomReservationsForDate(@PathVariable("date") String date);
}
