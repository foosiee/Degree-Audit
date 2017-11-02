package projectindex;
// Import packages;
import java.util.Scanner;
import java.util.HashMap;

public class ProjectIndex {
    public static void main(String[] args) {
        
        /* Create scanners, typically thought you didn't need two but with only 
        one it was causing a weird bug when asking for string input but having
        two separate scanners solved it */
        Scanner numInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        
        
        // Propmt user for number of classes they have taken;
        System.out.print("Enter number of classes you have taken: ");
        int classNum = numInput.nextInt();
        
        
        // Creates empty array to hold users class names;
        String[] userSet = new String[classNum];
        
        
        // Loop to enter names of classes up to previous input: classNum;
        for (int i = 0; i < classNum; i++){
                System.out.print("Enter the name of class " + (i+1) + " : ");
		userSet[i] = stringInput.nextLine();
        }
        
        
        // Creates empty hashmap to store all classes and credit hours in major;
        HashMap<String, Integer> classMap = new HashMap<String, Integer>();  
        
        
        // Keys and values of map(course and credit hours);
        classMap.put("Calc", 4);
        classMap.put("Trig", 4);
        classMap.put("CSET", 3);
        classMap.put("Stats", 3);
        classMap.put("Override", 129);
        
        
        // Creates an array of all keys;
        String[] classSet = classMap.keySet().toArray(new String[classMap.size()]);
        
        
        // initalize creditSum and creditHour;
        int creditSum = 0;
        int creditHours = 0;
        
        
        /* For loop to iterate over each index of userSet. But instead we do 
        that iteration in the hashMap.get method which returns the value of
        a key. We know the users inputed class will be in the hashmap if they
        inputted the class correctly. So we can use each index as a key put
        it into the method to unlock the value(credit hour) */
        for (int i = 0; i < userSet.length; i++){
            creditHours = classMap.get(userSet[i]);
            // Add creditHours to creditSum;
            creditSum += creditHours; 
            /*Remove key from hashMap so we can print out later what class
            they have yet to take*/
            classMap.remove(userSet[i]);
            
            
            // If creditHours is >= 128 break loop as they can graduate;
            if (creditHours >= 128){
                System.out.println("Congratulations! You can graduate!");
                break;
            }
            
        }
        
        if (creditHours < 128){
            // Prints creditSum;
            System.out.println(creditSum);
        
            // Creates new array from classMap with course they still need to take;
            String[] newClassSet = classMap.keySet().toArray(new String[classMap.size()]);
        
            // Prints out classes to take;
            for (int i = 0; i < newClassSet.length; i++){
                System.out.println(newClassSet[i]);
            }
        }
    } 
}
