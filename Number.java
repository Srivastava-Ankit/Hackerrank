package com.demo.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Data{
	String val;
	int steps;
	public Data(String val, int steps)  
    { 
        this.val = val; 
        this.steps = steps; 
    } 
	
}


public class Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         long n = 13;
		
		System.out.println(minOperations(n));
	}
	
	
	
	public static long minOperations(long n) {
	    // Write your code here

	
		Set<String> visited = new HashSet<>(1000); 
        LinkedList<Data> queue = new LinkedList<Data>();
        
        String number = Long.toBinaryString(n);
        
        Data d = new Data(number ,0);

        queue.offer(d); 
        visited.add(d.val); 
        
        while (!queue.isEmpty()) {
        	 Data temp = queue.poll();
        	 visited.add(temp.val);
        	 long num = Long.parseLong(temp.val);
        	 if (num == 0) { 
                 return temp.steps; 
             }
        	 
        	 String change1 = temp.val;
        	 
        	 String change2 = temp.val;
        	 
        	 char[] myNameChars = temp.val.toCharArray();
        	 
        	 for(int i = 0;i < temp.val.length()-1;i++) {
        		 if(Integer.parseInt(Character.toString(myNameChars[i])) == 0 && Integer.parseInt(Character.toString(myNameChars[i+1])) == 1 && (temp.val.substring(i+2).equals("") || Integer.parseInt(temp.val.substring(i+2)) == 0)) {
        			 myNameChars[i] = '1';
        			 change1 = String.valueOf(myNameChars);
        			 break;
        		 }
        		 
        		 if(Integer.parseInt(Character.toString(myNameChars[i])) == 1 && Integer.parseInt(Character.toString(myNameChars[i+1])) == 1 && ( temp.val.substring(i+2).equals("") || Integer.parseInt(temp.val.substring(i+2)) == 0)){
        			 myNameChars[i] = '0';
        			 change1 = String.valueOf(myNameChars);
        			 break;
        		 }
        		 
        	 }
        	 
        	 char[] myNameChar = temp.val.toCharArray();
        	 
        	 if(myNameChar[temp.val.length()-1] == '0') {
        		 myNameChar[temp.val.length()-1] = '1';
        		 change2 = String.valueOf(myNameChar); 
        	 } else {
        		 myNameChar[temp.val.length()-1] = '0';
        		 change2 = String.valueOf(myNameChar); 
        	 }
        	 
        	 if(0 <= Integer.parseInt(change1,2) && Integer.parseInt(change1,2) <= Math.pow(10, 15) && !visited.contains(change1)) {
        		 Data node1 = new Data(change1, temp.steps + 1); 
                 queue.offer(node1); 
        	 }
        	 
        	 if(0 <= Integer.parseInt(change2,2) && Integer.parseInt(change2,2)  <= Math.pow(10, 15)&& !visited.contains(change2)) {
        		 Data node2 = new Data(change2, temp.steps + 1); 
                 queue.offer(node2); 
        	 }
        	
        	
        }
        return -1; 
	}
	
	

}
