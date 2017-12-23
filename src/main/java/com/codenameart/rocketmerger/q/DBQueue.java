package com.codenameart.rocketmerger.q;

import com.codenameart.rocketmerger.Pokemon;

import java.util.AbstractQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Artem on 23.12.2017.
 */
public class DBQueue {
    private AbstractQueue<Pokemon> queue;

    public DBQueue(AbstractQueue<Pokemon> queue) {
        this.queue = queue;
    }

    public boolean offer(Pokemon pokemon) {
        return queue.offer(pokemon);
    }

    public Pokemon poll() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }
}
