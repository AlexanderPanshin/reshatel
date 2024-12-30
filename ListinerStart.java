import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ListinerStart implements ActionListener {
    private DopPanel doppanel;
    private String[] predictions;
    public ListinerStart(DopPanel doppanel) {
        predictions = new String[]{
                "Может быть",
                "Не стоит",
                "Завтра",
                "Если сильно постараться",
                "Определенно да",
                "Скорее всего нет",
                "Попробуйте еще раз",
                "Все будет хорошо",
                "Не теряйте надежду",
                "Сделайте перерыв",
                "Скоро все изменится",
                "Верьте в себя",
                "Не бойтесь рисковать",
                "Это не лучший выбор",
                "Слушайте свое сердце",
                "Удача на вашей стороне",
                "Вы на правильном пути",
                "Не спешите с решениями",
                "Дайте себе время",
                "Возможно, это ваш шанс",
                "Сосредоточьтесь на целях",
                "Обратите внимание на детали",
                "Не упустите возможность",
                "Скоро вас ждет сюрприз",
                "Изменения к лучшему",
                "Следуйте своему инстинкту",
                "Сейчас не время для сомнений",
                "Исследуйте новые возможности",
                "Не забывайте о своих мечтах",
                "Это может быть трудный путь",
                "Вы можете справиться с этим",
                "Никогда не поздно начать заново",
                "Не забывайте о своих друзьях",
                "Будьте открыты новым идеям",
                "Ваши усилия будут вознаграждены",
                "Скоро вы найдете решение",
                "Не позволяйте страхам вас сдерживать",
                "Ваше терпение окупится",
                "Слушайте советы близких",
                "Не бойтесь спрашивать",
                "Настройтесь на позитивный лад",
                "Вы сможете это сделать",
                "Все зависит от вас",
                "Не откладывайте на завтра",
                "Пора действовать",
                "Скоро вам станет лучше",
                "Не позволяйте мелочам вас отвлекать",
                "Идите за своими желаниями",
                "Ожидайте приятные новости",
                "Будьте осторожны в своих решениях",
                "Сфокусируйтесь на том, что важно",
                "Это время для перемен",
                "Не забывайте о своих достижениях"
        };
        this.doppanel = doppanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedItem = (String) doppanel.getMenuAnswer().getSelectedItem();
        switch (selectedItem){
            case ("Простое решение Да/Нет"):
               doppanel.setOtvet(answerYesNo());
                break;
            case ("Сложное решение"):
                doppanel.setOtvet(answerPredictions());
                break;
            case ("Случайный выбор из числа"):
                doppanel.setOtvet(String.valueOf(answerInt()));
                break;
        }
    }
    private String answerYesNo(){
        Random random = new Random();
        int randomIndex = random.nextInt(2);
        return randomIndex == 0 ? "Да" : "Нет";
    }
    private int answerInt(){
        if(doppanel.getStringIntMax()!=null&& !doppanel.getStringIntMax().isEmpty()&&isValidInput(doppanel.getStringIntMax())){
            Random random = new Random();
            int intMax = Integer.parseInt(doppanel.getStringIntMax());
            int randomIndex = random.nextInt(intMax)+1;
            return randomIndex;
        };
        doppanel.setPoyasnenie("ВВедите число!!! А не хрень ");
        return 0;
    }
    private String answerPredictions(){
        Random random = new Random();
        int rendNum = random.nextInt(predictions.length);
        return predictions[rendNum];
    }
    private boolean isValidInput(String textArea) {
        String input = textArea.trim();
        if (input.isEmpty()) {
            return false;
        }
        if (!input.matches("\\d+")) {
            return false;
        }
        try {
            int number = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
