import java.util.ArrayList;


public class Generalization {
	
	
	public ArrayList<String> generalize(String lineInput)
	{
		String[] splitString1;
		String[] splitString2;
		ArrayList<String> genRules=new ArrayList<String>();
		
		try
		 {
			 //split on basis of class//
		splitString1=lineInput.split("\\sclass\\s");
		
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
			
			
			genRules.add("baseClass("+splitString2[1]+").");
			genRules.add("derivedClass("+splitString2[0]+").");
			genRules.add("Class("+splitString2[0]+").");
			genRules.add("Class("+splitString2[1]+").");
			genRules.add("\n");
			genRules.add("Gen("+splitString2[0]+","+splitString2[1]+").");
			
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
	genRules.add("Class("+splitString1[1]+").");
		}
		
		
		 }
		 catch(Exception e)
		 {
			 
		 }
return genRules;
	}
	

}
