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
	
	/*
	 * Je moet deze methode aanvullen. Je gebruikt de static samples array,
	 * dus de methode heeft geen argumenten nodig. Je kunt die eventueel 
	 * wel toevoegen om bijvoorbeeld op de command line ook de threshold in
	 * te stellen.
	 */
	public static int countSteps() {
		
		return 0;
	}
	
	
	
	
	
	private static void showDataLine(int idx, double [] l) {
		System.out.println("At position " + idx + ": " + l[0] + ", " + l[1] + ", " + l[2] + ", " + l[3]);
	}
	
	/* print out the first three lines and the last line of
	 * the datafile for checking purposes. We do NOT check bounds!
	 */
	public static void checkData() {
		
		try {
			if(samples != null) {
				showDataLine(0,samples[0]);
				showDataLine(1,samples[1]);
				showDataLine(2,samples[2]);
				showDataLine(samples.length-1, samples[samples.length - 1]);
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Oops");
			System.err.println(e);
		}
		
		
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
			/* We only need the timestamp, X, Y and Z fields. The timestamp is 
			 * converted to seconds. 
			 */
			for(String l = r.readLine(); l != null; l = r.readLine()) {
				String [] fields = l.split(":");
				double [] s = { Double.parseDouble(fields[0])/1.0E9, Double.parseDouble(fields[2]), Double.parseDouble(fields[3]), Double.parseDouble(fields[4]) };
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
		
		checkData();
		
		int steps = countSteps();
		
		System.out.println("Steps counted: " + steps);
	}
	
}
