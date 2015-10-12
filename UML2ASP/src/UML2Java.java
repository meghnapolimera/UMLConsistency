import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;
public class UML2Java {
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("C:/Users/MEGHNA/Downloads/Class.java"));
		String line = null;
		String[] splitString1;
		String[] splitString2;
		
		/*ArrayList<String> classes=new ArrayList<String>();
		ArrayList<String> baseclass=new ArrayList<String>();
		ArrayList<String> derivedclass=new ArrayList<String>();
		*/
		//String str="ABC extends DBS {";
		//System.out.println(str.matches());
		while ((line = reader.readLine()) != null) {
			
		 try
		 {
			 //split on basis of class//
		splitString1=line.split("\\sclass\\s");
		
		//if there is extends relation
		if(splitString1[1].matches("(\\w)+\\sextends\\s(\\w)+(\\s)*(\\W)*"))
		{
			
			splitString2=splitString1[1].split("\\sextends\\s");
		
			//if there is type- class2 {
			if(splitString2[1].matches("(\\w)*\\s\\W"))
			{
				//converting to character array//
				char temparr[]=splitString2[1].toCharArray();
				
				splitString2[1]="";
				
				//reinitializing class by removing _{
				for(int i=0;i<temparr.length-2;i++)
				{
					splitString2[1]=splitString2[1]+temparr[i];
				}
				
			}
			//generate rule//
			
			//store classes in class array//
			//classes.add(splitString2[0]);
			//classes.add(splitString2[1]);
			
			//store in derived and base class//
			//baseclass.add(splitString2[0]);
			//derivedclass.add(splitString2[1]);
			//System.out.println("classes("+splitString2[0]+";"+splitString2[1]+")");
			System.out.println("base_class("+splitString2[1]+").");
			System.out.println("derived_class("+splitString2[0]+").");
			System.out.println("\n");
			System.out.println("gen("+splitString2[0]+","+splitString2[1]+").");
			System.out.println("\n");
			System.out.println("violation(X,Y,generalization_error):- gen(X,Y), derived_class(X;Y).");
			
		}
		else
		{
		//add class//
			
			if(splitString1[1].matches("(\\w)*\\s\\W"))
			{
				//converting to character array//
				char temparr1[]=splitString1[1].toCharArray();
				
				splitString1[1]="";
				
				//reinitializing class by removing _{
				for(int i=0;i<temparr1.length-2;i++)
				{
					splitString1[1]=splitString1[1]+temparr1[i];
				}
				
			}
			//store in class//
			//classes.add(splitString1[1]);
		System.out.println("class("+splitString1[1]+")");
		}
	}
		 catch(Exception e)
		 {
			 
		 }

		}
		
	
		
	}

}
