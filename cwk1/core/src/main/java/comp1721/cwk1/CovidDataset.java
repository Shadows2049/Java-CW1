package comp1721.cwk1;

import java.io.FileNotFoundException;


import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

import java.time.LocalDate;

import java.io.File;

public class CovidDataset {

  




   private int mSize;
   public CaseRecord[] caseR;
   private CaseRecord[] newArray;
  
    CovidDataset(){
      caseR = new CaseRecord[10];
      

    }
    
    

  // TODO: Write stub for size()
      public int size(){

        int n=0;
        int i; 
        for(i=0; i < caseR.length; i++)
        {
        if(caseR[i]!=null) 
        {n++;}

        }
      
        return n;
      }

  // TODO: Write stub for getRecord()
      public CaseRecord getRecord(int index){
        
        if(index<0||index>=mSize){
          throw new DatasetException("error");
        }
       

        return caseR[index];
  
      

      }

  // TODO: Write stub for addRecord()
      public void addRecord(CaseRecord rec){
        
        //int i;
        System.out.println("length is: "+caseR.length);
        if(mSize==caseR.length){
          resize(2 * (caseR.length));
        }
          System.out.println("msize is:"+mSize);
        //i = 2;
        caseR[mSize] = rec;

        mSize++;
        
        
        //System.out.println("size is: "+size());
       
      }

  // TODO: Write stub for dailyCasesOn()
      public CaseRecord dailyCasesOn(LocalDate day){
        for(int i=0; i<mSize;++i)
        {
          if(caseR[i].getDate() == day)
          {return caseR[i];}
        }

        throw new DatasetException("No statics found");

      }

  // TODO: Write stub for readDailyCases()
      public void readDailyCases(String filename)throws FileNotFoundException
      { int gg;
        int j;
          //System.out.println("ok");
        for(j=0;j<size();++j)
        {caseR[j] = null;}
          //System.out.println("ok1");

        File file = new File(filename);

        Scanner scanner = new Scanner(file);

          //System.out.println("ok2");

        scanner.nextLine();
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            //System.out.println("stringlength is"+string.length());
            gg = 0;
            for (String retval : string.split(",")) {
                gg = gg + 1;
            }
            //System.out.println("gg is " + gg);
            if (gg < 4) {
                throw new DatasetException("gg");
            }



       Scanner input = new Scanner(string);

        input.useDelimiter(",");



        String date= input.next();
        //System.out.println("ok1");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //System.out.println("ok2");
        LocalDate ldt = LocalDate.parse(date,df);

        int staffCases=input.nextInt();
        //System.out.println("ok4");

        int studentCases=input.nextInt();



        int otherCases=input.nextInt();

        System.out.println("date is: "+ ldt);
        System.out.println("staffCases is: "+ staffCases);
        System.out.println("studentCases is: "+ studentCases);
        System.out.println("otherCases is: "+ otherCases);


        CaseRecord newCase = new CaseRecord(ldt,staffCases,studentCases,otherCases);
        //CovidDataset newCs = new CovidDataset();
        addRecord(newCase);
        //System.out.println("count is: "+ mSize);
        System.out.println("CaseRecord is: "+ caseR[mSize-1]);
        //System.out.println("Dataset is: "+ newCase);
        input.close();


        }
        scanner.close();
      }

  // TODO: Write stub for writeActiveCases()
     public void writeActiveCases(String filename)throws FileNotFoundException
      {

          //CovidDataset newCs = new CovidDataset();
          int i;
          int t;
          int count = size();
          //System.out.println("size is "+count);
          LocalDate dateSum;

          int staffCasesSum;
          int studentCasesSum;
          int otherCasesSum;



          if(count<10)
          {throw new DatasetException("not enough");}

          File file = new File(filename);

          PrintWriter output = new PrintWriter(file);
          output.print("Date");
          output.print(",");
          output.print("Staff");
          output.print(",");
          output.print("Students");
          output.print(",");
          output.print("Other");
          output.print("\n");
          for(i=0;i<count;++i){
              if((count-i)>=10){
                  staffCasesSum = 0;
                  studentCasesSum = 0;
                  otherCasesSum = 0;
                  for(t=0;t<10;++t)
                  {
                      staffCasesSum = staffCasesSum + caseR[i+t].getStaffCases();
                      studentCasesSum = studentCasesSum + caseR[i+t].getStudentCases();
                      otherCasesSum = otherCasesSum + caseR[i+t].getOtherCases();
                  }


                  dateSum = caseR[i+9].getDate();
                  DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                  String dateStr = dateSum.format(fmt);

                  output.print(dateStr);
                  output.print(",");
                  output.print(staffCasesSum);
                  output.print(",");
                  output.print(studentCasesSum);
                  output.print(",");
                  output.print(otherCasesSum);
                  output.print("\n");


              }


          }

          output.close();
      }




      private void resize(int newLength) {
 
        newArray = new CaseRecord[newLength];
        
        for (int i = 0; i < mSize; i++) {
    
            newArray[i] = caseR[i];
        }
        caseR = newArray;


    } 

    public static void main(String[] args)throws FileNotFoundException {
        CovidDataset newCs = new CovidDataset();
        newCs.readDailyCases("D:/coursework/cwk1/datafiles/testing/gg2.csv");

    }


    }

