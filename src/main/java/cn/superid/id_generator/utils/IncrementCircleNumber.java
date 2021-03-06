package cn.superid.id_generator.utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 从start到end不断递增，到了end就循环回start
 * Created by 维 on 2014/9/9.
 */
public class IncrementCircleNumber {
    private long current;
    private long start;
    private long end;

    public IncrementCircleNumber(long start, long end) {
        if (end <= start) {
            throw new IllegalArgumentException("end should be large than start");
        }
        this.start = start;
        this.end = end;
        this.current = this.start;
    }

    public synchronized long getAndIncrement() {
        long next = this.current;
        this.current += 1;
        if (this.current >= end) {
            this.current = this.start;
        }
        return next;
    }
}
