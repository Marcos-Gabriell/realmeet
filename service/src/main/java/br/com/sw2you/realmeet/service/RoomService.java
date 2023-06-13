package br.com.sw2you.realmeet.service;

import br.com.sw2you.realmeet.domain.entity.Room;
import br.com.sw2you.realmeet.repository.RoomRepository;
import br.com.sw2you.realmeet.exception.RoomNotFoundException;
import java.util.Objects; // Importe a classe Objects aqui
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room findById(Long id) {
        Objects.requireNonNull(id); // Correção na chamada do método
        return roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
    }
}
