
import java.util.ArrayList;
import java.io.*;


public class Java2ASP extends Main {
	
	public ArrayList<String> convert(String filepath, String file) throws IOException
	{
		ArrayList<String> rules=new ArrayList<String>();
		ArrayList<String> tempGenRules=new ArrayList<String>();
		ArrayList<String> tempDepRules=new ArrayList<String>();
		
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String line = null;
		
		
	while ((line = reader.readLine()) != null) {
			Generalization gen=new Generalization();
			
			tempGenRules=gen.generalize(line);
			for(String rule1: tempGenRules)
			{
				rules.add(rule1);
		
			}
			
	
			Dependency dep=new Dependency();
			
			tempDepRules=dep.dependence(line, file);
		
			for(String rule1: tempDepRules)
			{
				
				rules.add(rule1);
			}
	}
		
return rules;
		
	}

	
}
