package projectC_prototype;
import javax.swing.*;
import java.awt.*;
public class test {
    /*public void Library_button(int library) {
         System.out.println(library);
        HashMap<String, String> answer_sheet = new HashMap<>();
        answer_sheet = sql.sql_display(library);
        mode.set_FILO();
        Stack<String> question = mode.get_FILO(answer_sheet);
        library_template.setVisible(false);
        Quiz_template.setVisible(true);
        Quiz_template.setLayout(null);
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
                ABCD.setBackground(Color.decode("#836efa"));
                item_choice.put(letter[x], ABCD);
                multiple_choice.add(ABCD);
                questionPanel.add(ABCD);
            }
            
            a++;
            
            Quiz_paper.add(questionPanel);
        }
        
        // Create a scroll pane for the quiz paper
        JScrollPane scroll = new JScrollPane(Quiz_paper);
        scroll.setBounds(150, 10, 700, 580);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    
        // Set the preferred size of the scroll pane
        scroll.setPreferredSize(new Dimension(700, 580));
    
        // Add the scroll pane to the Quiz_template
        Quiz_template.add(scroll);
    }*/
    public static void main(String[] args) {
       /*  // Create a JFrame
        JFrame frame = new JFrame("JScrollPane with setBounds Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a JPanel to hold the JScrollPane
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(null); // Use a null layout

        // Create a JPanel to hold the components with setBounds
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); // Use a null layout

        // Create buttons using setBounds
        for (int i = 1; i <= 20; i++) {
            JButton button = new JButton("Button " + i);
            button.setBounds(10, 10 + (i - 1) * 40, 100, 30);
            contentPanel.add(button);
        }

        // Set the preferred size for the contentPanel
        contentPanel.setPreferredSize(new Dimension(220, 10 + 20 * 40)); 

        // Create a JScrollPane and set its view to the content panel
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBounds(150, 10, 220, 200); // Set the bounds for the scroll pane

        // Add the JScrollPane to the parent panel
        parentPanel.add(scrollPane);

        // Add the parent panel to the JFrame
        frame.getContentPane().add(parentPanel);

        // Set up the JFrame and make it visible
        frame.setVisible(true);

        */
        String str = "melmel";
        try{
            int number = Integer.parseInt(str);
            System.out.println(number); // output = 25
        }
        catch (NumberFormatException ex){
            System.out.println(str);
        }
    }

}


