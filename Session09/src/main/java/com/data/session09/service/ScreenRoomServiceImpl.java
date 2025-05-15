package com.data.session09.service;
import com.data.session09.dao.ScreenRoomDAO;
import com.data.session09.model.ScreenRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenRoomServiceImpl implements ScreenRoomService {

    @Autowired
    private ScreenRoomDAO screenRoomDAO;

    @Override
    public List<ScreenRoom> getAllScreenRooms() {
        return screenRoomDAO.getAllScreenRooms();
    }
}
