package Policy;

import java.io.Serializable;
import java.util.Stack;

public class Vehicle implements Serializable {
    public static String plateNb;
    int modelYear;
    String manufacturer;
    int estimatedValue;
    String carDamage;

    public Vehicle(String plateNb, int modelYear, String manufacturer, int estimatedValue, String carDamage) {
        this.plateNb = plateNb;
        this.modelYear = modelYear;
        this.manufacturer = manufacturer;
        this.estimatedValue = estimatedValue;
        this.carDamage = carDamage;
    }



    public String getPlateNb() {
        return plateNb;
    }

    public void setPlateNb(String plateNb) {
        this.plateNb = plateNb;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(int estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public String getCarDamage() {
        return carDamage;
    }

    public void setCarDamage(String carDamage) {
        this.carDamage = carDamage;
    }

    @Override
    public String toString() {
        return  "plateNb=" + plateNb +
                "\nmodelYear=" + modelYear +
                "\nmanufacturer='" + manufacturer +
                "\nestimatedValue=" + estimatedValue +
                "\ncarDamage=" + carDamage;
    }
}