import java.util.Scanner;

public class Main {

    static boolean isAnagram(String a1, String b1) {
        String a = a1.toLowerCase();
        String b = b1.toLowerCase();
        boolean anagram = false;
        char temps;
        char [] array_a = a.toCharArray();
        char [] array_b = b.toCharArray();

        if(array_a.length == array_b.length){
            for(int i = 0; i<array_a.length ; i++){
                for (int j = 0; j<array_b.length; j++ ){
                    if (array_a [i] == array_b [j]){
                        temps = array_b [i];
                        array_b [i] = array_b [j];
                        array_b [j] = temps;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i<array_b.length; i++){
                if(array_a [i] != array_b [i]){
                    res = 1;
                    break;
                }
            }
            if (res != 1){
                anagram = true;
            }
        }
        return anagram;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}