package com.pinto.receitas.shared.valueobjects;

public class TimeOfCooking implements ValueObject {

    private final String timeOfCooking;

    public TimeOfCooking(String timeOfCooking) {
        this.timeOfCooking = timeOfCooking;
    }

    @Override
    public String toString() {
        return this.timeOfCooking;
    }
}
