import java.util.*;
import java.io.*;


public class program6 {


		public static void main(String args[]){
				String fileName = args[0];
				File myFile = new File(fileName);
				int colcount = 0;
				//get number of attributes
				try{
					Scanner in = new Scanner (myFile);
					ArrayList<String> temparr = new ArrayList<String>();

					while (in.hasNext()){
						temparr.add(in.next());
					}
					
					//number of atributes
					colcount = temparr.size()/10000;

					} catch(Exception e){
						e.printStackTrace();
					}

					String data[][] = new String[10000][colcount];
				try{
						//parse data
						Scanner in = new Scanner(myFile);
						for(int i = 0; i<10000; i++){
								for(int j = 0; j<colcount; j++){
										data[i][j] = in.next();
								}
						}

				} catch (Exception e){
						e.printStackTrace();
				}

				//read data into container arrays
				//these array contain the sets of Class and Attribute values
				ArrayList<Integer> Class = new ArrayList<Integer>();
				ArrayList<String> Attribute = new ArrayList<String>();

				for(int i = 0; i < data[0].length; i++){
						for(int j= 0; j < data.length; j++){
								//if in the attribute columns	
								if( i < data[0].length && !Attribute.contains(data[j][i])){
										Attribute.add(data[j][i]);
										//if in the class column
								} else if(i == data[0].length-1){
										int temp = Integer.parseInt(data[j][i]);
										if(!Class.contains(temp))
												Class.add(temp);
								} else {
										//do nothing;
								}
						}
				}

				//test the loop above
				/*for(int i = 0; i < Attribute.size(); i++){
				  System.out.println(Attribute.get(i));
				  }*/

				/*for(int i = 0; i < data.length;i++){
				  int temp = Integer.parseInt(data[i][data[0].length-1]);

				  System.out.println(Class.size());
				  }*/

				//now calculate conditional probabilities
				//calculate probablilites then hash them to correct key

				//tally up the number of instances of each class value
				HashMap<String, Integer> classTallyMap = new HashMap<String, Integer>();
				for(int index = 0; index < Class.size(); index++){
						int tally = 0;
						for(int i = 0; i < data.length; i++){
								int temp = Integer.parseInt(data[i][data[i].length-1]);
								if(Class.get(index) == temp)
										tally++;
						}
						String str = "" + Class.get(index);
						classTallyMap.put(str, tally);
				}

				//test loop above

				/*System.out.println(classTallyMap.size());
				  for(int i = 0; i < classTallyMap.size(); i++){
				  String str = "" + i;
				  System.out.println(classTallyMap.get(str));
				//	System.out.println(i);
				}*/

				//calculate the probabilities
				HashMap<String, Float> percMap = new HashMap<String, Float>();
				int tally = 0;
				float perc = 0;
				//loop through Class values
				for(int classIndex = 0; classIndex < Class.size(); classIndex++){
						//loop through attrubute values
						for(int attrIndex = 0; attrIndex<Attribute.size(); attrIndex++){
								//loop through data set and find match among class value and attribute value
								for(int col = 0; col < data[0].length-1; col++){
										for(int row = 0; row < data.length;row++){
												//if there is a match
												if(data[row][col].equals(Attribute.get(attrIndex)) && Integer.parseInt(data[row][data[0].length-1])==Class.get(classIndex)){
														tally++;
												}
										}

								}
								int temp = (Integer)classTallyMap.get(""+Class.get(classIndex));
								perc = (float)tally/(float)temp;
								percMap.put(Attribute.get(attrIndex)+""+Class.get(classIndex), perc);
								tally =0;
						}
				}

				//Now classify the data set

				//loop through class values
				float perc2 = 1;
				float classperc = 0;
				ArrayList<Integer> arr = new ArrayList<Integer>();
				HashMap<Integer, Float> mp = new HashMap<Integer, Float>();
				//loop through the samples
				for(int row=0; row < data.length; row++){

						//loop through classifier values
						for(int classindex=0; classindex < Class.size(); classindex++){
								//calculate percentage of current classifier
								int temp = (Integer)classTallyMap.get(""+Class.get(classindex));
								classperc = ((float)temp/(float)10000);
								//System.out.println(classperc);

								//loop through the attribute values
								for(int col=0; col < data[0].length-2; col++){
										//multiply the percentages of attibute/classifier combinations
										float var2 = (float)percMap.get((data[row][col])+""+Class.get(classindex))*100;
										perc2 = perc2 * var2; 
								}
								//multiply the classifier percentage
								//store the percentage of getting the classifier
								perc2 *= classperc;
								perc2 = perc2 /(float)100;
								mp.put(Class.get(classindex), perc2);
								perc2 = 1;
						}

						//get key of max value in map
						//this tells you the classifier of the current sample
						Map.Entry<Integer, Float> maxEntry = null;
						for(Map.Entry<Integer, Float> entry : mp.entrySet()){
								if(maxEntry ==null || entry.getValue().compareTo(maxEntry.getValue()) > 0){
										maxEntry = entry;
								}
						}

						arr.add(maxEntry.getKey());
						mp.clear();
				}

				//compare to samples
				float count = 0;
				for(int i = 0; i < data.length; i++){
					if(Integer.parseInt(data[i][data[0].length-1]) == arr.get(i))
						count++;
				}

				System.out.println((count/10000)*100 + "%");
		}

}	
