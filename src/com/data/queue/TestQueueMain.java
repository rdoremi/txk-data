package com.data.queue;

public class TestQueueMain {
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
        }
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.getFront());

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
        }
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();

        loopQueue.dequeue();
        for (int i = 20; i < 25; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);
        System.out.println(loopQueue.getFront());
    }
}
