/*package projectC_prototype;

public class back_up {
    package projectC_prototype;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

    
    
    
    JPanel library_template=new JPanel();
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


    static final String letter[]={"A","B","C","D"};
    private HashMap<String,String>item_choice;


    JPanel home_template =new JPanel();
    JFileChooser filebox= new JFileChooser();
    ButtonGroup GbtnH= new ButtonGroup();
    JRadioButton PDFcolor=new JRadioButton("PDF Color");
    JLabel Quizname_text=new JLabel("Enter your Quiz name: ");
    JLabel PDFColor_text=new JLabel("Enter you Text File: ");
    JTextField PDFColor_input=new JTextField();
    JTextField Quizname_input=new JTextField();
    JButton PDFColor_file=new JButton("File");
    JButton note_file=new JButton("File");
    JButton StartColor=new JButton("Start");

    JButton NoteStart=new JButton("Start");
    

    JRadioButton PDFnote=new JRadioButton("PDF Note");
    JRadioButton Quiz_adding=new JRadioButton("PDF Note");

    

    JButton login_Button=new JButton("Login");
    JButton reset_Button=new JButton("Reset");
    JButton register_Button=new JButton("Register");
    JButton login_back=new JButton("Login");
    JButton create_Button=new JButton("Create Account");
    JLabel use_text=new JLabel("User Name: ");
    JLabel password_text= new JLabel("Password: ");    
    JLabel message_text=new JLabel("");
    JTextField user_input=new JTextField();
    JPasswordField password_input=new JPasswordField();

    JLabel Conformpassword_text= new JLabel("Conform Password: ");
    JPasswordField Conformpassword_input=new JPasswordField(); 

    Window(){


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1200, 700);
        this.setVisible(true);
        login_window(true);
        //home_window(false);
        //home_template();
        //this.add(home_layer);
        //this.add(homPanel);
        this.add(login);
        this.add(login_layer);
        login_layer.add(for_iconlogin,Integer.valueOf(0));
        login_layer.add(login,Integer.valueOf(1));
        for_iconlogin.setText("hello");
        for_iconlogin.setBackground(Color.decode("#fcfdff"));
        login_logo = new ImageIcon("D:/Herold UI-2 1st sem/OOP ITE-300/project C/projectC_prototype/login_icon.png");
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
                PDFColor_text.setBounds(200, 300, 150, 25);
                PDFColor_input.setBounds(350, 300, 325, 25);
                Quizname_text.setBounds(200, 300, 170, 25);
                Quizname_input.setBounds(370, 300, 300, 25);
                note_file.setBounds(725, 340, 75, 25);
                PDFColor_text.setBounds(200, 340, 150, 25); 
                PDFColor_input.setBounds(370, 340, 340, 25);
                NoteStart.setBounds(500, 380,75 , 25);
                Quiz_adding.setBounds(200, 410, 200, 30);
                NoteStart.addActionListener(e -> System.out.println("B"));
                    break;
            default:
                break;
        }

    }

    public void home_template(){
        home_template.setBounds(300, 30, 850, 600);
        home_template.setBackground(Color.decode("#FF7676"));
        home_template.setLayout(null);
        home_template.setOpaque(true);

        PDFcolor.setBounds(200, 200, 200, 30);
        PDFcolor.setBackground(Color.decode("#FF7676"));
        PDFcolor.setFont(new Font("Bahnschrift Light",Font.ITALIC,25));
        PDFcolor.addActionListener(e ->textboxAni(1));
        PDFColor_file.addActionListener(e -> File_chooser());
        StartColor.addActionListener(e ->Color_extract());

        
        PDFColor_text.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
        Quizname_text.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
        PDFnote.setBounds(200, 250, 200, 30);
        PDFnote.setBackground(Color.decode("#FF7676"));
        PDFnote.addActionListener(e ->textboxAni(2));
        PDFnote.setFont(new Font("Bahnschrift Light",Font.ITALIC,25));
        note_file.addActionListener(e-> File_chooser());


        Quiz_adding.setBounds(200, 300, 200, 30);
        Quiz_adding.setBackground(Color.decode("#FF7676"));
        Quiz_adding.setFont(new Font("Bahnschrift Light",Font.ITALIC,25));
        Quiz_adding.addActionListener(e ->System.out.println("This is a Quiz_adding"));
        
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
        Quiz_template.setBackground(Color.decode("#836efa"));
        Quiz_template.setLayout(null);
        Quiz_template.setOpaque(true);

        Quiz_template.removeAll();

        Quiz_paper=new JPanel();
        Quiz_paper.setBackground(Color.decode("#836efa"));
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
            int to_ABCD=80;
            multiple_choice= new ButtonGroup();
            for(int x=0; x!=letter.length;x++){
                System.out.println(y);
                final String questionNumber = i;
                final String Answer = choices[x];
                ABCD=new JRadioButton(letter[x]+"."+choices[x]);
                ABCD.setBounds(30, y+to_ABCD, 200,30);
                ABCD.setBackground(Color.decode("#836efa"));
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
        submit.setBounds(250, y+30, 150,30);
        submit.addActionListener(e -> Display_Score(item_choice, Answer));
        Quiz_paper.add(submit);
        

        Quiz_paper.setPreferredSize(new Dimension(220, 200 + y));
        scroll=new JScrollPane(Quiz_paper);
        scroll.setBounds(150,10 , 700,580);
        
        Quiz_template.add(scroll);
        Quiz_template.revalidate();    

    
    }

    public void Share_quiz(){
        share_Quiz.clear();
        share_Quiz=sql.sql_library();
        String Quiz_title []=new String[share_Quiz.size()];
        Share_template.setBounds(300, 30, 850, 600);
        Share_template.setBackground(Color.decode("#A2C579"));
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
        
        share_button.setBounds(410,330,150,30);
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
        map.clear();
        library_template.setBounds(300, 30, 850, 600);
        library_template.setBackground(Color.decode("#e170fa"));
        library_template.setLayout(null);
        library_template.setOpaque(true);
        library_template.removeAll();
        library_paper=new JPanel();
        library_paper.setBackground(Color.decode("#e170fa"));
        library_paper.setLayout(null);
        int y=150;
        library_paper.removeAll();
        map = sql.sql_library();
        System.out.println("Library Data: " + map);
        for (Map.Entry<String,Integer> data : map.entrySet()) {
            list_library =new JLabel(data.getKey());
            button=new JButton("Start Quiz");
            button.setBounds(555, y, 100, 25);
            button.addActionListener(e->Library_button(data.getValue()));
            list_library.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
            list_library.setBounds(30, y, 200, 30);
            library_paper.add(button);
            library_paper.add(list_library);
            y+=50;
        }
        library_paper.setPreferredSize(new Dimension(220, 10+ y));
        libray_scroll=new JScrollPane(library_paper);
        libray_scroll.setBounds(150,10 , 700,580);
        
        library_template.add(libray_scroll);
        library_template.revalidate();    
    }


    public void home_window(boolean z){
        homPanel.setBounds(30,30,1120,600);
        homPanel.setBackground(Color.decode("#C0C0C0"));
        homPanel.setLayout(null);
        home_layer.setBounds(0, 0, 1200, 700);
        settings.setBounds(80, 10, 300, 640);
        settings.setOpaque(true);
        settings.setBackground(Color.decode("#66bffa"));

        home_setting.setText("Home");
        home_setting.setBounds(30, 220, 300, 60);
        home_setting.setFont(new Font("Impact",Font.PLAIN,30));
        home_setting.addMouseListener(this);

        library.setText("Library");
        library.setBounds(30, 280, 300, 60);
        library.setFont(new Font("Impact",Font.PLAIN,30));
        library.addMouseListener(this);

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
        settings_design.setBackground(Color.decode("#FF69B4"));
        settings_design.setVerticalTextPosition(JLabel.CENTER);
        settings_design.setVerticalAlignment(JLabel.CENTER);
        settings_design.setHorizontalAlignment(JLabel.CENTER);
        
        home_layer.add(home_template,Integer.valueOf(0));
        home_layer.add(Quiz_template,Integer.valueOf(0));
        home_layer.add(library_template,Integer.valueOf(0));
        home_layer.add(Share_template,Integer.valueOf(0));
        home_template.setVisible(true);
        home_layer.add(settings,Integer.valueOf(1));
        home_layer.add(settings_design,Integer.valueOf(2));

        home_layer.setVisible(z);
        homPanel.setVisible(z);
    }
    

    public void login_window(boolean y){
        login.setBounds((700-400)/2,(1200-1000)/2,900 ,500);
        login.setBackground(new Color(100,100,100,12));
        login.setLayout(null);

        use_text.setBounds(300, 150, 75, 25);
        password_text.setBounds(300, 200, 75, 25);
        //message_text.setBounds(350,300,250,35);
        //message_text.setFont(new Font(null,Font.ITALIC,25));

        user_input.setBounds(375, 150, 300, 25);
        password_input.setBounds(375, 200, 300, 25);

        login_Button.setBounds(375, 250, 100, 25);
        login_Button.addActionListener(this);

        register_Button.setBounds(575,250, 100, 25);
        register_Button.addActionListener(this);

        Conformpassword_text.setBounds(250, 250, 300, 25);
        message_text.setBounds(375,100,650,35);
        message_text.setFont(new Font(null,Font.ITALIC,25));
        Conformpassword_input.setBounds(375, 250, 300, 25);

        login_back.setBounds(480, 350, 100, 25);
        login_back.addActionListener(this);

        create_Button.setBounds(450,300, 150, 25);
        create_Button.addActionListener(this);
        
        login.add(message_text);
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
        message_text.setVisible(false);
    }

    public void register_window(){
        register_Button.setVisible(false);
        login_Button.setVisible(false);
        create_Button.setVisible(true);
        login_back.setVisible(true);
        Conformpassword_input.setVisible(true);
        Conformpassword_text.setVisible(true);
    }

    public void back_login(){
        register_Button.setVisible(true);
        login_Button.setVisible(true);
        create_Button.setVisible(false);
        login_back.setVisible(false);
        Conformpassword_input.setVisible(false);
        Conformpassword_text.setVisible(false);
        message_text.setVisible(false);
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
                    message_text.setText(text_alert);
                    message_text.setVisible(true);
                    user_input.setText("");
                    password_input.setText(password);
                    Conformpassword_input.setText(conpass);
                    break;

                    case "The password is Already Exists":
                        message_text.setText(text_alert);
                        message_text.setVisible(true);
                        user_input.setText(username);
                        password_input.setText("");
                        Conformpassword_input.setText("");
                        break;

                    case "successfully registered":
                        message_text.setText(text_alert);
                        message_text.setVisible(true);
                        break;
                    default:
                        message_text.setText("There is error in the System Contact the programmer ");
                        message_text.setVisible(true);
                        break;

                
                    }
                }else{
                message_text.setText("Password not match");
                message_text.setVisible(true);
                user_input.setText(username);
                password_input.setText("");
                Conformpassword_input.setText("");
            }
            
    }

    public void login_Account(){
            String username=user_input.getText();
            String password=String.valueOf(password_input.getPassword());
            System.out.println(username+":"+password);
            String text_alert =sql.sql_login(username, password);
            settings_design.setText("Username: "+sql.getUser_name());
            switch (text_alert) {
                case "The username or password you entered is incorrect":
                    message_text.setText(text_alert);
                    message_text.setVisible(true);
                    user_input.setText("");
                    password_input.setText("");

                    break;
                
                case "The password you’ve entered is incorrect":
                    message_text.setText(text_alert);
                    message_text.setVisible(true);
                    password_input.setText("");
                    break;

                case "login success":
                    login.setVisible(false);
                    home_layer.setVisible(true);
                    homPanel.setVisible(true);
                    Library_template();
                default:
                    message_text.setText("There is error in the System Contact the programmer ");
                    message_text.setVisible(true);
                    break;
            }
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

}
