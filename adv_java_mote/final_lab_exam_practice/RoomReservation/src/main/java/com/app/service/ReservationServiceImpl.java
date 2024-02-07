package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ReservationDao;
import com.app.entities.Reservation;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao reservedao;

	@Override
	public Reservation addNewReservation(Reservation newReservation) {
		// TODO Auto-generated method stub
		return reservedao.save(newReservation);
	}

	@Override
	public String deleteReservation(Integer reservationId) {
		String mesg = "Cancelling Reservation failed !!!! invalid reservation id";
		if (reservedao.existsById(reservationId)) {
			mesg = "Reservation Cancelled ....";
		}
		return mesg;
	}

}
