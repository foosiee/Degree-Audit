package projectindex;

// Import packages;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;
import java.util.InputMismatchException;

public class ProjectIndex {
    public static void main(String[] args) {
        
        // Creates empty hashmap to store all classes and credit hours in major;
        HashMap<String, Integer> classMap = new HashMap<>();  
        
        
        // Keys and values of map (course and credit hours);
        classMap.put("CHEM-1230 General Chemistry I",4);
        classMap.put("CSET-2200 PC & Industrial Networks",4);
        classMap.put("EET-1010 Resistive Circuits",4);
        classMap.put("EET-1020 Reactive Circuits",4);
        classMap.put("EET-1410 Electrical Drafting",3);
        classMap.put("EET-2010 Electronic Principles",4);
        classMap.put("EET-2020 Electronic Device Applications",4);
        classMap.put("EET-2210 Digital Logic Fundamentals",4);
        classMap.put("EET-2410 Mechatronics I",4);
        classMap.put("EET-3150 C Programming",4);
        classMap.put("EET-3250 Network Analysis",3);
        classMap.put("EET-3350 Digital Systems Design",4);
        classMap.put("EET-4150 Analog Systems Design",4);
        classMap.put("EET-4250 Microcomputer Architecture",4);
        classMap.put("EET-4350 Electric Power Systems",4);
        classMap.put("EET-4450 Auto Control Systems",4);
        classMap.put("EET-4550 Mechatronics II",4);
        classMap.put("ENGT-1000 Intro to Eng. Tech",1);
        classMap.put("ENGT-3010 Applied Statistics and DOE",4);
        classMap.put("ENGT-3020 Applied Eng. Mathematics",3);
        classMap.put("ENGT-4050 Sr Technology Capstone",3);
        classMap.put("ENGL-1110 College Composition I",3);
        classMap.put("ENGL-2950 Science & Tech. Report Writing",3);
        classMap.put("MATH-1330 Trigonometry",3);
        classMap.put("MATH-2450 Technical Calculus I",4);
        classMap.put("MATH-2460 Technical Calculus II",4);
        classMap.put("MET-2100 Engr. Mechanics: Statics",3);
        classMap.put("PHYS-2010 Tech Physics I",5);
        classMap.put("PHYS-2020 Tech Physics II",5);
        classMap.put("SocSc/Hum/Multicultural Elective I",3);
        classMap.put("SocSc/Hum/Multicultural Elective II",3);
        classMap.put("SocSc/Hum/Multicultural Elective III",3);
        classMap.put("Communications Elective",3);
        classMap.put("Professional Development Elective",3);
        // Override to test graduation checker;
        classMap.put("Override",129);
        
        /* Create scanners, typically thought you didn't need two but with only 
        one it was causing a weird bug when asking for string input but having
        two separate scanners solved it */
        Scanner numInput = new Scanner(System.in);
        Scanner stringInput = new Scanner(System.in);
        
        // Intialize classNum;
        int classNum = 0;
        while(true){
            try {
                // Propmt user for number of classes they have taken;
                System.out.print("Enter number of classes you have taken: ");
                classNum = numInput.nextInt();
                break;
            // Catches inputs that are not numbers;    
            } catch (InputMismatchException e){
                System.out.println("Please enter a number.");
                // Clears buffers memory;
                numInput.next();
            }
        }
        
        // Creates empty array to hold users class names;
        String[] userSet = new String[classNum];
        // initalize creditSum and creditHour;
        int creditSum = 0;
        int creditHours = 0;
        
        
        // Loop to enter names of classes up to previous input: classNum;
        for (int i = 0; i < classNum; i++){
            
            // Exception handling, try statement to execute loop;
            try {
                System.out.print("Enter the name of class " + (i+1) + " : ");
		userSet[i] = stringInput.nextLine();
                
            /* This part of loop is to iterate over each index of userSet. But instead we do 
            that iteration in the hashMap.get method which returns the value of
            a key. We know the users inputed class will be in the hashmap if they
            inputted the class correctly. So we can use each index as a key put
            it into the method to unlock the value(credit hour) */
                
                creditHours = classMap.get(userSet[i]);
                // Add creditHours to creditSum;
                creditSum += creditHours; 
                /*Remove key from hashMap so we can print out later what class
                they have yet to take*/
                classMap.remove(userSet[i]);
                
            // Exception if user doesn't enter a class in hashmap;    
            } catch (NullPointerException e){
                System.out.println("Not a valid class. Please try again.");
                i -= 1;
            }        
            
            
                // If creditHours is >= 128 break loop as they can graduate;
                if (creditHours >= 128){
                    System.out.println("Congratulations! You can graduate!");
                    break;
            }
        }
          
        // if user hasn't taken 128 hours execute code;
        if (creditHours < 128){
            
            // White space;
            System.out.println(" ");
            
            // Remove override key from map;
            classMap.remove("Override");
            
            // Prints how many credit hours user has taken;
            System.out.println("You have taken " + creditSum + " credit hours");
            
            // Calculates remaining credit hours and prints;
            int creditRem = 128 - creditSum;
            System.out.println("You have " + creditRem + " credit hours remaining");
            
            // White Space;
            System.out.println(" ");
            
            // Creates new array from classMap with course they still need to take;
            String[] newClassSet = classMap.keySet().toArray(new String[classMap.size()]);
            Arrays.sort(newClassSet);
        
            // Prints out classes to take;
            System.out.println("You have " + newClassSet.length + " classes left");
            System.out.print("Take these classes: ");
            
            int counter = 0;
            for (String className : newClassSet) {
                // If counter reachs last index in array put and between last two items;
                if (counter == newClassSet.length - 1) {
                    System.out.print("and " + className + "\n");
                    counter++;
                } else {
                    System.out.print(className + ", ");
                    counter++;
                    // Put 4 classes on each line;
                    if (counter % 4 == 0){
                        System.out.println(" ");
                    }
                }
            }
        } 
    }
}