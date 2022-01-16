package com.david;


public class Solution {
	
	public int solution(int n) {
		int answer = 0;
		
		for (int i = 1; i <=n; i++) {
			if (n % i == 0) {
				answer += i;
			}
		}
		return answer;
	}
	
    public int sumDivisor(int num) {
        int answer = 0;
            for(int i = 1; i <= num/2; i++){
        if(num%i == 0) answer += i;
      }
        return answer+num;
    }
    
    
    public String solution(int a, int b) {
      	String answer = "";
		String[] week = {"THU","FRI", "SAT", "SUN", "MON", "TUE", "WED"};
		int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int total = 0;
		
		--a;
		while(a>0) {
			total += month[--a];
		}
        total += b;
		answer = week[total % 7];
		return answer;
    } 
	
	

}
