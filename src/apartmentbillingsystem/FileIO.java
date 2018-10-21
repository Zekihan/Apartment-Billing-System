package apartmentbillingsystem;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

public class FileIO {
	
	private String fileName;
	
	public FileIO(String fileName) {
		this.fileName = fileName;
	}
	
	public String[][] readCsv() {
		ArrayList<String[]> lineList = new ArrayList<String[]>();
		boolean done = false;
		
			try {
				BufferedReader fileInStream = new BufferedReader(new FileReader(fileName));
				while(done == false) {
					String line = fileInStream.readLine();
					if(line != null) {
						StringTokenizer st = new StringTokenizer(line, ",");
						ArrayList<String> tokenList = new ArrayList<String>();
						while(st.hasMoreTokens()){
							tokenList.add(st.nextToken());
						}
						String[] tokenArr = tokenList.toArray(new String[tokenList.size()]);
						lineList.add(tokenArr);
					} else {
						done = true;
						fileInStream.close();
					}
				}	
			} catch(FileNotFoundException e) {
				System.out.println("File" + fileName + "not found");
				System.out.println("Exception: " + e.getMessage());
				System.exit(-1);
			} catch(IOException e) {
				System.out.println("Error reading from file" + fileName);
				System.out.println("Exception: " + e.getMessage());
				System.exit(-1);
			}
			
			String[][] lineArr = lineList.toArray(new String[lineList.size()][lineList.get(0).length]);
			return lineArr;
	}

	public void writeCsv(String[][] lineArr) {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		try {
			File file = new File(fileName);
			PrintWriter outFile = new PrintWriter(file);
			for (int i=0; i<lineArr.length; i++) {
				for (int j=0; j<lineArr[0].length; j++) {
					if (j < lineArr[0].length - 1) {
						outFile.print(lineArr[i][j] + ",");
					} else {
						outFile.print(lineArr[i][j]);
					}
				}
				outFile.println();
			}
			outFile.close();
			String newName = "BillingInfo-" + date + ".csv";
			File newFile = new File(newName);
			file.renameTo(newFile);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
