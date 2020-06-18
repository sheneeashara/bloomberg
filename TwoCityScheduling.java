class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int sum=0;
        Arrays.sort(costs, (a,b)->(a[0]-a[1])-(b[0]-b[1]));
        for(int i=0; i<costs.length; i++){
            if(i<costs.length/2)    sum+=costs[i][0];
            else    sum+=costs[i][1];
        }
        return sum;
    }

    public static void main(final String[] args) {
        int[][] c1 = { {10,20} , {30,200} , {400,50} , {30,20}};
        
        // output : 110
        /*
        	Explanation: 
			The first person goes to city A for a cost of 10.
			The second person goes to city A for a cost of 30.
			The third person goes to city B for a cost of 50.
			The fourth person goes to city B for a cost of 20.

			The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
        */
        // Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
        System.out.println(twoCitySchedCost(c1));
    }
}