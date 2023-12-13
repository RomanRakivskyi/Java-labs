import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class CPUQueue {
    private Queue<CPUProcess> queue = new LinkedList<>();
    private int maxSize;

    public CPUQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void addProcess(CPUProcess process) {
        if (queue.size() < maxSize) {
            queue.add(process);
            System.out.println("Added process to the queue: " + process.getId());
        } else {
            System.out.println("Queue is full. Process " + process.getId() + " cannot be added.");
        }
    }

    public synchronized CPUProcess getProcess() {
        return queue.poll();
    }

    public int getMaxSize() {
        return maxSize;
    }
}

class CPUProcess extends Thread {
    private static int nextId = 1;
    private int id;
    private int interval;
    private CPUQueue queue;
    private Random random = new Random();

    public CPUProcess(int interval, CPUQueue queue) {
        this.id = nextId++;
        this.interval = interval;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                sleep(interval);
                CPUProcess process = new CPUProcess(random.nextInt(1000) + 500, queue);
                queue.addProcess(process);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long getId() {
        return id;
    }
}

class CPU extends Thread {
    private CPUQueue queue;
    private int processTime;

    public CPU(CPUQueue queue, int processTime) {
        this.queue = queue;
        this.processTime = processTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                CPUProcess process = queue.getProcess();
                if (process != null) {
                    System.out.println("Processing process " + process.getId() + " on CPU " + getId());
                    sleep(processTime);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Параметри для потоків процесів і CPU
        int numProcesses1 = 10;
        int numProcesses2 = 15;
        int maxSizeQueue1 = 5;
        int maxSizeQueue2 = 7;
        int processTimeCPU1 = 200;
        int processTimeCPU2 = 300;

        // Створення черг і CPU
        CPUQueue queue1 = new CPUQueue(maxSizeQueue1);
        CPUQueue queue2 = new CPUQueue(maxSizeQueue2);
        CPU cpu1 = new CPU(queue1, processTimeCPU1);
        CPU cpu2 = new CPU(queue2, processTimeCPU2);

        // Запуск потоків процесів і CPU
        for (int i = 0; i < numProcesses1; i++) {
            new CPUProcess(1000, queue1).start();
        }

        for (int i = 0; i < numProcesses2; i++) {
            new CPUProcess(1500, queue2).start();
        }

        cpu1.start();
        cpu2.start();
    }
}
