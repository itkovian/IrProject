/*
 * (C) 2011, Andy Georges
 *
 * Dit programma zal de data die uit de StepCounter wordt
 * gehaald (/sdcard/accelDataLog) inlezen en verwerken.
 *
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


class OfflineAnalysis {

	private static double [][] samples = null;
	
	/* print out the first three lines and the last line of
	 * the datafile for checking purposes
	 */
	public static void checkData() {
		
		
	}
	
	
	
	
	public static void main(String [] args) {
		
		if(args.length != 1) {
			System.err.println("You must provide a file with the relevant data!");
			System.err.println("Usage: OfflineAnalysis" + " <file>");
			System.exit(-1);
		}
		
		BufferedReader r = null;
		try {
			r = new BufferedReader(new FileReader(args[0]));
		}
		catch(FileNotFoundException e) {
			System.err.println("Oops!");
			System.err.println(e);
			System.exit(-1);
		}
		ArrayList<double[]> samplesA = new ArrayList();
		
		try {
			for(String l = r.readLine(); l != null; l = r.readLine()) {
				String [] fields = l.split(":");
				double [] s = { Double.parseDouble(fields[0]), Double.parseDouble(fields[2]), Double.parseDouble(fields[3]), Double.parseDouble(fields[4]) };
				samplesA.add(s);
			}
			r.close();
		}	
		catch(IOException e) {
			System.err.println("Oops");
			System.err.println(e);
			System.exit(-1);
			
		}
		samples = samplesA.toArray(new double [samplesA.size()][]);
	}
	
}
