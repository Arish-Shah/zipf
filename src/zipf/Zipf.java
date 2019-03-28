package zipf;
import java.util.Random;

import org.apache.commons.math3.distribution.ZipfDistribution;

public class Zipf {

	ZipfDistribution z;
	int[][] log;
	Random rand;
	
	Zipf() {
		
		z = new ZipfDistribution(ZipfConstants.NUM_OF_ELEMENTS, ZipfConstants.EXPONENT);
		log = new int[10][13];
		rand = new Random();
		
		//Initializing the above array to zero
		for(int i = 0; i < log.length; i++) {
			for(int j = 0; j < log[i].length; j++) {
				log[i][j] = 0;
			}
		}
		
		//Generating Log
		generateLog();
		
		//Output log Variable
		for(int i = 0; i < log.length; i++) {
			for(int j = 0; j < log[i].length; j++) {
				System.out.print(log[i][j] + " ");
			}
			System.out.println();
		}
			
	}
	
	//Generating random number using Zipf
	public int generateNumber() {
		
		int probabilityAt = rand.nextInt((ZipfConstants.NUM_OF_ELEMENTS - ZipfConstants.EXPONENT) + 1) + ZipfConstants.EXPONENT;
		double prob = z.probability(probabilityAt);
		
		//Getting string before E, then type casting to Double
		String str = Double.toString(prob);
		str = str.substring(0, str.indexOf('E'));
		prob = Double.parseDouble(str);
		
		return (int) (prob * 10);
	}
	
	//Function that checks if number meet maximum size requirements
	public int scale(int num, int max) {
		
		double temp = num;
		temp = (temp/99)*(max-1)+1;
		num = (int) temp;
		return num;
		
	}
	
	//Scaling the number to meet content requirement
	public int scale(int index) {
		
		int zipfNumber = generateNumber();
		int maxSize = 0;
		
		switch(index) {
			case ZipfConstants.RACK: maxSize = ZipfConstants.RACK_SIZE;
									 break;
			case ZipfConstants.NODE: maxSize = ZipfConstants.NODE_SIZE;
									 break;
			case ZipfConstants.FILE: maxSize = ZipfConstants.FILE_SIZE;
									 break;
			case ZipfConstants.BLOCK: maxSize = ZipfConstants.BLOCK_SIZE;
									  break;
			default: maxSize = 0;
					 break;
		}		
		
		return scale(zipfNumber, maxSize);
		
	}
	
	public void generateLog() {
		
		for(int i = 0; i < log.length; i++) {
			
			log[i][ZipfConstants.RACK] = scale(ZipfConstants.RACK);
			log[i][ZipfConstants.NODE] = scale(ZipfConstants.NODE);
			log[i][ZipfConstants.FILE] = scale(ZipfConstants.FILE);
			
			int numberOfBlocks = rand.nextInt((ZipfConstants.MAX_BLOCK_SIZE - ZipfConstants.MIN_BLOCK_SIZE) + 1) + ZipfConstants.MIN_BLOCK_SIZE;
			
			for(int j = ZipfConstants.BLOCK; j < (numberOfBlocks + ZipfConstants.BLOCK); j++) {
				log[i][j] = scale(ZipfConstants.BLOCK);
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		new Zipf();

	}
	
	
}
