package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {
		List<String[]> dataArray = loadData();
		int i = 0;
		int contPT, contES; contPT = contES = 0;
		boolean check = true;
		System.out.println("CAMBIO");
		while(check && !dataArray.isEmpty()){

			String [] currentItem = dataArray.get(i);
			String [] nextItem = new String[3];
			
			if(i == dataArray.size() - 1) 
				nextItem = new String[]{""};
			else
				nextItem = dataArray.get(i + 1);
			
			if(currentItem[0].equals(nextItem[0])){
				if (currentItem[1].equals("wizink-es")) {
					contES = Integer.valueOf(currentItem[2]);
					contPT = Integer.valueOf(nextItem[2]);
				}else {
					contPT = Integer.valueOf(currentItem[2]);
					contES = Integer.valueOf(nextItem[2]);
				}
				i+=2;
			}else if(!currentItem[0].equals(nextItem[0])){
				if (currentItem[1].equals("wizink-es")) {
					contES = Integer.valueOf(currentItem[2]);
					contPT = 0;
				}else {
					contPT = Integer.valueOf(nextItem[2]);
					contES = 0;
				}
				i++;
			}
			
			if(dataArray.size()  == i )
				check = false;
			

			System.out.printf("cambio 6 test_2 \n", contPT,currentItem[0]);
			System.out.printf("pN : %d - %s \n", contPT,currentItem[0]);
			System.out.printf("es : %d - %s \n", contES,currentItem[0]);
			System.out.println();
		}
	}
	
	public static List<String[]> loadData(){
		
		List<String[]> data = new ArrayList<String[]>();
		
		String[] state  = new String[]{ 
				  "ACTIVE", "PERSONAL", "INITBIO","SIGNED"};
		String[] tenants  = new String[]{ 
				  "wizink-es", "wizink-es", "wizink-pt","wizink-es"};
		String[] values  = new String[]{ 
				  "12", "8", "2","1"};


		for (int i= 0;i<4;i++) {
			String[] result  = new String[3];
			result[0] = state[i];
			result[1] = tenants[i];
			result[2] = values[i];
			data.add(result);
		}
		return data;
	}

}
