package projectC_prototype;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.spire.doc.Break;
class Window extends JFrame implements ActionListener,MouseListener{
    JButton button;

    JLabel list_library;
    private sql_code sql=new sql_code();
    private Document_search Doc=new Document_search();
    private quiz_making mode =new quiz_making();
    private take_quiz quiz= new take_quiz();
    private quiz_making q=new quiz_making();
    private ArrayList<String> to_delete;

    private JPanel login=new JPanel();
    private JPanel homPanel=new JPanel();

    JLabel for_iconlogin= new JLabel();
    ImageIcon login_logo ;
    JLayeredPane login_layer=new JLayeredPane();


    JLayeredPane home_layer=new JLayeredPane();
    JLabel settings =new JLabel();
    JLabel settings_design =new JLabel();
    JLabel home_setting=new JLabel();
    JLabel library=new JLabel();
    JLabel share=new JLabel();
    JLabel Logout=new JLabel();

    String Title_name;
    int ShareUser_name;
    HashMap <String,Integer> share_Quiz=new HashMap<>();
    JPanel Share_template=new JPanel();
    JComboBox <String> quizname_share;
    JLabel quizname_share_text=new JLabel("Enter the Quiz name or select to share: ");
    JLabel name_share=new JLabel("Enter the user name or user id: ");
    JTextField name_share_input=new JTextField();
    JButton share_button=new JButton("Shere Now");

    JPanel edit_Library=new JPanel();
    JPanel library_paper_edit;
    JScrollPane libray_scroll_edit;
    JCheckBox edit_delete_checkbox;
    JLabel Answer_text_edit;
    JButton multi_Qdelete;
    JLabel Answer_edit;
    JTextField Answer_edit_input ;
    JLabel Question_edit;
    JTextField Question_edit_input ; 
    JButton AQ_button_edit;

    JLabel Title_name_edit;
    JTextField Title_name_edit_input ; 
    JButton Change_Title;



    
    
    Font customFont_library = new Font("Montserrat", Font.BOLD, 13);
    Font customFont_library_delete = new Font("Montserrat", Font.BOLD, 12);

    JPanel library_template=new JPanel();
    JButton delete;
    JButton edit_delete;
    JScrollPane libray_scroll;
    JPanel library_paper;
    JPanel Quiz_template=new JPanel();
    JPanel Quiz_paper;
    JLabel questiontext;
    ButtonGroup multiple_choice;
    JRadioButton ABCD;
    JScrollPane scroll;
    JButton submit;
    HashMap <String,String> answer_sheet=new HashMap<>();
    HashMap<String, Integer> map=new HashMap<>();
    private  HashMap<Integer, String[]> edit_liby= new HashMap<Integer,String[]>();



    static final String letter[]={"A","B","C","D"};
    private HashMap<String,String>item_choice;

    Color IN_button_font_color= Color.decode("#0F0F0F");
    Font IN_text_field_font = new Font("Domine", Font.BOLD, 13);
    Color IN_button_color=Color.decode("#FAF8ED");
    JPanel home_template =new JPanel();
    JFileChooser filebox= new JFileChooser();
    ButtonGroup GbtnH= new ButtonGroup();
    JRadioButton PDFcolor=new JRadioButton("PDF Color");
    JLabel Quizname_text=new JLabel("Enter your Quiz name: ");
    JLabel PDFColor_text=new JLabel("Enter you Text File: ");
    JTextField PDFColor_input=new JTextField();
    JTextField Quizname_input=new JTextField();

    JRadioButton Quiz_adding=new JRadioButton("PDF One by One");
    JLabel question_text=new JLabel("Enter Question: ");
    JTextField question_input=new JTextField();
    JLabel answer_text=new JLabel("Enter Answer: ");
    JTextField answer_input=new JTextField();
    JButton Quiz_adding_Start=new JButton("Start");

    JButton PDFColor_file=new JButton("File");
    JButton StartColor=new JButton("Start");
    JButton note_file=new JButton("File");
    JButton NoteStart=new JButton("Start");
    

    JRadioButton PDFnote=new JRadioButton("PDF Note");

    Color color_plattel= Color.decode("#A2C579");
    Font customFont = new Font("Montserrat", Font.BOLD, 16);
    JButton login_Button=new JButton("Login");
    JButton reset_Button=new JButton("Reset");
    JButton register_Button=new JButton("Register");
    JButton login_back=new JButton("Login");
    JButton create_Button=new JButton("Create Account");
    JLabel use_text=new JLabel("User Name: ");
    JLabel password_text= new JLabel("Password: ");    
    JTextField user_input=new JTextField();
    JPasswordField password_input=new JPasswordField();

    JLabel Conformpassword_text= new JLabel("Conform Password: ");
    JPasswordField Conformpassword_input=new JPasswordField(); 

    ImageIcon logo2= new ImageIcon("D:/Herold UI-2 1st sem/OOP ITE-300/project C/projectC_prototype/logo.png");
    Image newlogo = logo2.getImage();
    int newWidth = 220; 
    int newHeight = 120; 
    Image resizedImg = newlogo.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    JLabel for_logo=new JLabel();

