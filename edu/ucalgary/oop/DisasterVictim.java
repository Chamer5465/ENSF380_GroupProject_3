package edu.ucalgary.oop;

public class DisasterVictim {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private static int counter = 0;
    private final int ASSIGNED_SOCIAL_ID;
    private FamilyRelation[] familyConnections;
    private MedicalRecord[] medicalRecords;
    private Supply[] personalBelongings;
    private int familyConnectionsCount = 0;
    private int medicalRecordsCount = 0;
    private int personalBelongingsCount = 0;
    private final String ENTRY_DATE;
    private String gender;
    private String comments;

    public DisasterVictim(String firstName, String ENTRY_DATE) {
        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
        this.familyConnections = new FamilyRelation[10]; // Initial size
        this.medicalRecords = new MedicalRecord[10]; // Initial size
        this.personalBelongings = new Supply[10]; // Initial size
    }

    public DisasterVictim(String firstName, String ENTRY_DATE, String dateOfBirth) {
        this(firstName, ENTRY_DATE);
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
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
        FamilyRelation[] result = new FamilyRelation[familyConnectionsCount];
        System.arraycopy(familyConnections, 0, result, 0, familyConnectionsCount);
        return result;
    }

    public void setFamilyConnections(FamilyRelation[] connections) {
        this.familyConnections = new FamilyRelation[connections.length];
        this.familyConnectionsCount = connections.length;
        System.arraycopy(connections, 0, this.familyConnections, 0, connections.length);
    }

    public MedicalRecord[] getMedicalRecords() {
        MedicalRecord[] result = new MedicalRecord[medicalRecordsCount];
        System.arraycopy(medicalRecords, 0, result, 0, medicalRecordsCount);
        return result;
    }

    public void setMedicalRecords(MedicalRecord[] records) {
        this.medicalRecords = new MedicalRecord[records.length];
        this.medicalRecordsCount = records.length;
        System.arraycopy(records, 0, this.medicalRecords, 0, records.length);
    }

    public Supply[] getPersonalBelongings() {
        Supply[] result = new Supply[personalBelongingsCount];
        System.arraycopy(personalBelongings, 0, result, 0, personalBelongingsCount);
        return result;
    }

    public void setPersonalBelongings(Supply[] belongings) {
        this.personalBelongings = new Supply[belongings.length];
        this.personalBelongingsCount = belongings.length;
        System.arraycopy(belongings, 0, this.personalBelongings, 0, belongings.length);
    }

    public void addPersonalBelonging(Supply supply) {
        if (personalBelongingsCount == personalBelongings.length) {
            // Resize the array
            Supply[] newArray = new Supply[personalBelongings.length * 2];
            System.arraycopy(personalBelongings, 0, newArray, 0, personalBelongings.length);
            personalBelongings = newArray;
        }
        personalBelongings[personalBelongingsCount++] = supply;
    }

    public void removePersonalBelonging(Supply unwantedSupply) {
        for (int i = 0; i < personalBelongingsCount; i++) {
            if (personalBelongings[i].equals(unwantedSupply)) {
                // Shift elements to the left
                System.arraycopy(personalBelongings, i + 1, personalBelongings, i, personalBelongingsCount - i - 1);
                personalBelongingsCount--;
                break;
            }
        }
    }

    public void removeFamilyConnection(FamilyRelation exRelation) {
        for (int i = 0; i < familyConnectionsCount; i++) {
            if (familyConnections[i].equals(exRelation)) {
                // Shift elements to the left
                System.arraycopy(familyConnections, i + 1, familyConnections, i, familyConnectionsCount - i - 1);
                familyConnectionsCount--;
                break;
            }
        }
    }

    public void addFamilyConnection(FamilyRelation record) {
        if (familyConnectionsCount == familyConnections.length) {
            // Resize the array
            FamilyRelation[] newArray = new FamilyRelation[familyConnections.length * 2];
            System.arraycopy(familyConnections, 0, newArray, 0, familyConnections.length);
            familyConnections = newArray;
        }
        familyConnections[familyConnectionsCount++] = record;
    }

    public void addMedicalRecord(MedicalRecord record) {
        if (medicalRecordsCount == medicalRecords.length) {
            // Resize the array
            MedicalRecord[] newArray = new MedicalRecord[medicalRecords.length * 2];
            System.arraycopy(medicalRecords, 0, newArray, 0, medicalRecords.length);
            medicalRecords = newArray;
        }
        medicalRecords[medicalRecordsCount++] = record;
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getGender() {
        return gender;
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
}