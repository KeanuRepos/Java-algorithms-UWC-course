/*
CSC212: Group assignment solution to Bus services problem
Group name: TrenTech
Date: 23 October 2020
*/
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class trenTech {

    public int cap = 100;       // maximum capacity of the busses
    public int[][] matrix;      // matrix used to evaluate which way way of filling the busses would be optimal
    public static List<group> Groups; // using Lists/arraylist of group objects, to simplify the process of iteration
                                      // and evaluation

    // constructor to initialize arraylist and fill it with the different group
    // objects
    public trenTech( String[] groupnames, int[] amountmembers, int[] weight) {
        this.cap = 100;
        this.Groups = new ArrayList<group>(groupnames.length);
        for (int x = 0; x < groupnames.length; x++) {
            Groups.add(new group(groupnames[x], amountmembers[x], weight[x]));
        }
    }

    // constructor for group objects
    public class group {

        private String name;
        private int members;
        private int weight;
        private int profits;

        // constructor for initializing the group object, adding all relevant info, as
        // well as a field for profits to be used later on
        public group(String n, int w, int m) {
            this.name = n;
            this.members = m;
            this.weight = w;
            if (this.members > 100) { // services only charge after the first 100kg, so just a condition to ensure
                                      // there are no non-positive profits
                this.profits = (members - 100) * 5;
            } else {
                this.profits = 0;
            }
        }

        // gets/accessor methods
        public String getName() {return name;}

        public int getMembers() {return members;}

        public int getWeight() {return weight;}

        public int getProfits() {return profits;}

        // basic to string for neater printing, taking into consideration the switching
        // of members and their weights!!!!!
        public String toString() {
            return "Group " + name + ": " + weight + " members, with a weight of " + members+"kg.";
        }

    }

    // method for determining the optimal way to pack/organize the busses
    public int knapsack() {

        this.matrix = new int[Groups.size() + 1][cap + 1];

        for (int x = 0; x <= Groups.size(); x++) { // iterates the amount of times so that each group is covered
            for (int y = 0; y <= cap; y++) { // iterates until the maximum capacity of the busses are reached
                if (x == 0 || y == 0) {
                    matrix[x][y] = 0;
                } else if (Groups.get(x - 1).weight <= y) { // condition to determine max 
                    matrix[x][y] = Math.max(Groups.get(x - 1).members + matrix[x - 1][y - Groups.get(x - 1).weight],
                            matrix[x - 1][y]);
                } else {
                    matrix[x][y] = matrix[x - 1][y];
                }
            }
        }

        return matrix[Groups.size()][cap]; // returns the optimal/maximized values for the weighting
    }

    // method used to remove schools from the list after being considered
    public void removeGroups() {
        int totalProf=0;            // variables for tracking the total amounts
        int totalWeight = 0;

        for (int x = 1; x <= 5; x++) {      // only iterating 5 times, because there are only 5 busses
            String removedGroups = "";      // variable used to accumulate all the schools being considered per iteration
            int index = 0;                  // variable used to remember the index of schools to be removed
            int removeable[] = new int[Groups.size()];      //  list used to store the groups to be removed

            int finalProf = 0;              // variable used to accumulate all the profits
            int finalWeight = 0;            // variable used to accumulate all the weights


            this.knapsack();                // calls knapsack for each given matrices, remembering that the matrices changes after each iteration

            int w = cap;                    // use this variable in order to be able to iterate 

            for (int y = matrix.length - 1; y > 0; y--) {
                int matSingle = this.matrix[y][w];
                if (matSingle != this.matrix[y - 1][w]) {
                    finalWeight += Groups.get(y - 1).members;       // remembering that the weight and values are switched for this problem
                    removedGroups += Groups.get(y - 1).name + " ";
                    finalProf += Groups.get(y - 1).profits;


                    w -= Groups.get(y - 1).weight;
                    removeable[index++] = y - 1;        // remembers the index of the group to be removed
                }
            }
            totalProf += finalProf;
            totalWeight += finalWeight;

            System.out.println("Bus " + x + " has a weight of: " + finalWeight + "kg and thus a profit of: R"
                    + finalProf + "\nThe included groups on bus " + x + " are: " + removedGroups);
            
            finalWeight = 0;        // clear/reset these variables, so that they are accurate for next iterations
            removedGroups = "";
            finalProf = 0;

            for (int z = 0; z < index; z++) {       // loop to iterate 5 times to remove the schools
                Groups.remove(removeable[z]);
            }
        }

        System.out.println("\nThe total profit made by the 5 busses is :R"+totalProf+", carrying a total of "+totalWeight+"kg.");

    }

    public static void main(String args[]) {

        String groups[] = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };
        int amountmembers[] = new int[] { 48, 30, 42, 36, 36, 48, 42, 42, 36, 24, 30, 30, 42, 36, 36 };
        int weight[] = new int[] { 100, 300, 250, 500, 350, 300, 150, 400, 300, 350, 450, 100, 200, 300, 250 };

        // feed the arrays of data into the constructor so it will be put into the list
        trenTech finalObject = new trenTech( groups, amountmembers, weight);

        System.out.println("To follow are the values listed in the List: ");
        for (int x = 0; x < groups.length; x++)
            System.out.println(Groups.get(x).toString());


        System.out.println("\nTo follow are the values that were chosen by the knapsack algorithm, maximizing the weight per bus, while keeping in mind the passenger constraint per bus:");   

        // method calls knapsack within, also removes a group from the list after used, in order not to have duplicate values appearing
        finalObject.removeGroups();
        

    }

}