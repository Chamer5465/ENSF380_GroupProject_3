package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisasterVictim {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private static int counter = 0;
    private final int ASSIGNED_SOCIAL_ID;
    private List<FamilyRelation> familyConnections;
    private List<MedicalRecord> medicalRecords;
    private List<Supply> personalBelongings;
    private final String ENTRY_DATE;
    private String gender;
    private String comments;

    public DisasterVictim(String firstName, String ENTRY_DATE) {
        if(!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format.");
        }
        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
        this.familyConnections = new ArrayList<FamilyRelation>();
        this.medicalRecords = new ArrayList<MedicalRecord>();
        this.personalBelongings = new ArrayList<Supply>();
    }

    public DisasterVictim(String firstName, String ENTRY_DATE, String dateOfBirth) {
        if(!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format.");
        } else if(convertDateStringToInt(dateOfBirth) > convertDateStringToInt(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid entry date.");
        }
        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;
        this.setDateOfBirth(dateOfBirth);
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

    public FamilyRelation[] getFamilyConnections() {
        return this.familyConnections.toArray(new FamilyRelation[0]);
    }

    public void setFamilyConnections(FamilyRelation[] connections) {
        this.familyConnections = new ArrayList<FamilyRelation>(Arrays.asList(connections));
    }

    public MedicalRecord[] getMedicalRecords() {
        return this.medicalRecords.toArray(new MedicalRecord[0]);
    }

    public void setMedicalRecords(MedicalRecord[] records) {
        this.medicalRecords = new ArrayList<MedicalRecord>(Arrays.asList(records));
    }

    public Supply[] getPersonalBelongings() {
        return this.personalBelongings.toArray(new Supply[0]);
    }

    public void setPersonalBelongings(Supply[] belongings) {
        this.personalBelongings = new ArrayList<Supply>(Arrays.asList(belongings));
    }

    public void addPersonalBelonging(Supply supply) {
        this.personalBelongings.add(supply);
    }

    public void removePersonalBelonging(Supply unwantedSupply) {
        this.personalBelongings.remove(unwantedSupply);
    }

    public void removeFamilyConnection(FamilyRelation exRelation) {
        this.familyConnections.remove(exRelation);
    }

    public void addFamilyConnection(FamilyRelation record) {
        this.familyConnections.add(record);
    }

    public void addMedicalRecord(MedicalRecord record) {
        this.medicalRecords.add(record);
    }

    public String getEntryDate() {
        return this.ENTRY_DATE;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender.toLowerCase();
    }

    private int generateSocialID() {
        return ++counter;
    }

    private boolean isValidDateFormat(String date) {
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }
    
    private int convertDateStringToInt(String dateStr) {
        String convertedString = dateStr.replaceAll("-", "");
        return Integer.valueOf(convertedString);
    }
}