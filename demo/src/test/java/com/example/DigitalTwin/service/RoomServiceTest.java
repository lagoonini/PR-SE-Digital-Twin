package com.example.DigitalTwin.service;

import com.example.DigitalTwin.model.Room;
import com.example.DigitalTwin.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomService roomService;

    @Test
    public void testSaveOrUpdateRoom() {
        Room room = new Room("Conference Room", 100.0, 1, 2, 5, 2);
        when(roomRepository.save(any(Room.class))).thenReturn(room);

        Room savedRoom = roomService.saveOrUpdateRoom(room);

        assertNotNull(savedRoom);
        assertEquals("Conference Room", savedRoom.getName());
        verify(roomRepository).save(room);
    }

    @Test
    public void testGetRoomById() {
        Optional<Room> room = Optional.of(new Room("Conference Room", 100.0, 1, 2, 5, 2));
        when(roomRepository.findById(1L)).thenReturn(room);

        Optional<Room> foundRoom = roomService.getRoomById(1L);

        assertTrue(foundRoom.isPresent());
        assertEquals("Conference Room", foundRoom.get().getName());
        verify(roomRepository).findById(1L);
    }
}
