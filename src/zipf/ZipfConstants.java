package zipf;

public interface ZipfConstants {

	//Size of Rack, DataNode, File and No. of Blocks
	static final int RACK_SIZE = 20;
	static final int NODE_SIZE = 200;
	static final int FILE_SIZE = 100;
	static final int BLOCK_SIZE = 1000;
	
	//Assigning indices
	static final int RACK = 0;
	static final int NODE = 1;
	static final int FILE = 2;
	static final int BLOCK = 3;
	
	//Block Sizes
	static final int MIN_BLOCK_SIZE = 5;
	static final int MAX_BLOCK_SIZE = 10;

	//ZipfDistribution Constants
	static final int NUM_OF_ELEMENTS = 500;
	static final int EXPONENT = 5;
	
}
