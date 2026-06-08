public class SortInteger {
    public static void main(String[] args) {
        int[] a={0,1,2,3,4,5,6,7,8};
        System.out.println(checkOnesSegment("110"));
    }
    public static int concatenatedBinary(int n) {
        String s="";
        for(int i=1;i<=n;i++){
            s=s+Integer.toBinaryString(i);
        }
        int x=Integer.parseInt(s,2);
        return x;

    }
    public static boolean checkOnesSegment(String s) {
        int c=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                c++;
            }
        }
        if(c==1){
            return true;
        }
        int index=s.indexOf('1');
        int ched=0;
        for(int i=index;i<s.length()-1;i++){
            if(s.charAt(i)=='1' && s.charAt(i+1)=='1'){
                ched++;
            }
        }
        if(ched==c){
            return true;
        }
        return false;


    }
    public static int minOperations(String s) {
        int c=0;
        StringBuilder x=new StringBuilder(s);

        for(int i=0;i<s.length()-1;i++){
            if(x.charAt(i)=='1' && x.charAt(i+1)!='0'){
                c++;
                x.setCharAt(i+1,'0');

            }else if(x.charAt(i)=='0' && x.charAt(i+1)!='1'){
                c++;
                x.setCharAt(i+1,'1');
            }
        }

        return c;
    }
    public static char findKthBit(int n, int k) {
        if(k==1){
            return '0';
        }
        String ans="0";

        for(int i=2;i<=n;i++){
            StringBuilder x=new StringBuilder();
            for (char c : ans.toCharArray()) {
                x.append(c == '0' ? '1' : '0');
            }
            ans=ans+"1"+x.reverse();
        }
        return ans.charAt(k+1);
    }

    public static int numSteps(String s) {
        long n=0;
        int c=s.length()-1;
        int i=0;
        while(c>=0){
            long ch=(long)(s.charAt(c)-'0');
            n=n+(long)Math.pow(2,i)*ch;
            c--;
            i++;
        }
        c=0;
        while(n!=1){
            c++;
            if((n&1)==0){
                n=n/2;
            }else{
                n=(n+1);
            }
        }
        return c;
    }
}
