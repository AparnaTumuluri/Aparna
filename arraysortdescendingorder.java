package Practiceprograms.arrayprograms;

public class arraysortdescendingorder {
    public static void main(String[] args){
        int [] a = {20,2,4,10,50,3,50};
        int temp = 0;
        //sorting the array elements in descending order
        for (int i=0 ; i<a.length ; i++){
            for (int j= i+1 ; j< a.length ; j++){
                if (a[i] < a[j]){
                    //using temp variable
//                    temp = a[i];
//                    a[i] = a[j];
//                    a[j]= temp;
                    //using bitwise or xor operator
                    a[j] = a[j] ^ a[i];
                    a[i] = a[j] ^ a[i];
                    a[j] = a[j] ^ a[i];

                }
            }
        }
        for (int i=0 ;i<a.length ;i++) {
            System.out.print(a[i]+ "  ");
        }

    }
}
