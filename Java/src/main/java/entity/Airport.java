package entity;

import Planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(militaryPlane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(militaryPlane);
            }
        }
        return bomberMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanesWithClassificationLevelHigherThanUnclassified() {
        List<ExperimentalPlane> experimentalPlanes = getExperimentalPlanes();
        List<ExperimentalPlane> experimentalPlanesWithClassificationLevelHigherThanUnclassified = new ArrayList<>();
        for(ExperimentalPlane experimentalPlane : experimentalPlanes) {
            if (experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED) {
                experimentalPlanesWithClassificationLevelHigherThanUnclassified.add(experimentalPlane);
            }
        }
        return experimentalPlanesWithClassificationLevelHigherThanUnclassified;
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
