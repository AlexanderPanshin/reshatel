import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ListinerSelectedMenu implements ItemListener {
    private JComboBox<String> comboBox;
    private DopPanel dopPanel;

    public ListinerSelectedMenu(JComboBox<String> comboBox, DopPanel dopPanel) {
        this.comboBox = comboBox;
        this.dopPanel = dopPanel;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String selectedItem = (String) comboBox.getSelectedItem();
            switch (selectedItem){
                case ("Простое решение Да/Нет"):
                    dopPanel.setSimple();
                    dopPanel.repaint();
                    dopPanel.revalidate();
                    break;
                case ("Сложное решение"):
                    dopPanel.setSimple();
                    dopPanel.repaint();
                    dopPanel.revalidate();
                    break;
                case ("Случайный выбор из числа"):
                    dopPanel.setNumberRed();
                    dopPanel.repaint();
                    dopPanel.revalidate();
                    break;
            }
        }
    }
}
