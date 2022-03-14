import java.io.File;
import java.util.Scanner;

class wordInfo {
    public String word;
    public int occurences;
 
    public wordInfo(String word, int occurences) {
        this.word = word;
        this.occurences = occurences;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        

        File file = new File("words.txt");
        Scanner scanner = new Scanner(file);

        Linked_list<wordInfo> words = new Linked_list<wordInfo>();

        Linked_list<wordInfo>.Node<wordInfo> temp = words.head;
        while(scanner.hasNext()){
            String str = scanner.next();
            boolean found = false;

            
            for(int i = 0; i < words.size; i++) {
                if(temp.data.word.equals(str)) {
                    temp.data.occurences++;
                    found = true;
                    System.out.println("Found! word=" + str + ", occurences=" + temp.data.occurences);
                }
                temp = temp.next;
            }
            
            if(!found) {
                words.add(new wordInfo(str, 1));
            }  

            temp = words.head;
            
        }

        Linked_list<wordInfo>.Node<wordInfo> temp1 = words.head;
        for(int i = 0; i < words.size; i++) {
            System.out.println(temp1.data.word + " - " + temp1.data.occurences);
            temp1 = temp1.next;
        }
        
        scanner.close();

    }
}
