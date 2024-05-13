package projectC_prototype;
import javax.swing.*;
import java.awt.*;
public class test2 {
    public void Library_button(int library){
        System.out.println(library);
        HashMap <String,String> answer_sheet=new HashMap<>();
        answer_sheet=sql.sql_display(library);
        mode.set_FILO();
        Stack <String> question=mode.get_FILO(answer_sheet);
        library_template.setVisible(false);
        Quiz_template.setVisible(true);
        Quiz_template.setBounds(300, 30, 850, 600);
        Quiz_template.setBackground(Color.decode("#836efa"));
        Quiz_template.setLayout(null);
        Quiz_template.setOpaque(true);
        Quiz_paper.setBackground(Color.decode("#836efa"));
        Quiz_paper.setLayout(null);
        int a=1;
        int y= 100;
        for(String i :question){
            System.out.println(a+"."+i);
            String choices[]=q.choice(i,answer_sheet);
            questiontext=new JLabel("<html>"+a+"."+i+"</html>");
            questiontext.setFont(new Font("Bahnschrift Light",Font.BOLD,15));
            questiontext.setBounds(30, y, 600,60 );
            questiontext.setHorizontalAlignment(SwingConstants.LEFT); // Center the text
            questiontext.setVerticalAlignment(SwingConstants.CENTER);
            questiontext.setBorder(new EmptyBorder(0, 0, 0, 0));
            Quiz_paper.add(questiontext);
            a++;
            y+=200;
            multiple_choice= new ButtonGroup();
            item_choice=new HashMap<String,String>();
            for(int x=0; x!=letter.length;x++){
                System.out.println(y);
                int to_ABCD=10;
                ABCD=new JRadioButton(letter[x]+"."+choices[x]);
                ABCD.setBounds(30, y+to_ABCD, 30,60 );
                System.out.println(letter[x]+"."+choices[x]);
                item_choice.put(letter[x], choices[x]);
                to_ABCD+=5;
                multiple_choice.add(ABCD);
                Quiz_paper.add(ABCD);
            }
        }
        Quiz_paper.setPreferredSize(new Dimension(220, 10 + 20 * 40));
        scroll=new JScrollPane(Quiz_paper);
        scroll.setBounds(150,10 , 700,580);
        
        Quiz_template.add(scroll);
    }


    public void Library_button(int library) {
        System.out.println(library);
        HashMap<String, String> answer_sheet = new HashMap<>();
        answer_sheet = sql.sql_display(library);
        mode.set_FILO();
        Stack<String> question = mode.get_FILO(answer_sheet);
        library_template.setVisible(false);
        Quiz_template.setVisible(true);
        Quiz_template.setBounds(300, 30, 850, 600);
        Quiz_template.setBackground(Color.decode("#836efa"));
        
        // Use a GridLayout for the quiz paper
        GridLayout quizLayout = new GridLayout(0, 1); // 1 column, dynamic rows
        Quiz_paper.setLayout(quizLayout);
        Quiz_paper.setBackground(Color.decode("#836efa"));
    
        int a = 1;
        
        for (String i : question) {
            System.out.println(a + "." + i);
            String choices[] = q.choice(i, answer_sheet);
            
            // Create a panel for each question
            JPanel questionPanel = new JPanel(new GridLayout(0, 1)); // 1 column, dynamic rows
            questionPanel.setBackground(Color.decode("#836efa"));
            
            JLabel questionText = new JLabel("<html>" + a + "." + i + "</html>");
            questionText.setFont(new Font("Bahnschrift Light", Font.BOLD, 15));
            
            questionPanel.add(questionText);
            
            ButtonGroup multiple_choice = new ButtonGroup();
            HashMap<String, JRadioButton> item_choice = new HashMap<>();
            
            for (int x = 0; x < letter.length; x++) {
                JRadioButton ABCD = new JRadioButton(letter[x] + "." + choices[x]);
                item_choice.put(letter[x], ABCD);
                multiple_choice.add(ABCD);
                questionPanel.add(ABCD);
            }
            
            a++;
            
            Quiz_paper.add(questionPanel);
        }
        
        // Create a scroll pane for the quiz paper
        JScrollPane scroll = new JScrollPane(Quiz_paper);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    
        // Set the preferred size of the scroll pane
        scroll.setPreferredSize(new Dimension(700, 580));
    
        // Add the scroll pane to the Quiz_template
        Quiz_template.add(scroll);
    }
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("SetBounds JLabel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Set layout to null to use setBounds

        // Create a JLabel with HTML formatting for multi-line text
        JLabel label = new JLabel("<html>This is a long text that will wrap when it overflows the specified bounds.</html>");

        // Set the bounds for the JLabel
        label.setBounds(10, 10, 200, 60);

        // Enable line wrap and word wrap
        label.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Add a border for visualization

        frame.add(label);
        frame.setSize(300, 100); // Set the frame size

        frame.setVisible(true);
    }
}



public void Library_template(List<String> libraryData) {
    Quiz_template.setVisible(false);
    library_template.setBounds(300, 30, 850, 600);
    library_template.setBackground(Color.decode("#e170fa"));
    library_template.setLayout(null);
    library_template.setOpaque(true);
    library_paper = new JPanel();
    library_paper.setBackground(Color.decode("#e170fa"));
    library_paper.setLayout(null);
    int y = 150;

    for (String data : libraryData) {
        JLabel list_library = new JLabel(data);
        JButton button = new JButton("Start Quiz");
        button.setBounds(555, y, 100, 25);

        int value = sql.getValueForLibrary(data); // You need to implement this method
        button.addActionListener(e -> Library_button(value));

        list_library.setFont(new Font("Bahnschrift Light", Font.BOLD, 15));
        list_library.setBounds(30, y, 200, 30);
        library_paper.add(button);
        library_paper.add(list_library);
        y += 50;
    }

    library_paper.setPreferredSize(new Dimension(220, 10 + y));
    libray_scroll = new JScrollPane(library_paper);
    libray_scroll.setBounds(150, 10, 700, 580);

    library_template.add(libray_scroll);
}

