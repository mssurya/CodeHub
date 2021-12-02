package test;

public class CompressionMachine {

	public static void main(String[] args) {
		/*
		 *
1000  	{dataSize}
10		{transferSpeed}
2		{totalAchivers}
100 50 	{processingSpeed  compressionRate} ---1st archiver
60 20	{processingSpeed  compressionRate[dataSize/]} ---2nd archiver

uncompressed data = 1000/10  [dataSize/transferSpeed]
1st archiver takes = dataSize/processingSpeed = 1000/100
2nd archiver takes = dataSize/processingSpeed = 1000/50

Minimium time= dataSize/processingSpeed+
               dataSize*compressionRate/transferSpeed+
               dataSize*compressionRate/processingSpeed
		 * 
		 */
		String input = "1000";
		String input2 = "10";
		String archiver = "2";
		String archiver1 = "100  50";
		String archiver2 = "60  20";
		int dataSize = Integer.valueOf(input);
		int transferSpeed = Integer.valueOf(input2);
		int totalAchivers =  Integer.valueOf(archiver);
		int processingSpeed=0;
		int compressionRate=0;
		int speedTemp=100000;
		//String [] procCompr1 = archiver1.split("\\  ");
		String [] procCompr2;
		int minimumTime = 0;
		int j=1;
		while(j<totalAchivers) {
		for(int i=0;i<totalAchivers;i++) {
			procCompr2 = archiver1.split("\\  ");
			processingSpeed = Integer.valueOf(procCompr2[0]);
			compressionRate = Integer.valueOf(procCompr2[1]);
			minimumTime = dataSize/processingSpeed + dataSize*compressionRate/(transferSpeed*100)+dataSize*compressionRate/(processingSpeed*100);
			
			if(minimumTime<speedTemp) {
				speedTemp=minimumTime;
			}
		}
		System.out.println(Math.ceil(speedTemp));
		j++;
		}
	}

}
