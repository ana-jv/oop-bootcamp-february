package oop.parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManagerParkingAssistant {


    List<ParkingAssistant> assistantList;

    public ManagerParkingAssistant() {
        this.assistantList = new ArrayList<>();
    }

    public void hire(ParkingAssistant assistant) {
        assistantList.add(assistant);
    }

    public List<ParkingAssistant> getAssistantList() {
        return assistantList;
    }
}
