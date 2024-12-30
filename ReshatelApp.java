import javax.swing.*;
import java.awt.*;

public class ReshatelApp {
    private JFrame frame;
    private JPanel panel;
    private JComboBox<String> comboBox;

    private JLabel statusLabel;
    public ReshatelApp() {
        panel = new JPanel(new BorderLayout());
        frame = new JFrame("Решатель, решит за тебя!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 300);
        frame.setLayout(new BorderLayout());

        // Создаем меню
        JMenuBar menuBar = new JMenuBar();
        JMenu settingsMenu = new JMenu("Настройки");
        menuBar.add(settingsMenu);
        frame.setJMenuBar(menuBar);



        // Создаем выпадающее меню
        String[] options = {"Простое решение Да/Нет", "Сложное решение", "Случайный выбор из числа"};
        comboBox = new JComboBox<>(options);
        DopPanel doppanel = new DopPanel(comboBox);
        ListinerSelectedMenu listinerSelectedMenu = new ListinerSelectedMenu(comboBox,doppanel);
        comboBox.addItemListener(listinerSelectedMenu);
        comboBox.setSelectedIndex(0); // По умолчанию выбран первый пункт

        doppanel.setSimple();


        // Создаем статусную панель
        statusLabel = new JLabel("Статус", SwingConstants.LEFT);


        // Добавляем компоненты в окно
        panel.add(comboBox, BorderLayout.NORTH);
        panel.add(doppanel, BorderLayout.CENTER);
        panel.add(statusLabel, BorderLayout.PAGE_END);


        frame.add(panel);
        // Отображаем окно
        frame.setVisible(true);
    }


}

