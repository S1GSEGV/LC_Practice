class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1)
            return 1;
    
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        ArrayList<Integer> alist = new ArrayList<Integer>();
        alist.add(1);
        for(int i = 1; i < n; i++) {
            int m2 = alist.get(i2) * 2;
            int m3 = alist.get(i3) * 3;
            int m5 = alist.get(i5) * 5;
            int min = Math.min(Math.min(m2, m3), m5);
            if(min == m2)
                i2++;
            if(min == m3)
                i3++;
            if(min == m5)
                i5++;
            alist.add(min);
        }
        return alist.get(n-1);
    }
}