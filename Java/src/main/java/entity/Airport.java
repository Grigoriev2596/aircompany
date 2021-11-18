package entity;

import entity.planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import entity.planes.MilitaryPlane;
import entity.planes.PassengerPlane;
import entity.planes.Plane;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        return planes.stream()
                .filter(PassengerPlane.class::isInstance)
                .map(PassengerPlane.class::cast)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return planes.stream().filter(MilitaryPlane.class::isInstance)
                .map(MilitaryPlane.class::cast)
                .collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        return Collections.max(getPassengerPlanes(), Comparator.comparing(PassengerPlane::getPassengersCapacity));
    }

    public List<MilitaryPlane> getMilitaryPlanesByType(MilitaryType type) {
        return getMilitaryPlanes().stream()
                .filter(militaryPlane -> militaryPlane.getType().equals(type))
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return planes.stream()
                .filter(ExperimentalPlane.class::isInstance)
                .map(ExperimentalPlane.class::cast)
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> getExperimentalPlanesWithParticularLevel(ClassificationLevel level) {
        return getExperimentalPlanes().stream()
                .filter(plane -> plane.getClassificationLevel().equals(level))
                .collect(Collectors.toList());
    }

    public void sortPlanesByMaxFlightDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    }

    public void sortPlanesByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
    }

    public void sortPlanesByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }

    @Override
    public String toString() {
        return "entity.Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }
}
