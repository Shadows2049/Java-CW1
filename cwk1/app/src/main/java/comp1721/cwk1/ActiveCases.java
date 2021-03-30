package comp1721.cwk1;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ActiveCases {
    public static void main(String[] args){
        String loadFile;
        String saveFile;

        System.out.println("Provide the loadfile");
        Scanner sc = new Scanner(System.in);
        loadFile = sc.next();

        if(loadFile==null){
            System.out.println("Error");
        }


        System.out.println("Provide the savefile");
        saveFile = sc.next();

        if(saveFile==null){
            System.out.println("Error");
        }

        sc.close();



        CovidDataset newCs = new CovidDataset();
        try{newCs.readDailyCases(loadFile);}
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
            //newCs.readDailyCases(loadFile); //"D:/coursework/cwk1/datafiles/2020-daily.csv")
        //newCs.readDailyCases("../datafiles/2020-daily.csv");
        //System.out.println("Dataset is: ");
        //newCs.writeActiveCases("../datafiles/2020-active.csv");
        try{newCs.writeActiveCases(saveFile);}
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println("Number of data in CovidDataset are: "+newCs.size());

    }
}
