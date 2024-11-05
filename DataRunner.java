public class DataRunner {
  public static void main(String[] args) {


    UserStory user = new UserStory("countries.txt", "regionDevelopments.txt", "noDifficultiesPE.txt", "wDifficultiesPE.txt");

    UserStory alter = new UserStory();

    System.out.println(user.getCountries());

    System.out.println(user.findPointEstimate(false, "Samoa"));

    System.out.println(user.peUnderNum(50.5));

    System.out.println(user);

    
  }
}