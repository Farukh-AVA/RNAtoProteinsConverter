/**
 * @author Farukh Khassan Khojayev.
 * @since 12-10-2019
 * @vesion 1.0
 * 
 * This program is converting RNA into the Proteins. First program read the RNA
 * from RNASequenceData.txt and placing it into the  RNA string. Then, the
 * program split the string into the characters and scan for the UGA. If the 
 * program found UGA, scanner will continue to scan string by three characters
 * at a time and convert this characters into Amino acids by calling the method 
 * codonLookup. If the program scan UAG, UGA, UAA, the program will stop to scan
 * and start to scan for new UGA, until the end of the string. 
 * The program also using methods to run the program. Which I will describe 
 * on the top of all methods.
 * 
 * 
 */ 
package homework6;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;


public class Homework6 {

    public static void main(String[] args) throws Exception {
        final int MAXNUMBER=100;
        String [] codon  =new String [MAXNUMBER];
        String [] aminoAcid =new String [MAXNUMBER];
        String  RNA;
        Scanner sc= new Scanner(new File("RNASequenceData.txt"));
        PrintStream ps= new PrintStream("Homework6.txt"); 
        int count = readRNACodonTable(codon,aminoAcid);
        String aminoAcids = "",codon2;
        int i=0;
        int startIndex = 0, protein=0;
        RNA = sc.next();
         while(RNA.length() > i+2){
            codon2 =  RNA.charAt(i)+""+RNA.charAt(i+1)+""+RNA.charAt(i+2);
            if(codon2.equals("AUG")){
                protein++;
                ps.print("Protein# "+protein+" ");
                startIndex = i + 3;
           
                for ( i = startIndex; ; i += 3) {  
                String codon1 = RNA.substring(i, i + 3);
                
                    if (codon1.equals("UGA") || codon1.equals("UAA") 
                       || codon1.equals("UAG")) {
                       ps.println(aminoAcids);
                       aminoAcids="";
                       break;
                    }else{
                        
                    aminoAcids += codonLookup(codon,aminoAcid,count, codon1);
                    }
               }
            }
            i++;     
        }
    }
//This method will read the RNA codon table and place it into the array.
    public static int readRNACodonTable(String [] x, String [] y) 
            throws Exception{
        Scanner sc2= new Scanner(new File("Table2.txt"));
        int i=0;
        while(sc2.hasNext()){
            x[i]= sc2.next();
            y[i]=sc2.next();
            i++;
            
        }
        return i;
    }
    //This method will sort the array into codon order, by using bunnle sort.
    public static void sort(String [] x, String [] y, int n){
        String hold1, hold2;
        int pass, j;
        boolean switched=true;
        for(pass=0; pass<n-1 && switched; pass++ ){
            switched=false;
            for(j=0; j<n-pass-1; j++){
                if(x[j].compareTo(x[j+1])>0){
                    switched=true;
                    hold1=x[j];
                    x[j]=x[j+1];
                    x[j+1]=hold1;
                    hold2=y[j];
                    y[j]=y[j+1];
                    y[j+1]=hold2;
                }
            }
        }
    }
  //This method will receivet thre letters of codon and will return Amino Acid.   
    public static String codonLookup(String [] x, String [] y, int n,
            String codon){
        for(int i=0; i<n; i++){
            if(x[i].equals(codon)){
                return y[i];
            }
        }
        return "notFound";
    }
//This method will recevi codon and if it exist return true, otherwise false  
    public static boolean isValidRNA(String [] x, String [] y, int n, 
            String codon){
        for(int i=0; i<n; i++){
            if(x[i].equals(codon)){
                return true;
            }
        }
        return false;
    }
    
}    