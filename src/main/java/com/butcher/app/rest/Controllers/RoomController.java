package com.butcher.app.rest.Controllers;

import com.butcher.app.rest.Models.Room;
import com.butcher.app.rest.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping(value = "/rooms")
    public List<Room> getAll(){
        return roomService.getAll();
    }

    @GetMapping(value = "/rooms/{id}")
    public Room getRoomById(@PathVariable long id){
        return roomService.getRoomById(id);
    }

    @PostMapping(value = "/rooms/add")
    public void add(@RequestBody Room room){
        roomService.save(room);
    }

    @PutMapping(value = "/rooms/update/{id}")
    public void update(@PathVariable long id,@RequestBody Room room){
        Room updatedRoom = roomService.getRoomById(id);
        roomService.save(room);
    }

    @DeleteMapping(value = "/rooms/delete/{id}")
    public void delete(@PathVariable long id){
        roomService.delete(id);
    }


    //////////////////////////////////////////////////////////////////////////////////


    @GetMapping(value = "/rooms/available")
    public List<Room> getAvailableRooms(){
        return roomService.getAll().stream()
                .filter(room -> room.getUser() == null)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/rooms/occupied")
    public List<Room> getOccupiedRooms(){
        return roomService.getAll().stream()
                .filter(room -> room.getUser() != null)
                .collect(Collectors.toList());
    }



}
