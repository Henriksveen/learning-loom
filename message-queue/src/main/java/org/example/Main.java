package org.example;
import java.util.LinkedList;

class MessageQueue {
    private LinkedList<String> queue = new LinkedList<>();

    public synchronized void pushMessage(String message) {
        queue.add(message);
        notify();
    }

    public synchronized String popMessage() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.poll();
    }
}

class Producer implements Runnable {
    private MessageQueue messageQueue;

    public Producer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String message = "Message " + i;
            messageQueue.pushMessage(message);
            System.out.println("Produced: " + message);
        }
    }
}

class Consumer implements Runnable {
    private MessageQueue messageQueue;

    public Consumer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = messageQueue.popMessage();
                System.out.println("Consumed: " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();

        Thread producerThread = new Thread(new Producer(messageQueue));
        Thread consumerThread = new Thread(new Consumer(messageQueue));

        producerThread.start();
        consumerThread.start();
    }
}
