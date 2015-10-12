	package module.actualMethod.conceptnet;
	import java.io.*;
	import java.util.ArrayList;


	public class ClingoWrapper {

		static String ClingoCmd_Linux =  "C:\\Users\\MEGHNA\\Desktop\\KRR\\clingo-3.0.5-win64\\clingo.exe C:\\Users\\MEGHNA\\Desktop\\KRR\\clingo-3.0.5-win64\\sample.txt";

		public static ArrayList<String> callASP() {

			try {

//				String[] cmd = getExecCommand();
				String[] cmd = {"C:\\Users\\MEGHNA\\Desktop\\KRR\\clingo-3.0.5-win64\\clingo.exe", "C:\\Users\\MEGHNA\\Desktop\\KRR\\clingo-3.0.5-win64\\sample.txt.txt"};
				Process process = Runtime.getRuntime().exec(cmd);
				ArrayList<String> parseASPoutput = parseASPoutput(process.getInputStream(), process.getErrorStream());
				return parseASPoutput;
			} catch (Exception e) {
				System.out.println("exception happened - here's what I know: "); //$NON-NLS-1$
				e.printStackTrace();
			}
			return new ArrayList<String>();
		}


		public static ArrayList<String> parseASPoutput(InputStream inputStream, InputStream errorStream)
		throws Exception {

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(inputStream));
			String ss;
			ArrayList<String> output = new ArrayList<String>();
			while ((ss = stdInput.readLine()) != null) {

				// Filter the answer
				if (!ss.trim().isEmpty()) {
					output.add(ss);
				}
			}

			BufferedReader stdError = new BufferedReader(new InputStreamReader(errorStream));
			StringBuffer stdE = new StringBuffer();
			boolean hasError = false;
			while ((ss = stdError.readLine()) != null) {
				ss = ss.trim();
				stdE.append(ss);
				stdE.append("\n");
				if ((!ss.isEmpty()) && (!ss.startsWith("%"))) {
					hasError = true;
				}
			}

			if (hasError) {
				throw new Exception("Error in ASP: " + stdE.toString());
			}

			/*if (output.isEmpty()) {
				throw new Exception("No output from ASP");
			}*/
			stdInput.close();
			stdError.close();
			return output;
		}

		/**
		 * @return
		 * @throws IOException
		 */
		public static String[] getExecCommand() throws IOException {
			String[] cmd = {
								ClingoWrapper.ClingoCmd_Linux
			};
			return cmd;
		}

		public static void main(String[] args) {
			ArrayList<String> output= callASP();
			for(int i=0;i<output.size();i++)
				System.out.println(output.get(i));
		}
	

}

