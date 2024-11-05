public class UserStory {

  private String[] co;
  private String[] rDevs;
  private double[] noDiffs;
  private double[] wDiffs;

  /*
  *Paramaterized construction, creates user story  object with arrays
  */
  public UserStory(String coFile, String rDevsFile, String noDiffsFile, String wDiffsFile){
    co = FileReader.toStringArray(coFile);
    rDevs = FileReader.toStringArray(rDevsFile);
    noDiffs = FileReader.toDoubleArray(noDiffsFile);
    wDiffs = FileReader.toDoubleArray(wDiffsFile);
  }

  /*
  *non-paramaterized constructor
  */
  public UserStory(){
    co = null;
    rDevs = null;
    noDiffs = null;
    wDiffs = null;
  }


  
  /*
  *accessor method for country
  */
  public String getCountries(){
    String coString = "";
      for ( String countryName : co){
      coString+=countryName + "\n";
      }
    return coString;

  } 

  /*
  * finds the point estimate percentage depending on country name and if students have functional difficulties
  */
  public String findPointEstimate(boolean difficulties, String coName){
     int coIndex = 0;
       for (int i = 0; i < co.length; i++){
         if (co[i] == coName){
         coIndex = i;
       }
     }
     if (difficulties == true){
       return wDiffs[coIndex] + "%";
     } else{
       return noDiffs[coIndex] + "%";
     }
   }

  /*
  * returns all countries and with difficulties point estimates 
  *if the point estimate is less than number provided
  */
  public String peUnderNum(double num){
    String result = "\nCountries with Point Estimates greater than " + num + "%:\n";
    for (int i = 0; i < wDiffs.length; i++) {
      if(wDiffs[i]<num){
      result += co[i] + ": " + wDiffs[i] + "%, ";
    }      
    }
    return result;
  }

  /*
  *toString - prints all countries and both percentages
  */
public String toString(){
  String total = "\n\nPercentage of Students in Underdeveloped Countries with Reading Profficiency\n\nFormat:\nCountry - No Functional Difficulties Point Estimate, With Functional Difficulties Point Estimate \n\n";
  for (int i =0; i<co.length; i++){
    total += co[i] + "(" + rDevs[i] + ") - " + noDiffs[i] + "%, " + wDiffs[i] + "%\n";
  }
  return total + "\n**Any Point Estimates of 0.0% Are Unknown**";
}


  
}