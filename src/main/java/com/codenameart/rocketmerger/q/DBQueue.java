package com.codenameart.rocketmerger.q;

import com.codenameart.rocketmerger.envelope.WHData;

import java.util.AbstractQueue;

/**
 * Created by Artem on 23.12.2017.
 */
public class DBQueue {
    private AbstractQueue<WHData> queue;

    public DBQueue(AbstractQueue<WHData> queue) {
        this.queue = queue;
    }

    public boolean offer(WHData whData) {
        return queue.offer(whData);
    }

    public WHData poll() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }
}
