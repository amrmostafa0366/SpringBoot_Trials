package com.butcher.app.rest.Repo;

import com.butcher.app.rest.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
