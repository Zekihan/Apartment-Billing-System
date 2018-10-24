package apartmentbillingsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UpdateCsv {
	
	private String[][] lineArr;
	private String oldFileName;

	public UpdateCsv(String[][] lineArr, String oldFileName) {
		this.lineArr = lineArr;
		this.oldFileName = oldFileName;	
	}
	
	public void updateCsv() {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		try {
			File file = new File(oldFileName);
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
