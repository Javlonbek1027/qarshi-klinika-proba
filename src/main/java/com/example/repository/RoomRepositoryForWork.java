package com.example.repository;

import com.example.entity.rooms.RoomForWorkers;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepositoryForWork extends CrudRepository<RoomForWorkers , Integer> {
}
