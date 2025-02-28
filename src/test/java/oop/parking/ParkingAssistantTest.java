package oop.parking;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

public class ParkingAssistantTest {

    private Car myCar;
    private NotificationSender notificationSender;


    @BeforeMethod
    public void setUp() {
        myCar = Mockito.mock(Car.class);
        notificationSender = Mockito.mock(NotificationSender.class);
    }

    @Test
    public void itShouldParkACarInAParkingLotWhenOccupationIsLessThan80Percent() {

        final List<ParkingLot> parkingLots = List.of(new ParkingLot(1, 10, 5, notificationSender));
        var assistant = new ParkingAssistant(parkingLots);

        assistant.park(myCar);
        verify(myCar).park();

    }

    @Test
    public void itShouldNotParkACarParkingIsMoreThan80PercentFull() {
        final List<ParkingLot> parkingLots = List.of(new ParkingLot(1, 10, 8, notificationSender));

        var assistant = new ParkingAssistant(parkingLots);

        assistant.park(myCar);

        verify(myCar, times(0)).park();
    }

    @Test
    public void itShouldParkACarInTheSecondAParkingLot() {

        final List<ParkingLot> parkingLots = List.of(new ParkingLot(1,
                6,
                5,
                notificationSender),
            new ParkingLot(2,
                10,
                0,
                notificationSender));
        var assistant = new ParkingAssistant(parkingLots);

        final var parkingLotId = assistant.park(myCar);

        assertEquals(parkingLotId, 2);
        verify(myCar).park();

    }

    @Test
    public void itShouldParkLargeCarsInParkingLotLessOccupied() {

        final List<ParkingLot> parkingLots = List.of(new ParkingLot(1,
                        10,
                        5,
                        notificationSender),
                new ParkingLot(2,
                        10,
                        2,
                        notificationSender));
        var assistant = new ParkingAssistant(parkingLots);
        var car = new Car("large");
        final var parkingLotId = assistant.park(car);

        assertEquals(parkingLotId, 2);
    }

    @Test
    public void itShouldParkHandicappedCarInTheFirstHandicappedParkingLot() {
        final List<ParkingLot> parkingLots = List.of(new ParkingLot(1,
                        10,
                        5,
                        notificationSender),
                new ParkingLot(2,
                        10,
                        2,
                        notificationSender,
                        true));
        var assistant = new ParkingAssistant(parkingLots);
        var car = new Car("handicapped");
        final var parkingLotId = assistant.park(car);

        assertEquals(parkingLotId, 2);
    }
}
