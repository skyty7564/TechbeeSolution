package com.techbeesolution.stringmanipulation;

public class twonumb {
	
	 public int[] twoSum(int[] nums, int target) {
	        
	        int[] twoNum = new int[2];
	        boolean check = false;
	        for (int i = 0 ; i < nums.length; i++)
	        {
	        	if(check)
	        	{
	        		break;
	        	}
	            for (int j = i+1; j  <nums.length; j++)
	            {
	            	
	                if ((nums[i] + nums[j]) == target)
	                {   
	                	twoNum[0] = nums[i];
	                    twoNum[1]=nums[j];
		      
		            	check =true;
	                    break;
	                }
	            }
	            
	        }
	        
	        return twoNum;
	    }

}
