package com.mikalai.cucumber.test.account.hook;

import com.mikalai.cucumber.account.store.TransactionProcessor;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BackgroundProcessHooks {
    private Thread transactionProcessorThread;

    @Before("@balancestore")
    public void startBackgroundThread() {
        transactionProcessorThread = new Thread() {
            public void run() {
                TransactionProcessor processor = new TransactionProcessor();
                processor.process();
            }
        };
        transactionProcessorThread.start();
    }

    @After("@balancestore")
    public void stopBackgroundThread() {
        transactionProcessorThread.interrupt();
    }
}
