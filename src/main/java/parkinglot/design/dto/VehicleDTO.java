package parkinglot.design.dto;

/**
 * Created by hareesh.pammi on 6/19/19.
 */
public class VehicleDTO {
    private String registrationNumber;

    private String colour;

    public VehicleDTO(String registrationNumber, String colour) {
        this.registrationNumber = registrationNumber;
        this.colour = colour;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
