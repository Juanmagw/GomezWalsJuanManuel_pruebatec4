package com.juanmagw.PruebaTecnica4.repository;

import com.juanmagw.PruebaTecnica4.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
