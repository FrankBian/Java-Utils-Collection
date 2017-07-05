package com.gansuer.common.util;

import org.junit.Test;

public class IdGeneratorWorkerTest {

    private IdGeneratorWorker idGeneratorWorker;

    @Test
    public void nextId() throws Exception {
        long workerId = 1L;
        idGeneratorWorker = new IdGeneratorWorker(workerId);
        long res = idGeneratorWorker.nextId();
        System.out.println(res);

    }

    @Test
    public void testValue() throws Exception {
        print(-1L);
        long seqMask = -1L ^ -1L << 10L;
        System.out.println("seqMask:");
        print(seqMask);

        long maxWorkId = -1L ^ -1L << 4L;
        System.out.println("maxWorkId:");
        print(maxWorkId);

        long twepoch = 1361753741828L;
        System.out.println("twepoch:");
        print(twepoch);

        twepoch = twepoch << 14;
        print(twepoch);

    }

    private void print(long l) {
        System.out.println(l);
        System.out.println(Long.toBinaryString(l));
        System.out.println(Long.toBinaryString(l).length());
    }
}