import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//_____Call CLASS_____
class Call {
    private String phoneNumber; // 2nd number
    private String callType; // type
    private int duration; // duration
    private String timestamp; // date-time

    public Call(String phoneNumber, String callType, int duration, String timestamp) {
        this.phoneNumber = phoneNumber; // +380677729069
        this.callType = callType; // Міський, Міжнародний
        this.duration = duration; // 10
        this.timestamp = timestamp; // 2023-01-01 10:30:00
    }

    public int getDuration() {
        return duration;
    }

    public String getCallType() {
        return callType;
    }
}

//_____Call LIST_____
class CallLog {
    private List<Call> calls;

    public CallLog() {
        this.calls = new ArrayList<>();
    }

    public void addCall(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public int getTotalCalls() {
        return calls.size();
    }

    public double getAverageDuration() {
        if (calls.isEmpty()) {
            return 0;
        }

        int totalDuration = 0;
        for (Call call : calls) {
            totalDuration += call.getDuration();
        }

        return (double) totalDuration / calls.size();
    }

    // Додайте інші методи для обчислення статистики, якщо потрібно
    public double getTotalDuration() {
        if (calls.isEmpty()) {
            return 0;
        }

        int totalDuration = 0;
        for (Call call : calls) {
            totalDuration += call.getDuration();
        }

        return (double) totalDuration;
    }
}

public class CallTrackingApp {
    public static void main(String[] args) {

        CallLog all_callLog = new CallLog();
        CallLog city_callLog = new CallLog();
        CallLog country_callLog = new CallLog();

        // Читання даних з файлу
        String filePath = "CALIS/calis.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Call call = parseCall(line);
                if (call != null) {
                    all_callLog.addCall(call);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Інші дії з all_callLog та іншими журналами...

        for (Call call : all_callLog.getCalls()) {
            if ("міський".equals(call.getCallType())) {
                city_callLog.addCall(call);
            } else if ("міжнародний".equals(call.getCallType())) {
                country_callLog.addCall(call);
            }
        }

        double city_price = 0.8;
        double country_price = 2.3;

        // Приклад виведення статистики
        System.out.println("\nЗагальна кількість дзвінків: " + (city_callLog.getTotalCalls() + country_callLog.getTotalCalls()));
        System.out.println("Кількість міжміських дзвінків: " + city_callLog.getTotalCalls());
        System.out.println("Кількість міжнародних дзвінків: " + country_callLog.getTotalCalls());
        System.out.println("Тривалість міжміських дзвінків: " + city_callLog.getTotalDuration() + " хв.");
        System.out.println("Тривалість міжнародних дзвінків: " + country_callLog.getTotalDuration() + " хв.");
        System.out.println("Середня тривалість міжміських дзвінків: " + city_callLog.getAverageDuration() + " хв.");
        System.out.println("Середня тривалість міжнародних дзвінків: " + country_callLog.getAverageDuration() + " хв.");
        System.out.println("Середня тривалість дзвінка: " + ((city_callLog.getAverageDuration() + country_callLog.getAverageDuration()) / 2) + " хв.");
        System.out.println("\nВартість хвилини міжміського дзвінка: " + city_price + "грн");
        System.out.println("Вартість хвилини міжнародного дзвінка: " + country_price + "грн");
        double city_exch = city_price * city_callLog.getAverageDuration();
        double country_exch = country_price * country_callLog.getAverageDuration();
        System.out.println("Витрачено грошей на міжміські дзвінки: " + city_exch + "грн");
        System.out.println("Витрачено грошей на міжнародні дзвінки: " + country_exch + "грн");
        double suma = city_exch+country_exch;
        System.out.println("Витрачено грошей всього: " + suma + "грн");
        double marga = 10;
        System.out.println("\nМаржа: " + marga + "%");
        System.out.println("Компанія заробила " + (marga/100*suma) + "грн з цих дзвінків");
        System.out.println("\nУсі дзвінки:");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(" ");
        System.out.println(" ");

    }

    private static Call parseCall(String line) {
        // Використовуємо регулярний вираз для розбиття рядка на частини
        Pattern pattern = Pattern.compile("\"([^\"]*)\",\\s*\"([^\"]*)\",\\s*(\\d+),\\s*\"([^\"]*)\"");
        Matcher matcher = pattern.matcher(line);

        // Перевіряємо, чи відповідає рядок формату
        if (matcher.matches()) {
            // Отримуємо значення груп
            String phoneNumber = matcher.group(1);
            String callType = matcher.group(2);
            int duration = Integer.parseInt(matcher.group(3));
            String timestamp = matcher.group(4);

            // Створюємо об'єкт Call
            return new Call(phoneNumber, callType, duration, timestamp);
        } else {
            System.out.println("Invalid line format: " + line);
            return null;
        }
    }
}