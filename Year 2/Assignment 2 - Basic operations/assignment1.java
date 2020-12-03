/*
  author: Keanu Johnston
  student no: 3851727
  21 April 2020
*/
import java.util.*;
import java.sql.Timestamp;
import java.io.*;

public class assignment1 {
/////////////Task A: Basic I/O/////////////////////////////////////////////
	public int obj_count = 0;
	private class person{
		String firstname;
		int age;
		int level;
		String nationality;
		
		public  person(String sName, int iAge, int iLevel, String sNation) {
		//constructor – use to initialize the attributes of each person	
			this.firstname = sName;
			this.age = iAge;
			this.level = iLevel;
			this.nationality = sNation;
			obj_count++;
		}
		@Override
		public String toString() {
		return "person [name=" + firstname + ", age=" + age + ", level=" + level + ",nationality=" + nationality + "]";
		}
		}
	private ArrayList<person> people = new ArrayList<person>(); /*ArrayList datastructure to hold list of people*/
	public int SIZE(){
		if (obj_count == 0){
			return obj_count;
		}
		else{
			
			return obj_count;
		}
		
	}  

	public ArrayList<person> READ_FILE() {
	BufferedReader buff = null;
	String line;
	person pObj = null;
	System.out.println("CHECK SIZE" + SIZE());
	try {
	buff = new BufferedReader(new FileReader("Assignment1.csv"));
	line = buff.readLine();
	
	while((line = buff.readLine())!= null){
		final String[] data = line.split(",",0);
		pObj = new person(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),data[3]);
		people.add(pObj);
	}
	buff.close();

	} catch (IOException e) {
		e.printStackTrace();
		}
	System.out.println("\nFile read and Array populated");
	return people;
	}
	
	public void ACCEPT_INPUT() {
	try {
	Scanner sc = new Scanner(System.in);
	System.out.println("\nEnter details for a new person in ONE line. \nSeparate Name,Age, Level and Nationality with a COMMA (,) ");
	String newArr[] = new String[4];
	String line = sc.nextLine();
	newArr = line.split(",");
	people.add(new person(newArr[0],Integer.valueOf(newArr[1]),Integer.valueOf(newArr[2]),newArr[3]));

	System.out.println("\nSuccessfully added" );
	} catch (Exception e) {
		System.out.println("\nUnsuccessfully added");
		Scanner sc2 = new Scanner(System.in);
		System.out.println("\nWould you like to continue: Y/N ");
		String line2 = sc2.nextLine();
		if(line2.toUpperCase().equals("Y")){
			return;
		}else{
			ACCEPT_INPUT();
		}
		
		
	}
	
	}
	//////////////////////////////////////////TASK 2: FIND & DELETE
	//////////////////////////////
	public person SEARCH() {
	try {
		person p = null;
	
	Scanner sc = new Scanner(System.in);
	System.out.println("\nEnter the Name or Age of Person being sought after");
	String r = sc.nextLine();
	int i;

	if (Character.isDigit(r.charAt(0))) { //test for Age
	//search based on Age
	i = 0;

	while(i < this.SIZE()){
		if(people.get(i).age == Integer.parseInt(r)){
			System.out.println("\nName\tAge\tLevel\tNationality");
			System.out.println(people.get(i).firstname + "\t" + people.get(i).age + "\t" + people.get(i).level + "\t" + people.get(i).nationality );
			return people.get(i);
		}
		i++;
		}
		
	}
		else { 
			//searching based on Name
			i = 0;
			while(i < this.SIZE()){
				if(people.get(i).firstname.equals(r)){
					System.out.println("\nFirstname\tAge\tLevel\tNationality");
					System.out.println(people.get(i).firstname + "\t" + people.get(i).age + "\t" + people.get(i).level + "\t" + people.get(i).nationality );
					return people.get(i);
					
				}
				i++;
				}
				
			}
		System.out.println("Person not found - please try again");
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Would you like to try again?: Y / N");
		String option = sc2.nextLine();
		if(option.toUpperCase().equals("N")){
			return p;
		}else{
			SEARCH();
		}
		
	} catch (Exception e) {
		System.out.println("Invalid entry - please ensure your input of name or age relates to name or age added");
		SEARCH();
		
		}return null;
	}

	 
	public void DELETE() {
	person x = SEARCH();
	String pName;

	try { 
	pName = x.firstname;
	Scanner inp = new Scanner(System.in);
	System.out.println("\nWould you like to delete this person? - Y/N");
	String opt = inp.nextLine();
	int index = people.indexOf(x);

	if (opt.toUpperCase().equals("Y")){
			for(int j = index ;j < SIZE()-1;j++){
				people.set(index,people.get(j+1));
			}
			System.out.println("Delete successful - Person " + pName + " deleted");
	}else{
		if(opt.toUpperCase().equals("N")){
			System.out.println("Delete Cancelled");
		}else{
			System.out.println("Delete Unsuccessful - Person not found");
		}
	}
	} catch (Exception e) {
		System.out.println("Person not found - Delete Unsuccessful");
	}
	
	}
///////////////////////////////////TASK 3: BUBBLE SORT////////////////////////////
public void ITERATIVE_BUBBLE(ArrayList<person> pList){
	int n = SIZE();
	for (int i=0;i<n-1;i++){
		for (int j=0;j<n-i-1;j++){
			if(pList.get(j).age > pList.get(j+1).age){
				//sort acc. to age
				person temp = pList.get(j);
				pList.set(j,pList.get(j+1));
				pList.set(j+1,temp);
			}
			
		}
		}
		System.out.println("\nSorted List");
		System.out.println(pList);	
	}
/*precondition: the int @param is used to initiate the recursive sort
to start off the sorting procedure*/
public void RECURSIVE_BUBBLE(ArrayList<person> pList,int round){
if(round == SIZE()){
	System.out.println(pList);
}else{
		for (int j=0;j<SIZE()-round-1;j++){ //0(n)
			if(pList.get(j).age > pList.get(j+1).age){//O(1)
				//Name
				person temp = pList.get(j);
				pList.set(j,pList.get(j+1));//0(1)
				pList.set(j+1,temp);
			}
			
	}round++;
	RECURSIVE_BUBBLE(pList,round);//O(1)
}
}

public static void main(String[] args){
	assignment1 aGroup = new assignment1();
	aGroup.READ_FILE();
	System.out.println("\n************************DELETE***************************");
	aGroup.DELETE();
	System.out.println("\n************************SEARCH***************************");
	aGroup.SEARCH();
	System.out.println("\n**********************ACCEPT INPUT***********************");
	aGroup.ACCEPT_INPUT();
	System.out.println("\n************************SEARCH***************************");
	aGroup.SEARCH();

	System.out.println("\n******************Iterative bubble sort*******************\n");
	long START_TIME1 = System.nanoTime();
	aGroup.ITERATIVE_BUBBLE(aGroup.people);
	long END_TIME1 = System.nanoTime();
	System.out.println("\nNanosecond time START: " + START_TIME1);
	System.out.println("\nNanosecond time END: " + END_TIME1);
	System.out.println("\nNanosecond time differences " + (END_TIME1 - START_TIME1));
	
	System.out.println("\n******************Recursive bubble sort******************\n");
	long START_TIME2 = System.nanoTime();
	aGroup.RECURSIVE_BUBBLE(aGroup.people,0); 
	long END_TIME2 = System.nanoTime();
	System.out.println("\nNanosecond time: START: " + START_TIME2);
	System.out.println("\nNanosecond time: END: " + END_TIME2);
	System.out.println("\nNanosecond time differences " + (END_TIME2 - START_TIME2));
}
}