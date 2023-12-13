import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

class RandomCallGenerator {
    public static void main(String[] args) {
        String filePath = "CALIS/calis.txt";
        int numberOfCalls = 15; // You can change this to generate more or fewer calls

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < numberOfCalls; i++) {
                RCall randomCall = generateRandomCall();
                writer.write(formatCall(randomCall));
                writer.newLine();
            }
            System.out.println("Random calls generated and saved to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static RCall generateRandomCall() {
        Random random = new Random();
        String phoneNumber = generateRandomPhoneNumber();
        String callType = random.nextBoolean() ? "міський" : "міжнародний";
        int duration = random.nextInt(20) + 1; // Random duration between 1 and 20 minutes
        String timestamp = generateRandomTimestamp();

        return new RCall(phoneNumber, callType, duration, timestamp);
    }

    private static String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder("+380");
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }

    private static String generateRandomTimestamp() {
        Random random = new Random();
        int year = 2023;
        int month = random.nextInt(12) + 1; // Random month between 1 and 12
        int day = random.nextInt(28) + 1;    // Assume all months have 28 days for simplicity
        int hour = random.nextInt(24);       // Random hour between 0 and 23
        int minute = random.nextInt(60);     // Random minute between 0 and 59

        return String.format("%04d-%02d-%02d %02d:%02d:00", year, month, day, hour, minute);
    }

    private static String formatCall(RCall call) {
        return String.format("\"%s\", \"%s\", %d, \"%s\"", call.getPhoneNumber(), call.getCallType(),
                call.getDuration(), call.getTimestamp());
    }
}

class RCall {
    private String phoneNumber;
    private String callType;
    private int duration;
    private String timestamp;

    public RCall(String phoneNumber, String callType, int duration, String timestamp) {
        this.phoneNumber = phoneNumber;
        this.callType = callType;
        this.duration = duration;
        this.timestamp = timestamp;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCallType() {
        return callType;
    }

    public int getDuration() {
        return duration;
    }

    public String getTimestamp() {
        return timestamp;
    }
}