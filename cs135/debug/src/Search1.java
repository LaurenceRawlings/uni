public class Search1 {

    public static int index(int[] sequence, int value) {
        int i = 0;
        int position = -1; 
        while (i < sequence.length){
            if (sequence[i] == value){
                position = i; 
                //break; 
            }
            i++;
        }  
        return position;      
    }

    public static void main(String args[]) {
        int [] text = {10, 12, 12, 13, 14, 15};
        int v = 9;
        System.out.println();
        while (v < 16) {
            System.out.print("The number " + v);
            System.out.println(" appears at position " + index(text, v) + "." );
            System.out.println();
            v++;
        }   
    }	
}
