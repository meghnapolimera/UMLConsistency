import java.util.ArrayList;


public class Dependency {

	public ArrayList<String> dependence(String lineInput, String file)
	{
	
		
			ArrayList<String> depRules=new ArrayList<String>();
			String[] splitString; 
			String newfile= "";
			
		try
		 {
			
			if(lineInput.matches("(\\s)*(public|private|protected)\\s(\\w)+\\s(\\w)+;"))
					{
	
			
						splitString=lineInput.split(" ");
						
						for(int i=0; i<file.length()-5; i++)
						{
							newfile=newfile+file.charAt(i);
						
						}
						depRules.add("Dep("+newfile+","+splitString[1]+").");
						
				}
		 }catch(Exception e)
		 {
			 
		 }
		return depRules;
	}
	
}