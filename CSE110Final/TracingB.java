class TracingB{
    public static void main(String [] args){
        mTracing1(9);
    }
    
    public static void mTracing1(int n){
        if(n>=4){
            mTracing1(n-1);
            System.out.println(mTracing2(n));
        }
    }
    
    public static int mTracing2(int a){
        int b=(a++) +3;
        return a-b*a;
    }
}