import java.util.*;
import java.sql.Timestamp;
import java.io.*;
public class assignment1 {
/////////////Task A: Basic I/O/////////////////////////////////////////////
	
	private class person{
		String firstname;
		int age ;
		int level ;
		String nationality ;
		public person(String sName, int iAge, int iLevel, String sNation) {
		//constructor – use to initialize the attributes of each person
			this.firstname = sName;
			this.age = iAge;
			this.level = iLevel;
			this.nationality = sNation;
		}
		@Override
		public String toString() {
		return "person [name=" + firstname + ", age=" + age + ", level=" + level + ",nationality=" + nationality + "]";
		}
		}
	private ArrayList<person> people; /*ArrayList datastructure to hold list of people*/
	

	public int SIZE(){
		int i = 0;
		while(true){
			if(people.get(i+1).equals(null)){
				return i;
			}
			i++;
		}
	}  

	public ArrayList<person> READ_FILE(ArrayList<person> x) {
	String[] data = new String[4];
	String line;
	person pObj = null; 
	int index = 0;
	BufferedReader buff = null;
	
	try {
	buff = new BufferedReader(new FileReader("Assignment1.csv"));
	line = buff.readLine();
	
	while((line = buff.readLine())!= null) 
	{ 
		line = buff.readLine();
		data = line.split(",",0);
		pObj = new person(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),data[3]);
		index++;
		
		
	}
	buff.close();
	} catch (IOException e) {
		e.printStackTrace();
		}
	
	return x;
	}
	
	public void ACCEPT_INPUT() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter details for a new person in ONE line. \nSeparate Name,Age, Level and Nationality with a COMMA (,) ");
	String newArr[] = new String[4];
	String line = sc.nextLine();
	newArr = line.split(",");
	people.add(new person(newArr[0],Integer.valueOf(newArr[1]),Integer.valueOf(newArr[2]),newArr[3]));
	}
	//////////////////////////////////////////TASK 2: FIND & DELETE
	//////////////////////////////
	public person SEARCH() {
	person p = null;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Name or Age of Person being sought after ");
	String r = sc.nextLine();
	//System.out.println("Index "+"Name " + "Age " + "Level " + "Nationality ");
	if (Character.isDigit(r.charAt(0))) { //test for Age
	//search based on Age
	int i = 0;
	while(people.get(i) != null){
		if(people.get(i).equals(r)){
			return people.get(i);
		}
		i++;
		}
	}
		else { 
			//searching based on Name
			int i = 0;
			while(people.get(i)!= null){
				if(people.get(i).equals(r)){
					return people.get(i);
				}
				i++;
				}
			}
		if(p==null){
			System.out.println("Not found");
		}
		return p;
	}
	 
	public void DELETE() {
	person x = SEARCH();
	int i = 0;
	if (!x.equals(null)){
		while(!(people.get(i).equals(null))){
			if(people.get(i).equals(x)){
				for(int j = i;j < SIZE()-1;j++){
					people.set(j+1,people.get(i));
				}
			}
			i++;
		}
	}
	}
///////////////////////////////////TASK 3: BUBBLE SORT////////////////////////////
public ArrayList<person> ITERATIVE_BUBBLE(ArrayList<person> pList){
	int n = SIZE();
	boolean swapped = false;
	for (int i=0;i<n-1;i++){
		for (int j=0;j<n-i-1;j++){
			swapped = false;
			if(pList.get(j).age > pList.get(j+1).age){
				swapped = true;
				//sort acc. to age
				person temp = pList.get(j);
				pList.set(j,pList.get(j+1));
				pList.set(j+1,temp);
			}
			
		}
		if(!swapped){
			System.out.println("Sorted List");
			return pList;
			
		}
	}
	return pList;

}

public ArrayList<person> RECURSIVE_BUBBLE(ArrayList<person> pList){
boolean swapped = false;
int n = SIZE();
for (int j=0;j<n-1;j++){
	if(pList.get(j).age > pList.get(j+1).age){
		swapped = true;
		//Name
		person temp = pList.get(j);
		pList.set(j,pList.get(j+1));
		pList.set(j+1,temp);
		}
	if(!swapped){
		System.out.println("Sorted List:");
		return pList;
	}
	
}
RECURSIVE_BUBBLE(pList);
return pList;
}
public static void main(String[] args){
	assignment1 p = new assignment1();
	ArrayList<person> list = p.READ_FILE(null);
	long START_TIME1 = System.nanoTime();
	p.ITERATIVE_BUBBLE(list);
	long END_TIME1 = System.nanoTime();
	long START_TIME2 = System.nanoTime();
	p.RECURSIVE_BUBBLE(list); 
	long END_TIME2 = System.nanoTime();
	
	//Accept_input
	//delete
	//search
}
}