package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.RoomDao;
import com.app.entities.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDao roomdao;

	@Override
	public List<Room> getAllAvailableRooms() {
		// TODO Auto-generated method stub
		return roomdao.findAll();
	}

}
