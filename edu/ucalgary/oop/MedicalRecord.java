package edu.ucalgary.oop;

import java.util.regex.Pattern;

public class MedicalRecord {
    Location location;
    String treatmentDetails;
    String dateOfTreatment;

    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) {
        this.location = location;
        this.treatmentDetails = treatmentDetails;
        this.dateOfTreatment = dateOfTreatment;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTreatmentDetails() {
        return this.treatmentDetails;
    }

    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    public String getDateOfTreatment() {
        return this.dateOfTreatment;
    }

    public void setDateOfTreatment(String dateOfTreatment) {
        this.dateOfTreatment = dateOfTreatment;
    }
    private boolean isValidDateFormat(String date) {
        Pattern datePattern = Pattern.compile("^\\d\\d/\\d\\d/\\d\\d\\d\\d$");
        Matcher dateMatcher = datePattern.matcher(date);
        return dateMatcher.find();

    }
}
