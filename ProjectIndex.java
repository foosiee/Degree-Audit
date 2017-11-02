package projectindex;

// Import packages;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class ProjectIndex {
    public static void main(String[] args) {
        
        // Creates empty hashmap to store all classes and credit hours in major;
        HashMap<String, Integer> classMap = new HashMap<String, Integer>();  
        
        
        // Keys and values of map ONLY CORE CLASSES CURRENTLY(course and credit hours);
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
        classMap.put("Override",129);
        
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
        // initalize creditSum and creditHour;
        int creditSum = 0;
        int creditHours = 0;
        
        
        // Loop to enter names of classes up to previous input: classNum;
        for (int i = 0; i < classNum; i++){
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
            
            
                // If creditHours is >= 128 break loop as they can graduate;
                if (creditHours >= 128){
                    System.out.println("Congratulations! You can graduate!");
                    break;
            }
        }
          
        // White space;
        System.out.println(" ");
        
        // if user hasn't taken 128 hours execute code;
        if (creditHours < 128){
            
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
            for (int i = 0; i < newClassSet.length; i++){
                System.out.print(newClassSet[i] + ", ");
                counter++;
                
                if (counter % 4 == 0){
                    System.out.println(" ");
                }
            }
            System.out.println(" ");
        }
    } 
}
