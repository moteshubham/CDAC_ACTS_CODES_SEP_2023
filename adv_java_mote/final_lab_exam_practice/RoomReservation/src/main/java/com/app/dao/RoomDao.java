package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Room;

public interface RoomDao extends JpaRepository<Room,Integer>{

}
