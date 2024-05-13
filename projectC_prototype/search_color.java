package projectC_prototype;
import com.spire.doc.Document;
import com.spire.doc.DocumentObject;
import com.spire.doc.Section;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.fields.TextRange;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
class Document_search extends Document{
private Document File = new Document();;
private ArrayList<String> key_list;
private ArrayList<String> value_list;

 public void set_file(String x){
    File.loadFromFile(x);
}  

public void SetKey(){
    this.key_list=new ArrayList<>();
}

public ArrayList<String> GetKey(){
    return key_list;
}
public void SetValue(){
    this.value_list=new ArrayList<>();
}

public ArrayList<String> GetValue(){
    return value_list;
}

 public void extract_texCtolor(){
   
    //Loop through all sections in the document
    for(Section section :(Iterable<Section>)File.getSections()){
        //Loop through all paragraphs in each section
        for(Paragraph paragraph : (Iterable<Paragraph>) section.getBody().getParagraphs())
        {
            //Loop through all child objects in each paragraph
            for(DocumentObject obj : (Iterable<DocumentObject>) paragraph.getChildObjects())
            {
                //Check if the current child object is of TextRange type
                if (obj instanceof TextRange)
                {
                    TextRange textRange = (TextRange) obj;
                    //Check if the text range is highlighted with a specific color
                    if (textRange.getCharacterFormat().getHighlightColor().equals(Color.YELLOW)){
                        //Get the highlighted text
                        String highlightedYellow = textRange.getText();
                        this.key_list.add(highlightedYellow);
                    }

                     if (textRange.getCharacterFormat().getHighlightColor().equals(Color.BLUE)){
                        //Get the highlighted text
                        String highlightedBlue = textRange.getText();
                        this.value_list.add(highlightedBlue);
                    }

                }
            }
        }
    }
}

public void note_extraction(){
    for(Section section :(Iterable<Section>)File.getSections()){
        //Loop through all paragraphs in each section
        for(Paragraph paragraph : (Iterable<Paragraph>) section.getBody().getParagraphs())
        {
            String parag =paragraph.getText();
            try{
            String[] list=parag.split("::",2);
            list[1]=list[1];
            list[0]=list[0];
            if(!parag.equals("")){
            this.key_list.add(list[0]);
            this.value_list.add(list[1]);
        }
        }catch(ArrayIndexOutOfBoundsException e){

        }


        }
    }
}

}





public class search_color {
    public static void main(String[] args) {
        Document_search name =new Document_search();
        Document_search name1 =new Document_search();
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Level 2 DFD", "It shows how the data flows within the main process of the system");
        
        name.set_file("D:/Herold UI-2 1st sem/OOP ITE-300/doc to test/ITE 083 Handouts Midterm.docx");
        name.SetKey();
        name.SetValue();
        name.extract_texCtolor();
        System.out.println(name.GetKey()+":"+name.GetValue());
        name.set_file("D:/Herold UI-2 1st sem/OOP ITE-300/project c image/Herold mel.docx");
        name.SetKey();
        name.SetValue();
        name.note_extraction();
        System.out.println(name.GetKey()+":"+name.GetValue());


        sql_code test=new sql_code();
        quiz_making test_listquiz=new quiz_making();
        test_listquiz.set_FIFO();
        System.out.println(test_listquiz.get_FIFO(test.sql_display(12)));
        test_listquiz.set_FILO();
        long start = System.nanoTime();
        long end = System.nanoTime();
        long elapsedTime = end - start;
        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
        System.out.println(elapsedTimeInSecond + " seconds");
        take_quiz time=new take_quiz();
        time.quiz_time(test_listquiz.get_FILO(test.sql_display(12)),test.sql_display(12));
        
        
        
    }
}
