package comp1721.cwk1;

import java.time.LocalDate;

public class CaseRecord {

  // TODO: Write stub for constructor
 private LocalDate date;
 private int staffCases;
 private int studentCases;
 private int otherCases;
 private int totalCases;
 private String toString;

  CaseRecord(LocalDate datein, int staffCasesin,int studentCasesin, int otherCasesin){
    if(staffCasesin<0||studentCasesin<0||otherCasesin<0)
  {throw new DatasetException("Invalid input");}
      date = datein;
      staffCases = staffCasesin;
      studentCases = studentCasesin;
      otherCases = otherCasesin;
  }


  // TODO: Write stubs for four getter methods
    public LocalDate getDate(){
     return this.date;

    }

    public int getStaffCases(){
      return this.staffCases;
    }

    public int getStudentCases(){
      return this.studentCases;
    }

    public int getOtherCases(){
      return this.otherCases;
    }
  // TODO: Write stub for totalCases()

    public int totalCases(){
      totalCases = staffCases + studentCases + otherCases;
      return this.totalCases;
    }
  
  // TODO: Write stub for toString()

    public String toString(){
      toString = date + ": " + this.staffCases + " staff, " + this.studentCases + " students, " + this.otherCases + " other";

      return this.toString;
    }

 
}
