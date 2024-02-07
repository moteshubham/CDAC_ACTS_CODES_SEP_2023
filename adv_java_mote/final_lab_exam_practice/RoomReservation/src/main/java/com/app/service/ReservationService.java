package com.app.service;

import com.app.entities.Reservation;

public interface ReservationService {

	Reservation addNewReservation(Reservation newReservation);
	
	String deleteReservation(Integer reservationId);
}