    Window(){
        
        ImageIcon logo= new ImageIcon("D:/Herold UI-2 1st sem/OOP ITE-300/project C/projectC_prototype/logo.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1200, 700);
        this.setResizable(false);
        this.setTitle("QuizCraft");
        this.setIconImage(logo.getImage());
        this.setVisible(true);
        login_window(true);
        home_window(false);
        home_template();
        this.add(home_layer);
        this.add(homPanel);
        this.add(login);
        this.add(login_layer);
        login_layer.add(for_iconlogin,Integer.valueOf(0));
        login_layer.add(login,Integer.valueOf(1));
        for_iconlogin.setText("hello");
        for_iconlogin.setBackground(Color.decode("#fcfdff"));
        login_logo = new ImageIcon("D:/Herold UI-2 1st sem/OOP ITE-300/project C/projectC_prototype/learn_login.png");
        for_iconlogin.setIcon(login_logo);
        for_iconlogin.setBounds(0,0,1200,700);
        login_layer.setBounds(0,0,1200,700);

    }

    

    public void buttoon_main(boolean x){
        button=new JButton();
        button.setBounds(200, 100, 100, 100);
        button.addActionListener(e -> {login_window(true);button.setVisible(false);});
        button.setVisible(x);
    }

    public void Color_extract(){
        String file =PDFColor_input.getText();
        file.replaceAll("\\\\", "/");
        String Quiz_name=Quizname_input.getText();
        if (!Quiz_name.equals("")){
        int Quiz_id=sql.create_quiz(Quiz_name,sql.getUser_id());
        System.out.println(Quiz_id);
        Doc.set_file(file);
        Doc.SetKey();
        Doc.SetValue();
        Doc.extract_texCtolor();
        sql.sql_insert(Doc.GetKey(), Doc.GetValue(), Quiz_id);
        Quizname_input.setText("");
        PDFColor_input.setText("");
        }else{
            System.out.println("Quiz library no name");
        }

    }

    public void Note_extract(){
        String file =PDFColor_input.getText();
        file.replaceAll("\\\\", "/");
        String Quiz_name=Quizname_input.getText();
        if (!Quiz_name.equals("")){
        int Quiz_id=sql.create_quiz(Quiz_name,sql.getUser_id());
        System.out.println(Quiz_id);
        Doc.set_file(file);
        Doc.SetKey();
        Doc.SetValue();
        Doc.note_extraction();
        sql.sql_insert(Doc.GetKey(), Doc.GetValue(), Quiz_id);
        Quizname_input.setText("");
        PDFColor_input.setText("");
        }else{
            System.out.println("Quiz library no name");
        }

    }

    public void Quiz_adding_OneByOne(){
        String Quiz_name=Quizname_input.getText();
        if (!Quiz_name.equals("")){
        int Quiz_id=sql.create_quiz(Quiz_name,sql.getUser_id());
        System.out.println(Quiz_id);
        String value=question_input.getText();
        String key=answer_input.getText();
        sql.sql_insert(key, value, Quiz_id);
        Quizname_input.setText("");
        question_input.setText("");
        answer_input.setText("");
        }else{
            System.out.println("Quiz library no name");
        }

    }    


    public void File_chooser(){
        int response=filebox.showOpenDialog(null);
        if(response==JFileChooser.APPROVE_OPTION){
            String file=filebox.getSelectedFile().getAbsolutePath();
            PDFColor_input.setText(file);
        }
    }

    public void textboxAni(int x){
        PDFColor_text.setVisible(true);
        PDFColor_input.setVisible(true);
        Quizname_text.setVisible(true);
        Quizname_input.setVisible(true);
        question_text.setVisible(false);
        question_input.setVisible(false);
        answer_input.setVisible(false);
        answer_text.setVisible(false);
        Quiz_adding_Start.setVisible(false);
        switch (x) {
            case 1:
                 NoteStart.setVisible(false);
                 note_file.setVisible(false);
                 StartColor.setVisible(true);
                 PDFColor_file.setVisible(true);
                 Quizname_text.setBounds(200, 250, 170, 25);
                 Quizname_input.setBounds(370, 250, 300, 25);
                 PDFColor_file.setBounds(725, 290, 75, 25);
                 PDFColor_text.setBounds(200, 290, 150, 25); 
                 PDFColor_input.setBounds(370, 290, 340, 25);
                 StartColor.setBounds(500, 330,75 , 25);
                 PDFnote.setBounds(200, 350, 200, 30);
                 Quiz_adding.setBounds(200, 400, 200, 30);
                break;
            
            case 2:
                StartColor.setVisible(false);
                PDFColor_file.setVisible(false);
                NoteStart.setVisible(true);
                note_file.setVisible(true);
                PDFnote.setBounds(200, 250, 200, 30);
                Quizname_text.setBounds(200, 300, 170, 25);
                Quizname_input.setBounds(370, 300, 300, 25);
                note_file.setBounds(725, 340, 75, 25);
                PDFColor_text.setBounds(200, 340, 150, 25); 
                PDFColor_input.setBounds(370, 340, 340, 25);
                NoteStart.setBounds(500, 380,75 , 25);
                Quiz_adding.setBounds(200, 410, 200, 30);
                NoteStart.addActionListener(e -> System.out.println("B"));
                    break;
            case 3:
                 question_text.setVisible(true);
                 question_input.setVisible(true);
                 answer_input.setVisible(true);
                 answer_text.setVisible(true);
                 Quiz_adding_Start.setVisible(true);

                 NoteStart.setVisible(false);
                 note_file.setVisible(false);
                 StartColor.setVisible(false);
                 PDFColor_file.setVisible(false);
                 PDFColor_text.setVisible(false); 
                 PDFColor_input.setVisible(false);
                 Quizname_text.setBounds(200, 350, 170, 25);
                 Quizname_input.setBounds(370, 350, 300, 25);
                 StartColor.setBounds(500, 330,75 , 25);
                 PDFnote.setBounds(200, 250, 200, 30);
                 Quiz_adding.setBounds(200, 300, 200, 30);
                 break;       
            default:
                break;
        }

    }

    public void home_template(){
        home_template.setBounds(300, 30, 850, 600);
        home_template.setBackground(color_plattel);
        home_template.setLayout(null);
        home_template.setOpaque(true);

        PDFcolor.setBounds(200, 200, 200, 30);
        PDFcolor.setBackground(color_plattel);
        PDFcolor.setFont(new Font("Bahnschrift Light",Font.ITALIC,25));
        PDFcolor.addActionListener(e ->textboxAni(1));

        PDFColor_file.setFont(customFont);
        PDFColor_file.setForeground(IN_button_font_color);
        PDFColor_file.setBackground(IN_button_color);
        PDFColor_file.setFocusPainted(false); // Remove focus border
        PDFColor_file.setBorderPainted(false);
        PDFColor_file.addActionListener(e -> File_chooser());


        StartColor.setFont(customFont);
        StartColor.setForeground(IN_button_font_color);
        StartColor.setBackground(IN_button_color);
        StartColor.setFocusPainted(false); // Remove focus border
        StartColor.setBorderPainted(false);
        StartColor.addActionListener(e ->Color_extract());

        
        PDFColor_text.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
        Quizname_text.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
        PDFnote.setBounds(200, 250, 200, 30);
        PDFnote.setBackground(color_plattel);
        PDFnote.addActionListener(e ->textboxAni(2));
        PDFnote.setFont(new Font("Bahnschrift Light",Font.ITALIC,25));
        
        note_file.setFont(customFont);
        note_file.setForeground(IN_button_font_color);
        note_file.setBackground(IN_button_color);
        note_file.setFocusPainted(false); // Remove focus border
        note_file.setBorderPainted(false);
        note_file.addActionListener(e-> File_chooser());

        NoteStart.setFont(customFont);
        NoteStart.setForeground(IN_button_font_color);
        NoteStart.setBackground(IN_button_color);
        NoteStart.setFocusPainted(false); // Remove focus border
        NoteStart.setBorderPainted(false);
        NoteStart.addActionListener(e-> Note_extract());
        


        Quiz_adding.setBounds(200, 300, 200, 30);
        Quiz_adding.setBackground(color_plattel);
        Quiz_adding.setFont(new Font("Bahnschrift Light",Font.ITALIC,25));
        question_text.setBounds(200, 390, 150, 25);
        question_text.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
 
        question_input.setBounds(370, 390, 340, 25);
        question_input.setFont(IN_text_field_font);

        answer_text.setBounds(200, 430, 150, 25);
        answer_text.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
 
        answer_input.setBounds(370, 430, 340, 25);
        answer_input.setFont(IN_text_field_font);

        Quiz_adding_Start.setBounds(500, 470,75 , 25);
        Quiz_adding_Start.setFont(customFont);
        Quiz_adding_Start.setForeground(IN_button_font_color);
        Quiz_adding_Start.setBackground(IN_button_color);
        Quiz_adding_Start.setFocusPainted(false); // Remove focus border
        Quiz_adding_Start.setBorderPainted(false);
        Quiz_adding_Start.addActionListener(e-> Quiz_adding_OneByOne());

        Quiz_adding.addActionListener(e ->textboxAni(3));

        Quizname_input.setFont(IN_text_field_font);
        PDFColor_input.setFont(IN_text_field_font);

        
        GbtnH.add(PDFcolor);
        GbtnH.add(PDFnote);
        GbtnH.add(Quiz_adding);
        
        Quizname_text.setVisible(false);
        Quizname_input.setVisible(false);
        PDFColor_text.setVisible(false);
        PDFColor_input.setVisible(false);
        PDFColor_file.setVisible(true);
        NoteStart.setVisible(false);
        note_file.setVisible(false);
        question_text.setVisible(false);
        question_input.setVisible(false);
        answer_input.setVisible(false);
        answer_text.setVisible(false);
        Quiz_adding_Start.setVisible(false);
        StartColor.setVisible(false);

        home_template.add(note_file);
        home_template.add(NoteStart);
        home_template.add(StartColor);
        home_template.add(Quizname_text);
        home_template.add(Quizname_input);
        home_template.add(PDFColor_file);
        home_template.add(PDFColor_input);
        home_template.add(PDFColor_text);
        home_template.add(PDFcolor);
        home_template.add(PDFnote);
        home_template.add(Quiz_adding);
        home_template.add(question_text);
        home_template.add(question_input);
        home_template.add(answer_text);
        home_template.add(answer_input);
        home_template.add(Quiz_adding_Start);
        
    }

    public void Library_button_delete(int library){
        System.out.println(library);
        sql.sql_delete_library(library);
        Library_template();
    }

    public void Library_button(int library){
   
        System.out.println(library);
        answer_sheet.clear();
        Quiz_template.setVisible(true);
        item_choice=new HashMap<String,String>();
        answer_sheet=sql.sql_display(library);
        mode.set_FILO();
        Stack <String> question=mode.get_FILO(answer_sheet);
        library_template.setVisible(false);
        Quiz_template.setBounds(300, 30, 850, 600);
        Quiz_template.setBackground(color_plattel);
        Quiz_template.setLayout(null);
        Quiz_template.setOpaque(true);

        Quiz_template.removeAll();

        Quiz_paper=new JPanel();
        Quiz_paper.setBackground(color_plattel);
        Quiz_paper.setLayout(null);

        Quiz_paper.removeAll();
        int a=1;
        int y= 100;
        for(String i :question){
            System.out.println(a+"."+i);
            String choices[]=q.choice(i,answer_sheet);
            questiontext=new JLabel("<html>"+a+"."+i+"</html>");
            questiontext.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
            questiontext.setBounds(30, y, 600,150 );
            questiontext.setHorizontalAlignment(SwingConstants.LEFT); // Center the text
            questiontext.setVerticalAlignment(SwingConstants.CENTER);
            questiontext.setBorder(new EmptyBorder(0, 0, 0, 0));
            Quiz_paper.add(questiontext);
            int to_ABCD=130;
            multiple_choice= new ButtonGroup();
            for(int x=0; x!=letter.length;x++){
                System.out.println(y);
                final String questionNumber = i;
                final String Answer = choices[x];
                ABCD=new JRadioButton(letter[x]+"."+choices[x]);
                ABCD.setBounds(30, y+to_ABCD, 200,30);
                ABCD.setBackground(color_plattel);
                ABCD.addActionListener(e ->item_choice.put(questionNumber, Answer));
                System.out.println(letter[x]+"."+choices[x]);
                to_ABCD+=40;
                multiple_choice.add(ABCD);
                Quiz_paper.add(ABCD);
            }
            y+=250;
            a++;
        }
        final HashMap<String,String> Answer=answer_sheet;
        submit=new JButton("Submit");
        System.out.println(y);
        submit.setBounds(250, y+60, 150,30);
        submit.addActionListener(e -> Display_Score(item_choice, Answer));
        Quiz_paper.add(submit);
        

        Quiz_paper.setPreferredSize(new Dimension(220, 200 + y));
        scroll=new JScrollPane(Quiz_paper);
        scroll.setBounds(150,10 , 700,580);
        scroll.setBorder(new EmptyBorder(0, 0, 0, 0));

        
        
        Quiz_template.add(scroll);
        Quiz_template.revalidate();    

    
    }

    public void Share_quiz(){
        share_Quiz.clear();
        share_Quiz=sql.sql_library();
        String Quiz_title []=new String[share_Quiz.size()];
        Share_template.setBounds(300, 30, 850, 600);
        Share_template.setBackground(color_plattel);
        Share_template.setLayout(null);
        Share_template.setOpaque(true);
        Iterator<Entry<String, Integer>> Quiz= share_Quiz.entrySet().iterator();
       for (int i = 0; i < Quiz_title.length; i++) {
            if(Quiz.hasNext()){
                Map.Entry<String, Integer> Quiz_new= (Entry<String, Integer>)Quiz.next();
                Quiz_title[i]=Quiz_new.getKey();
       }
    }
        quizname_share=new JComboBox <String>(Quiz_title);
        quizname_share.setEditable(true);
        
        quizname_share.addActionListener(e-> {Title_name=(String)quizname_share.getSelectedItem();});
        quizname_share.setBounds(410,230,350,30);
        quizname_share_text.setBounds(170,230,250,30);
        quizname_share_text.setFont(new Font("Bahnschrift Light",Font.BOLD,13));
        
        name_share.setBounds(170,280,250,30);
        name_share.setFont(new Font("Bahnschrift Light",Font.BOLD,13));
        
        name_share_input.setBounds(410,280,350,30);
        name_share_input.setFont(IN_text_field_font);

        
        share_button.setBounds(410,330,150,30);button.setFont(customFont_library);
        share_button.setForeground(IN_button_font_color);
        share_button.setBackground(IN_button_color);
        share_button.setFocusPainted(false); // Remove focus border
        share_button.setBorderPainted(false);
        share_button.addActionListener(e-> {Start_Sharing(Title_name);});

        Share_template.add(quizname_share_text);
        Share_template.add(quizname_share);
        Share_template.add(name_share);
        Share_template.add(name_share_input);
        Share_template.add(share_button);

    }

    public void Start_Sharing(String Quiz_title){
        String get_userid=name_share_input.getText();
        try{
        int user = Integer.parseInt(get_userid);
        if(sql.SQLShare_quiz(Quiz_title,user)){
            JOptionPane.showMessageDialog(
                null,
                "Sharing Complete",
                "share",
                JOptionPane.INFORMATION_MESSAGE
            );
        }else{
            JOptionPane.showMessageDialog(
                null,
                "Sharing Failed The User name or User I'd did not exist",
                "share",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
        
        }catch (NumberFormatException ex){
            if (sql.SQLShare_quiz(Quiz_title,get_userid)){
                JOptionPane.showMessageDialog(
                    null,
                    "Sharing Complete",
                    "share",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }else{
                JOptionPane.showMessageDialog(
                    null,
                    "Sharing Failed The User name or User I'd did not exist",
                    "share",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        }

    }

    public void Display_Score(HashMap<String,String> Answer,HashMap<String,String> Answer_key){
        int total=0;
        //ScoreWindow score= new ScoreWindow();
        for (Map.Entry<String, String> set :Answer.entrySet()) {
            if(Answer_key.get(set.getValue()).equals(set.getKey())){
                total++;
            }
        }
        //score.setScore(total);
        JOptionPane.showMessageDialog(
            null,
            "Congratulations!\nYour score is: " + total,
            "Score Window",
            JOptionPane.INFORMATION_MESSAGE
        );
        Quiz_template.setVisible(false);
        library_template.setVisible(true);

        
    }

    public void Library_template(){
        Quiz_template.setVisible(false);
        edit_Library.setVisible(false);
        map.clear();
        library_template.setBounds(300, 30, 850, 600);
        library_template.setBackground(color_plattel);
        library_template.setLayout(null);
        library_template.setOpaque(true);
        library_template.removeAll();
        library_paper=new JPanel();
        library_paper.setBackground(color_plattel);
        library_paper.setLayout(null);
        int y=20;
        library_paper.removeAll();
        map = sql.sql_library();
        System.out.println("Library Data: " + map);
        for (Map.Entry<String,Integer> data : map.entrySet()) {
            list_library =new JLabel(data.getKey());
            button=new JButton("Start Quiz");
            delete=new JButton("Delete Quiz");
            edit_delete=new JButton("Edit ");
            
            button.setBounds(220, y, 100, 25);
            button.setFont(customFont_library);
            button.setForeground(IN_button_font_color);
            button.setBackground(IN_button_color);
            button.setFocusPainted(false); // Remove focus border
            button.setBorderPainted(false);
            button.addActionListener(e->Library_button(data.getValue()));
            
            delete.setBounds(555, y, 102, 25);
            delete.setFont(customFont_library_delete);
            delete.setForeground(IN_button_font_color);
            delete.setBackground(IN_button_color);
            delete.setFocusPainted(false); // Remove focus border
            delete.setBorderPainted(false);
            delete.addActionListener(e->Library_button_delete(data.getValue()));

            edit_delete.setBounds(390, y, 100, 25);
            edit_delete.setFont(customFont_library);
            edit_delete.setForeground(IN_button_font_color);
            edit_delete.setBackground(IN_button_color);
            edit_delete.setFocusPainted(false); // Remove focus border
            edit_delete.setBorderPainted(false);
            edit_delete.addActionListener(e->Library_Edit(data.getValue()));
            
            list_library.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
            list_library.setBounds(30, y, 200, 30);
            library_paper.add(button);
            library_paper.add(list_library);
            library_paper.add(delete);
            library_paper.add(edit_delete);


            y+=50;
        }
        library_paper.setPreferredSize(new Dimension(220, 10+ y));
        libray_scroll=new JScrollPane(library_paper);
        libray_scroll.setBounds(150,10 , 700,580);
        libray_scroll.setBorder(new EmptyBorder(0, 0, 0, 0));

        
        library_template.add(libray_scroll);
        library_template.revalidate();  
    }

    public void Library_Edit(int library){
        edit_Library.setVisible(true);
        Quiz_template.setVisible(false);
        library_template.setVisible(false);
        edit_liby.clear();
        to_delete=new ArrayList<String>();
        edit_Library.setBounds(300, 30, 850, 600);
        edit_Library.setBackground(color_plattel);
        edit_Library.setLayout(null);
        edit_Library.setOpaque(true);
        edit_Library.removeAll();
        library_paper_edit=new JPanel();
        library_paper_edit.setBackground(color_plattel);
        library_paper_edit.setLayout(null);
        library_paper_edit.removeAll();
        edit_liby = sql.sql_Edit(library);
        System.out.println("Library Data: " + edit_liby);
        ItemListener checkboxListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JCheckBox source = (JCheckBox) e.getItemSelectable();
                String to_add=source.getText();
                to_add=to_add.replaceAll("<html>Q: ", "");
                to_add=to_add.replaceAll("</html>", "");
                System.out.println(to_add);
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    to_delete.add(to_add);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    to_delete.remove(to_add);
                }
            }
        };

        List<JTextField> answerInputs = new ArrayList<>();
        List<JTextField> questionInputs = new ArrayList();
        int y=200;
        for (Entry<Integer, String[]> data : edit_liby.entrySet()) {
            int id=data.getKey();
            final String [] key_value=data.getValue();
            System.out.println(Arrays.toString(key_value));
            final String value=key_value[0];
            final String key=key_value[1];
            edit_delete_checkbox =new JCheckBox("<html>"+"Q: "+value+"</html>");
            Answer_text_edit=new JLabel("A: "+key);
            Answer_edit=new JLabel("Enter Edit Answer: ");
            Answer_edit_input=new JTextField(key) ;
            Question_edit=new JLabel("Enter Edit Question: ");
            Question_edit_input=new JTextField(value);
            AQ_button_edit=new JButton("Start Edit");



            edit_delete_checkbox.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
            edit_delete_checkbox.setBounds(30, y, 600,50 );
            edit_delete_checkbox.setHorizontalAlignment(SwingConstants.LEFT); // Center the text
            edit_delete_checkbox.setVerticalAlignment(SwingConstants.CENTER);
            edit_delete_checkbox.setBorder(new EmptyBorder(0, 0, 0, 0));
            edit_delete_checkbox.setBackground(color_plattel);
            edit_delete_checkbox.addItemListener(checkboxListener);


            Answer_text_edit.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
            Answer_text_edit.setBounds(50, y+50, 600,30 );

            Answer_edit.setBounds(70, y+150, 150, 25);
            Answer_edit.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
 
            Answer_edit_input.setBounds(220, y+150, 340, 25);
            Answer_edit_input.setFont(IN_text_field_font);
            
            Question_edit.setBounds(70, y+100, 150, 25);
            Question_edit.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
 
            Question_edit_input.setBounds(220, y+100, 340, 25);
            Question_edit_input.setFont(IN_text_field_font);
            

            AQ_button_edit.setBounds(300, y+200, 102, 25);
            AQ_button_edit.setFont(customFont_library_delete);
            AQ_button_edit.setForeground(IN_button_font_color);
            AQ_button_edit.setBackground(IN_button_color);
            AQ_button_edit.setFocusPainted(false); // Remove focus border
            AQ_button_edit.setBorderPainted(false);
            answerInputs.add(Answer_edit_input);
            questionInputs.add(Question_edit_input);
            final int index=y/300;
            AQ_button_edit.addActionListener(e -> {
                // Retrieve the values from the corresponding text fields
                String newAnswer = answerInputs.get(index).getText();
                String newQuestion = questionInputs.get(index).getText();
    
                // Now you can use newAnswer and newQuestion in your Quiz_update method
                Quiz_update(id, newAnswer, newQuestion, library);
            });
            

            library_paper_edit.add(Answer_text_edit);
            library_paper_edit.add(edit_delete_checkbox);
            library_paper_edit.add(Answer_edit_input);
            library_paper_edit.add(Answer_edit);
            library_paper_edit.add(Question_edit);
            library_paper_edit.add(Question_edit_input);
            library_paper_edit.add(AQ_button_edit);
            y+=300;
        }
        multi_Qdelete=new JButton("Delete");
        multi_Qdelete.setBounds(250, y+100, 102, 25);
        multi_Qdelete.setFont(customFont_library_delete);
        multi_Qdelete.setForeground(IN_button_font_color);
        multi_Qdelete.setBackground(IN_button_color);
        multi_Qdelete.setFocusPainted(false); // Remove focus border
        multi_Qdelete.setBorderPainted(false);
        multi_Qdelete.addActionListener(e->{sql.sql_delete_library(to_delete); Library_Edit(library);});
        String x= sql.sql_Quiz_name(library);
        Title_name_edit=new JLabel("Enter your new Title :");
        Title_name_edit_input=new JTextField(x);
        Change_Title=new JButton("Edit Title");
        Title_name_edit.setBounds(70, 100, 170, 25);
        Title_name_edit.setFont(new Font("Bahnschrift Light",Font.BOLD,15));

        Title_name_edit_input.setBounds(250, 100, 340, 25);
        Title_name_edit_input.setFont(IN_text_field_font);

        Change_Title.setBounds(300, 130, 102, 25);
        Change_Title.setFont(customFont_library_delete);
        Change_Title.setForeground(IN_button_font_color);
        Change_Title.setBackground(IN_button_color);
        Change_Title.setFocusPainted(false); // Remove focus border
        Change_Title.setBorderPainted(false);
        Change_Title.addActionListener(e-> {sql.sql_Quiz_name(library, Title_name_edit_input.getText()); Library_Edit(library);});
        
        library_paper_edit.add(Title_name_edit);
        library_paper_edit.add(Title_name_edit_input);
        library_paper_edit.add(Change_Title);

        library_paper_edit.add(multi_Qdelete);
        library_paper_edit.setPreferredSize(new Dimension(220, 200+ y));
        libray_scroll_edit=new JScrollPane(library_paper_edit);
        libray_scroll_edit.setBounds(150,10 , 700,580);
        libray_scroll_edit.setBorder(new EmptyBorder(0, 0, 0, 0));

        
        edit_Library.add(libray_scroll_edit);
        edit_Library.revalidate();  
    }

    public void Quiz_update(int id,String key,String value,int library ){
        System.out.println(key+"--------------------------------------------:"+value);
        sql.sql_EditQ(id, key, value);
        Library_Edit(library);
    }


    public void home_window(boolean z){
        homPanel.setBounds(30,30,1120,600);
        homPanel.setBackground(new Color(0,0,0,0));
        homPanel.setLayout(null);
        home_layer.setBounds(0, 0, 1200, 700);
        settings.setBounds(80, 10, 300, 640);
        settings.setOpaque(true);
        settings.setBackground(new Color(102, 191, 250,100));

        home_setting.setText("Home");
        home_setting.setBounds(30, 220, 300, 60);
        home_setting.setFont(new Font("Impact",Font.PLAIN,30));
        home_setting.addMouseListener(this);

        library.setText("Library");
        library.setBounds(30, 280, 300, 60);
        library.setFont(new Font("Impact",Font.PLAIN,30));
        library.addMouseListener(this);

        for_logo.setBounds(120, 10, 230, 150);
        ImageIcon resizedIcon = new ImageIcon(resizedImg);
        for_logo.setIcon(resizedIcon);


        share.setText("Share");
        share.setBounds(30, 340, 300, 60);
        share.setFont(new Font("Impact",Font.PLAIN,30));
        share.addMouseListener(this);

        Logout.setText("Logout");
        Logout.setBounds(30, 400, 300, 60);
        Logout.setFont(new Font("Impact",Font.PLAIN,30));
        Logout.addMouseListener(this);
        
        settings.add(Logout);
        settings.add(share);
        settings.add(home_setting);
        settings.add(library);

        settings_design.setBounds(60,160,380,50);
        settings_design.setOpaque(true);
        settings_design.setBackground(Color.decode("#FFFFDD"));
        settings_design.setVerticalTextPosition(JLabel.CENTER);
        settings_design.setVerticalAlignment(JLabel.CENTER);
        settings_design.setHorizontalAlignment(JLabel.CENTER);
        
        home_layer.add(home_template,Integer.valueOf(0));
        home_layer.add(for_logo,Integer.valueOf(2));
        home_layer.add(Quiz_template,Integer.valueOf(0));
        home_layer.add(edit_Library,Integer.valueOf(0));
        home_layer.add(library_template,Integer.valueOf(0));
        home_layer.add(Share_template,Integer.valueOf(0));
        home_template.setVisible(true);
        home_layer.add(settings,Integer.valueOf(1));
        home_layer.add(settings_design,Integer.valueOf(2));

        home_layer.setVisible(z);
        homPanel.setVisible(z);
    }

    public void login_window(boolean y){
        login.setBounds(360,(1200-1000)/2,490 ,500);
        login.setBackground(new Color(0,0,0,0));
        login.setLayout(null);

        use_text.setBounds(30, 150, 75, 25);
        use_text.setFont(new Font("Montserrat", Font.BOLD, 13));
        password_text.setBounds(30, 200, 75, 25);
        password_text.setFont(new Font("Montserrat", Font.BOLD, 13));

        //message_text.setBounds(350,300,250,35);
        //message_text.setFont(new Font(null,Font.ITALIC,25));

        user_input.setBounds(150, 150, 300, 30);
        user_input.setBackground(new Color(6,10,13,200));
        user_input.setForeground(Color.WHITE);
        user_input.setFont(customFont);

        password_input.setBounds(150, 200, 300,30);
        password_input.setBackground(new Color(6,10,13,200));
        password_input.setForeground(Color.WHITE);
        password_input.setFont(customFont);

        login_Button.setBounds(75, 250, 100, 25);
        login_Button.setFont(customFont);
        login_Button.setForeground(Color.WHITE);
        login_Button.setBackground(new Color(97,163,186));
        login_Button.setFocusPainted(false); // Remove focus border
        login_Button.setBorderPainted(false);
        login_Button.addActionListener(this);

        register_Button.setBounds(300,250, 100, 25);
        register_Button.setFont(customFont);
        register_Button.setForeground(Color.WHITE);
        register_Button.setBackground(new Color(97,163,186));
        register_Button.setFocusPainted(false); // Remove focus border
        register_Button.setBorderPainted(false);
        register_Button.addActionListener(this);

        Conformpassword_text.setBounds(10, 250, 300, 25);
        Conformpassword_text.setFont(new Font("Montserrat", Font.BOLD, 13));

        Conformpassword_input.setBounds(150, 250, 300, 25);
        Conformpassword_input.setBackground(new Color(6,10,13,200));
        Conformpassword_input.setForeground(Color.WHITE);
        Conformpassword_input.setFont(customFont);


        login_back.setBounds(220, 350, 100, 25);
        login_back.setFont(customFont);
        login_back.setForeground(Color.WHITE);
        login_back.setBackground(new Color(97,163,186));
        login_back.setFocusPainted(false); // Remove focus border
        login_back.setBorderPainted(false);
        login_back.addActionListener(this);

        create_Button.setBounds(200,300, 150, 25);
        create_Button.setFont(new Font("Arial", Font.BOLD, 14));
        create_Button.setForeground(Color.WHITE);
        create_Button.setBackground(new Color(97,163,186));
        create_Button.setFocusPainted(false); // Remove focus border
        create_Button.setBorderPainted(false);
        create_Button.addActionListener(this);
        
        login.add(use_text);
        login.add(password_text);
        login.add(Conformpassword_text);
        login.add(user_input);
        login.add(password_input);
        login.add(Conformpassword_input);
        login.add(login_Button);
        login.add(register_Button);
        login.add(login_back);
        login.add(create_Button);
        login.setVisible(y);
        register_Button.setVisible(true);
        login_Button.setVisible(true);
        create_Button.setVisible(false);
        login_back.setVisible(false);
        Conformpassword_input.setVisible(false);
        Conformpassword_text.setVisible(false);
    }

    public void register_window(){        SwingUtilities.getRoot(login).repaint(); // Repaint the root component (e.g., the JFrame)

        register_Button.setVisible(false);
        login_Button.setVisible(false);
        create_Button.setVisible(true);
        login_back.setVisible(true);
        Conformpassword_input.setVisible(true);
        Conformpassword_text.setVisible(true);
    }

    public void back_login(){
        SwingUtilities.getRoot(login).repaint(); // Repaint the root component (e.g., the JFrame)
        register_Button.setVisible(true);
        login_Button.setVisible(true);
        create_Button.setVisible(false);
        login_back.setVisible(false);
        Conformpassword_input.setVisible(false);
        Conformpassword_text.setVisible(false);
    }

    public void Create_Account(){
            String username=user_input.getText();
            String password=String.valueOf(password_input.getPassword());
            String conpass=String.valueOf(Conformpassword_input.getPassword());
            System.out.println(username+":"+password);
            if (password.equals(conpass)){
                String text_alert=sql.sql_createUser(username, conpass);
                System.out.println(text_alert);

                switch(text_alert){
                    case "The username is Already Exists":
                    
                    JOptionPane.showMessageDialog(
    null,
                    text_alert,
              "Create Error",
                    JOptionPane.INFORMATION_MESSAGE
                    );
                    user_input.setText("");
                    password_input.setText(password);
                    Conformpassword_input.setText(conpass);
                    break;

                    case "The password is Already Exists":
                        JOptionPane.showMessageDialog(
                        null,
                        text_alert,
                        "Create Error",
                        JOptionPane.INFORMATION_MESSAGE
                        );
                        user_input.setText(username);
                        password_input.setText("");
                        Conformpassword_input.setText("");
                        break;

                    case "successfully registered":
                        JOptionPane.showMessageDialog(
                        null,
                        text_alert,
                        "Create Error",
                        JOptionPane.INFORMATION_MESSAGE
                        );
                        break;
                    default:
                        JOptionPane.showMessageDialog(
                        null,
                        "There is error in the System Contact the programmer ",
                        "Create Error",
                        JOptionPane.INFORMATION_MESSAGE
                        );
                        break;

                
                    }
                }else{
                JOptionPane.showMessageDialog(
                null,
                "Password not match",
                "Create Error",
                JOptionPane.INFORMATION_MESSAGE
                );
                user_input.setText(username);
                password_input.setText("");
                Conformpassword_input.setText("");
            }
            SwingUtilities.getRoot(login).repaint(); // Repaint the root component (e.g., the JFrame)

            
            
    }

    public void login_Account(){
            String username=user_input.getText();
            String password=String.valueOf(password_input.getPassword());
            System.out.println(username+":"+password);
            String text_alert =sql.sql_login(username, password);
            settings_design.setText("Username: "+sql.getUser_name());
            switch (text_alert) {
                case "The username or password you entered is incorrect":
                    JOptionPane.showMessageDialog(
    null,
                    text_alert,
              "Login Error",
                    JOptionPane.INFORMATION_MESSAGE
                    );
                    user_input.setText("");
                    password_input.setText("");
                   

                    break;
                
                case "The password you’ve entered is incorrect":
                    JOptionPane.showMessageDialog(
    null,
                    text_alert,
              "Login Error",
                    JOptionPane.INFORMATION_MESSAGE
                    );
                    password_input.setText("");
                    break;

                case "login success":
                    user_input.setText("");
                    password_input.setText("");
                    login.setVisible(false);
                    home_layer.setVisible(true);
                    homPanel.setVisible(true);
                    break;
                default:
                    JOptionPane.showMessageDialog(
    null,
            "There is error in the System Contact the programmer ",
              "Login Error",
                    JOptionPane.INFORMATION_MESSAGE
                    );
                    break;
            }
            SwingUtilities.getRoot(login).repaint(); // Repaint the root component (e.g., the JFrame)

    } 


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==register_Button){
            register_window();

        }
        if (e.getSource()==login_back){
            back_login();
        }
        if (e.getSource()==create_Button){
            Create_Account();
        }
        if (e.getSource()==login_Button){
            login_Account();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getSource()==Logout);
        if (e.getSource()==Logout){
            home_layer.setVisible(false);
            homPanel.setVisible(false);
            Share_template.setVisible(false);
        login.setVisible(true);
            
        }else if(e.getSource()==home_setting){
            library_template.setVisible(false);
            Share_template.setVisible(false);
            home_template.setVisible(true);

        }else if(e.getSource()==library){
            home_template.setVisible(false);
            Share_template.setVisible(false);
            library_template.setVisible(true);
            Library_template();
        }else if(e.getSource()==share){
            home_template.setVisible(false);
            library_template.setVisible(false);
            Share_template.setVisible(true);
            Share_quiz();
        }
        //throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }



}

class testwindow extends Window{

}

public class desing{
    public static void main(String[] args) {
        new Window();
    }


}
