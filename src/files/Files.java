package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Files {
	
	/**
	 * From http://codekata.pragprog.com/2007/01/kata_four_data_.html
	 * @param filepath
	 * @return day number that has the minumum temperature spread
	 */
	public static int getMinTempSpreadDay(String filepath){
		TempDay minSpreadDay = null;
		try{
			BufferedReader in = new BufferedReader(new FileReader(filepath));
			String line;
			while(((line = in.readLine()) != null)){
				TempDay tempDay = null;
				try {
					tempDay = new TempDay(line);
				} catch (Exception e) {
					//fail silently, this was a bad parse
				}
					
				if(  tempDay != null && 
					(minSpreadDay == null || tempDay.getSpread() < minSpreadDay.getSpread())){
					minSpreadDay = tempDay;
				}
				
				
			}
		}catch(IOException e){
			
		}
		
		return minSpreadDay.getDay();
	}
	
	private static class TempDay{
		private Integer day;
		private Double maxTemp;
		private Double minTemp;
		
		public TempDay(String line) throws Exception{
			if(line.length() == 0)
				throw new Exception("invalid tempday line");
			String [] parts = line.split(" ");
			for(String part : parts){
				if(part.length() > 0){
					try{
						if(day == null)
							day = Integer.parseInt(part);
						else if(maxTemp == null)
							maxTemp = Double.parseDouble(part);
						else if(minTemp == null){
							minTemp = Double.parseDouble(part);
							break;
						}
					}catch(Exception e){//fail the entire create if any parse fails
						throw new Exception("invalid tempday line");
					}
				}
			}
		}
		
		public int getDay(){
			return day.intValue();
		}
		
		public double getSpread(){
			return (maxTemp - minTemp);
		}
	}
}
