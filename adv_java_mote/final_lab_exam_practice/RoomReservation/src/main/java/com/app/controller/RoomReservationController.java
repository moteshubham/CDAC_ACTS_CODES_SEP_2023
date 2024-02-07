package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Reservation;
import com.app.entities.Room;
import com.app.service.ReservationService;
import com.app.service.RoomService;

@RestController
public class RoomReservationController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private ReservationService reserveService;

	@PostMapping("/reservations")
	public ResponseEntity<Object> newReservation(@RequestBody Reservation reservation) {
		try {
			Reservation newReservation = reserveService.addNewReservation(reservation);
			return ResponseEntity.status(HttpStatus.OK).body(newReservation);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@GetMapping("/rooms")
	public ResponseEntity<Object> availableRooms(@RequestParam("available") String param1) {
		try {
			List<Room> availableRoomList = roomService.getAllAvailableRooms();
			return ResponseEntity.status(HttpStatus.OK).body(availableRoomList);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@DeleteMapping("/reservations/{reservationId}")
	public ResponseEntity<Object> cancelReservation(@PathVariable Integer reservationId) {
		try {
			String cancelReservationMsg = reserveService.deleteReservation(reservationId);
			return ResponseEntity.status(HttpStatus.OK).body(cancelReservationMsg);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
