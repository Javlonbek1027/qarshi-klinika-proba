package com.example.repository;

import com.example.entity.rooms.RoomForClients;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepositoryForClients extends CrudRepository<RoomForClients,Integer> {
}
