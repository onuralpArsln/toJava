package com;

public class Patient {
    private String patientName;
    private String patientID;
    private Doctor patientDoctor;
    private int entryDate;
    private int numberOfPatients = 0;

public Patient(String patName, String patID, int patEntryDate){
this.patientName = patName;
this.patientID = patID;
this.entryDate = patEntryDate;
numberOfPatients++;
}

public Patient(Patient patient){
    this.patientName = patient.patientName;
    this.patientID = patient.patientID;
    this.entryDate = patient.entryDate;
}

public String getpatientName(){
    return patientName;
}

public void setpatientName(String patName){
    this.patientName = patName;
}

public String getpatientID(){
    return patientID;
}

public void setpatientID(String patID){
    this.patientID = patID;
}

public Doctor getpatientDoctor(){
    return patientDoctor;
}

public void setpatientdoctor(Doctor patdoctor){
    this.patientDoctor = patdoctor;
}

public int getentryDate(){
    return entryDate;
}

public void setentryDate(int patEntryDate){
    this.entryDate = patEntryDate;
}

public String toString(){
return "Patient name: " + patientName + " Patient ID: " + patientID + " Patient's doctor: " + patientDoctor + " Patient's entry date: " + entryDate;
}
}