package projectC_prototype;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
public class quiz_making {
    private Stack<String>FILO;
    private Queue<String> FIFO;
    private Random rand = new Random();
    static final String letter[]={"A","B","C","D"};
    public void set_FILO(){
        this.FILO=new Stack<String>();
    }

    public Stack<String> get_FILO(HashMap<String,String> question){
        this.FILO.addAll(question.values());
        return this.FILO;
    }

     public void set_FIFO(){
        this.FIFO=new LinkedList<String>();
    }

    public Queue<String> get_FIFO(HashMap<String,String> question){
        for(String i :question.values()){
            this.FIFO.add(i);
        }
        return this.FIFO;
    }

    public String[] choice(String question,HashMap<String,String> AnswerKey){
        String answer=null;
        
        for(Entry<String,String> i:AnswerKey.entrySet()){
            if (i.getValue().equals(question)){
                answer=i.getKey();
                break;
            }
        }
        String[] list=AnswerKey.keySet().toArray(new String[AnswerKey.size()]);
        String choices[]=new String[4];
        for(int i=0;i!=choices.length;i++){
            int x=this.rand.nextInt(0,AnswerKey.size());
            while(true){
                if (list.length<=4&&!Arrays.stream(choices).anyMatch(list[x]::equals)){
                     choices[i]=list[x];
                     break;
                }
                else if(answer!=list[x]&& !Arrays.stream(choices).anyMatch(list[x]::equals)){
                     choices[i]=list[x];
                     System.out.println(Arrays.toString(choices));
                    break;
                }else{
                 x=this.rand.nextInt(0,AnswerKey.size());
                 break;
                }
            }
             if (i==3&&!Arrays.stream(choices).anyMatch(answer::equals)){
                    x=this.rand.nextInt(0,3);
                    choices[x]=answer;
                }
            }
            return choices;
        }


    }


/*package projectC_prototype;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class take_quiz extends quiz_making {
    private int total=0;
    private HashMap<String,String>item_choice;
    private Scanner answer=new Scanner(System.in);
    static final String letter[]={"A","B","C","D"};
    private Window app =new Window();
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

} */    