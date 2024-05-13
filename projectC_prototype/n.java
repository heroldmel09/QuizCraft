package projectC_prototype;

public class n {
    
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DynamicComponentExample {
    private JFrame frame;
    private JPanel buttonPanel;

    public DynamicComponentExample() {
        frame = new JFrame("Dynamic Component Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Button");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewButton();
            }
        });

        JButton removeButton = new JButton("Remove Button");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeLastButton();
            }
        });

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(addButton, BorderLayout.NORTH);
        frame.add(removeButton, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private void addNewButton() {
        JButton newButton = new JButton("Button " + (buttonPanel.getComponentCount() + 1));
        buttonPanel.add(newButton);
        buttonPanel.revalidate(); // Recalculate the layout to include the new button
    }

    private void removeLastButton() {
        int componentCount = buttonPanel.getComponentCount();
        if (componentCount > 0) {
            buttonPanel.remove(componentCount - 1);
            buttonPanel.revalidate(); // Recalculate the layout after removing the button
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DynamicComponentExample();
            }
        });
    }*/
}
