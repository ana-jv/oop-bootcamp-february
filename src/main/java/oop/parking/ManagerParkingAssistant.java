package oop.parking;

import java.util.ArrayList;
import java.util.List;

public class ManagerParkingAssistant {

    List<ParkingAssistant> assistantsList;

    public ManagerParkingAssistant() {
        this.assistantsList = new ArrayList<>();
    }

    public void hire(ParkingAssistant assistant) {
        assistantsList.add(assistant);
    }

    public List<ParkingAssistant> getAssistantsList() {
        return assistantsList;
    }
}
