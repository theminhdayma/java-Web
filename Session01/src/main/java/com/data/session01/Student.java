package com.data.session01;

public class Student {
    private String fullName;
    private String studentClass;
    private String vehicleType;
    private String licensePlate;

    // Constructor
    public Student(String fullName, String studentClass, String vehicleType, String licensePlate) {
        this.fullName = fullName;
        this.studentClass = studentClass;
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
