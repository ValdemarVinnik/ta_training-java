package com.epam.training.student_Uladzimir_Vinnik.clean_code.aircompany.Planes;

import java.util.Objects;

public class MyPlane  extends Plane {

    private int maximumHeight;

    public MyPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int maximumHeight) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.maximumHeight = maximumHeight;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", maximum height=" + maximumHeight +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyPlane)) return false;
        if (!super.equals(o)) return false;
        MyPlane myPlane = (MyPlane) o;
        return maximumHeight == myPlane.maximumHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maximumHeight);
    }
}
