package oop.parking;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ManagerParkingAssistantTest {

    private NotificationSender notificationSender;


    @BeforeMethod
    public void setUp() {
        notificationSender = Mockito.mock(NotificationSender.class);
    }

    @Test
    public void itShouldHireOneAssistantWithAParkingLot() {
        ManagerParkingAssistant manager = new ManagerParkingAssistant();
        ParkingLot parkingLot = new ParkingLot(1, 10, 2, notificationSender);
        ParkingAssistant assistant = new ParkingAssistant(List.of(parkingLot));

        manager.hire(assistant);

        assertEquals(manager.getAssistantList().size(), 1);
    }
}