import javax.swing.*;
import java.awt.*;

public class DopPanel extends JPanel {
    private JLabel otvet;
    private JLabel poyasnenie;
    private JTextField maxInt;
    private JButton start;
    private JComboBox<String> menuAnswer;
    private ListinerStart listinerStart;

    public DopPanel(JComboBox<String> menuAnswer) {
        otvet = new JLabel("Здесь будет ответ",SwingConstants.CENTER);
        poyasnenie = new JLabel("       Введите максимальное число");
        maxInt = new JTextField();
        start = new JButton("Старт");
        otvet.setFont(new Font("Arial", Font.BOLD, 48));
        otvet.setFocusable(true);
        listinerStart = new ListinerStart(this);
        this.menuAnswer = menuAnswer;
        start.addActionListener(listinerStart);
    }
    public void setSimple(){
        this.removeAll();
        otvet.setText("Здесь будет ответ");
        this.setLayout(new BorderLayout());
        this.add(otvet, BorderLayout.CENTER);
        this.add(start,BorderLayout.SOUTH);

    }
    public void setNumberRed(){
        this.removeAll();
        otvet.setText("Здесь будет ответ");

        JPanel inputPanel = new JPanel(new GridBagLayout());
        maxInt.setPreferredSize(new Dimension(200, 30));
        inputPanel.add(maxInt);

        this.setLayout(new BorderLayout());
        this.add(otvet, BorderLayout.NORTH);
        this.add(inputPanel,BorderLayout.CENTER);
        this.add(poyasnenie,BorderLayout.WEST);

        this.add(start,BorderLayout.SOUTH);
    }

    public void setOtvet(String s){
        otvet.setText(s);
    }
    public JComboBox<String>getMenuAnswer(){
        return menuAnswer;
    }
    public String getStringIntMax(){
        return maxInt.getText();
    }
    public void setPoyasnenie(String s){
        poyasnenie.setText(s);
    }
}
