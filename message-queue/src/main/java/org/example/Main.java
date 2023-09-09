package org.example;
import java.util.LinkedList;

class MessageQueue {
    private LinkedList<String> queue = new LinkedList<>();

    public synchronized void pushMessage(String message) {
        queue.add(message);
        notify(); // Notify consumers that a new message is available.
    }

    public synchronized String popMessage() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait for messages if the queue is empty.
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
        // Generate and push messages to the queue.
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
        // Consume messages from the queue.
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

        // Start a producer and a consumer thread.
        Thread producerThread = new Thread(new Producer(messageQueue));
        Thread consumerThread = new Thread(new Consumer(messageQueue));

        producerThread.start();
        consumerThread.start();
    }
}
