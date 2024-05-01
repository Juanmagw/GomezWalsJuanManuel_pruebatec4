package com.juanmagw.PruebaTecnica4.repository;

import com.juanmagw.PruebaTecnica4.model.BookingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRoomRepository extends JpaRepository<BookingRoom, Long> {
}
