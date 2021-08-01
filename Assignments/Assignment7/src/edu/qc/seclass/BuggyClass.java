package edu.qc.seclass;

public class BuggyClass {
	
	public int buggyMethod1(int x, int y) {
		int out = 1;
		
		if(y % 2 == 0) y = 0;
		
		out = x / y;
		
		if(out % 2 == 0) out = x / out;
		else out = x / out;
		
		return out;		
	}
	
	public int buggyMethod2(int x, int y) {
		int out = 1;
		
		if(y % 2 == 0) out = 0;
		
		if(y == 0) out = x / out;
		else out = x / out;
		
		return out;		
	}
	
	public void buggyMethod3(int x, int y) {		
		/* Impossible to make. It is not possible to get 100% statement coverage even with less than 100% branch coverage.
		   The prior test of 100% branch coverage would not be met by putting it in one of the branches we stimulate.
		   This means we would have to put the error in the statement coverage, which would not be possible to reach 100%
		   coverage and pinpoint the error without the program throwing an error before 100% statement coverage is reached 
		 */
	}
	
	public void buggyMethod4(int x, int y) {		
		/* As mentioned above, in buggyMethod3, it is not practical to have 100% statement coverage while also being able
		   to pull the divisible by 0 error. The error would stop the program before the 100% statement coverage is reached.
		   The error cannot be in branches because the second portion of the test must have a requirement that there must
		   be 100% coverage of branches without error. 
		 */
	}
	
	public void buggyMethod5() {
		/* Not possible. As mentioned above, in buggyMethod3 and buggyMethod4, it is not possible to reach 100% statement
		   coverage when there is an error. It would disrupt the test, not letting able to reach 100% statement coverage
		 */
	}
}
