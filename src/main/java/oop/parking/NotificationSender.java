package oop.parking;

public class NotificationSender {
    public void notifyOverUsed(int parkingLotId) {
        System.out.println(String.format("ParkingLot %s is over 75% capacity", parkingLotId));
    }

    public void notifyMisused(int parkingLotId) {
    }
}
