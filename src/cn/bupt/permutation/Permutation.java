package cn.bupt.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	
	public static void swap(char c[],int i,int j){
		if(i!=j){
			c[i]=(char) (c[i]^c[j]);
			c[j]=(char) (c[i]^c[j]);
			c[i]=(char) (c[i]^c[j]);
		}
	}
	
	public static void reverse(char c[],int start){
		int end=c.length-1;
		while(start<end){
			swap(c, start, end);
			start++;
			end--;
		}
	}
	
	public static int lastIndex(char c[],int i){
		int start=i+1;
		for(;start<c.length;start++){
			if(c[start]<=c[i]){
				break;
			}
		}
		return start-1;
	}
	
	public static List<String> permutation(char c[]){
		List<String> result=new ArrayList<String>();
		result.add(String.valueOf(c));
		while(true){
			int i=c.length-1;
			for(;i>=1;i--){
				if(c[i-1]<c[i]){
					break;
				}
			}
			if(i==0){
				return result;
			}
			int lastIndex=lastIndex(c, i-1);
			swap(c, i-1, lastIndex);
			reverse(c, i);
			result.add(String.valueOf(c));
			
		}
		
		
	}
	
	public static void main(String[] args) {
		String s="123";
		List<String> permutation=permutation(s.toCharArray());
		System.out.println(permutation);
	}
	

}
