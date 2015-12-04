import java.util.*;
import java.lang.Math.*;

public class program4{

		public static void main(String args[]){
				boolean [][] data1 = {
						{  true , true,  true,  true,  true},
						{  true , true, false,  true,  true},
						{  true , true,  true, false,  true},
						{  true ,false,  true,  true,  true},
						{ false,  true, false, false, false},
						{ false,  true,  true, false, false},
						{ false,  true, false,  true, false},
						{ false,  true, false, false, false},
				};

				boolean [][] data2 = {
						{ false, false, true , true,  true,  true},
						{ false, false, true , true, false,  true},
						{  true, false, true ,false,  true,  true},
						{  true,  true, true ,false, false,  true},
						{ false, false, true,  true, false, false},
						{  true, false, true,  true,  true, false},
						{  true, false,false, false,  true, false},
						{ false, false,false, false,  true, false},
				};


				System.out.println(GetAttribute(data1));
				System.out.println(GetAttribute(data2));
		}

		public static int GetAttribute(boolean data[][]){
				float tfrac1=0;
				float tfrac2=0;  
				float ffrac1=0;
				float ffrac2=0;
				float tmin = 0;
				float tplus = 0;
				float fplus = 0;
				float fmin = 0;
				float gains[] = new float[data[0].length-1];	
				//for(int i = 0; i < data[0].length; i++){
				//	System.out.println(data[0][i]);
				//}
				for(int i = 0; i < data[0].length-1; i++){
						tmin = 0;
						tplus = 0;
						fmin = 0;
						fplus = 0;
						for(int j = 0; j < data.length; j++){
								if(data[j][i] == true && data[j][data[0].length-1] == true){
										tplus++;
								} else if(data[j][i] == true && data[j][data[0].length-1] == false){
										tmin++;
								} else if(data[j][i] == false && data[j][data[0].length-1] == false){
										fmin++;
								} else {
										fplus++;
								}

						}
						tfrac1 = tplus/(tplus + tmin);
						tfrac2 = tmin/(tplus + tmin);
						ffrac1 = fplus/(fplus + fmin);
						ffrac2 = fmin/(fplus + fmin);
						float bigfrac1 = (tplus + fplus)/(data[0].length);
						float bigfrac2 = (tmin + fmin)/(data[0].length);

						gains[i] = InfoGain(bigfrac1,bigfrac2) - ((float)((fplus + fmin)/data[0].length)*InfoGain(ffrac1,ffrac2) + ((float)((tplus + tmin)/data[0].length))*InfoGain(tfrac1,tfrac2));


				}
				//Arrays.sort(gains);
				return getMaxIndex(gains) + 1;
		}

		public static float InfoGain(float num1, float num2){
				if(num1 <= 0 || num2 <= 0)
						return 0; 
				else				
						return (-(num1)*(float)(Math.log(num1)/Math.log(2))-((num2)*(float)(Math.log(num2)/Math.log(2))));
		}

		public static int getMaxIndex(float arr[]){
				float largest = arr[0]; 
				int index = 0;
				for (int i = 1; i < arr.length; i++) {
						if ( arr[i] >= largest ) {
								largest = arr[i];
								index = i;
						}
				}
				return index;	
		}
}
