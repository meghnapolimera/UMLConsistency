import java.io.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args)throws IOException
	{
		
		ArrayList<String> outputRules= new ArrayList<String>();
		//give the path of the file where you want your output asp rules here//
		PrintWriter writer = new PrintWriter("C:/Users/MEGHNA/Desktop/KRR/UML/abc.txt", "UTF-8");
		 
		// Directory path here where all your classes are stored//
		  String path = "C:/Users/MEGHNA/Desktop/KRR/UML"; 
		 
		  String files;
		  File folder = new File(path);
		  File[] listOfFiles = folder.listFiles(); 
		 
		  for (int i = 0; i < listOfFiles.length; i++) 
		  {
		 
		   if (listOfFiles[i].isFile()) 
		   {
		   files = listOfFiles[i].getName();
		   Java2ASP obj=new Java2ASP();
		   
		   
		ArrayList<String> aspRules= obj.convert(path+"/"+files, files);
		
		
		for(String rule:aspRules)
		{
			if(outputRules.contains(rule))
			{}
			else
			{
			outputRules.add(rule);
			}
			
		}
		
		
		      }
		  }
		  
		  for(String rule:outputRules)
		  {
			//  System.out.println(rule);
			  
			  writer.println(rule);

			  
		  }
		  	writer.println("\n");
		  	writer.println("Dependency violations");
		  	writer.println("violation(X,Y,dependency_error):-dep(X,Y), baseClass(X), derivedClass(Y).");
		  	writer.println("\n");
		  	writer.println("Generalization violations");
		  	writer.println("violation(X,Y,generalization_error):- gen(X,Y), derivedClass(X;Y).");

			writer.close();
	}

}
