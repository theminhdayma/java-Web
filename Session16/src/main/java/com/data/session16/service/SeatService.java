package com.data.session16.service;

public interface SeatService {
    boolean addSeat(int tripId, int seatNumber, String seatType);
    boolean updateSeat(int tripId, int seatNumber, String seatType);
    boolean deleteSeat(int tripId, int seatNumber);
    boolean isSeatAvailable(int tripId, int seatNumber);
    String getSeatType(int tripId, int seatNumber);
}
