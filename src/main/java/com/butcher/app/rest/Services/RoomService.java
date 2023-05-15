package com.butcher.app.rest.Services;

import com.butcher.app.rest.Models.Room;
import com.butcher.app.rest.Repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    public Room getRoomById(long id) {
        return roomRepository.findById(id).get();
    }

    public void save(Room room) {
        roomRepository.save(room);
    }

    public void delete(long id) {
        roomRepository.deleteById(id);
    }

}