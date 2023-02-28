package com.example.service;

import com.example.dto.RoomForClientDto;
import com.example.entity.rooms.RoomForClients;
import com.example.repository.RoomRepositoryForClients;
import com.example.repository.RoomRepositoryForWork;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class RoomService {
    @Autowired
    private RoomRepositoryForWork roomRepositoryForWork;

    @Autowired
    private RoomRepositoryForClients roomRepositoryForClients;

    // klientlar uchun
    public List<RoomForClientDto> getAllRoomSForClient () {
        List<RoomForClientDto> returnObject = new LinkedList<>();
        Iterable<RoomForClients> rooms = roomRepositoryForClients.findAll();
        List<RoomForClients> roomForClients = (List<RoomForClients>) rooms;
        for (RoomForClients roomForClient : roomForClients) {
            returnObject.add(toDto(roomForClient));
        }
        return returnObject;
    }

    public RoomForClientDto toDto(RoomForClients room){
        return new RoomForClientDto(room.getNumber(),
                room.getPart(),
                room.getCapacity(),
                room.getRoomStatus(),
                room.getDefinition(),
                room.getLike(),
                room.getDisLike(),
                room.getResponsible());

    }
    public RoomForClients toEntity(RoomForClientDto room){
        return new RoomForClients(room.getNumber(),
                room.getPart(),
                room.getCapacity(),
                room.getRoomStatus(),
                room.getDefinition(),
                room.getLike(),
                room.getDisLike(),
                room.getResponsible());

    }

    //
}
