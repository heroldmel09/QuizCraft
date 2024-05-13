package projectC_prototype;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class take_quiz extends quiz_making {
    private int total=0;
    private HashMap<String,String>item_choice;
    private Scanner answer=new Scanner(System.in);
    static final String letter[]={"A","B","C","D"};
    public void quiz_time(Stack<String> question,HashMap<String,String> AnswerKey){
        int a=1;
        for(String i :question){
            System.out.println(a+"."+i);
            String choices[]=choice(i,AnswerKey);
            a++;
            item_choice=new HashMap<String,String>();
            for(int x=0; x!=letter.length;x++){
                System.out.println(letter[x]+"."+choices[x]);
                item_choice.put(letter[x], choices[x]);
            }
            System.out.print("Your Answer: ");
            String x=answer.nextLine().toUpperCase();
            if (AnswerKey.get(item_choice.get(x)).equals(i)){
                total++;
            }
            
        } 
        System.out.println(total);
}

} 