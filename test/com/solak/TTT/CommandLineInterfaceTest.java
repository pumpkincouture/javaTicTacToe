package com.solak.TTT;

import org.junit.Before;

import java.io.ByteArrayOutputStream;

public class CommandLineInterfaceTest {
    private CommandLineInterface commandLineTest;
    private ByteArrayOutputStream outputContent;

    @Before
    public void setUp() {
        commandLineTest = new CommandLineInterface();
        outputContent = new ByteArrayOutputStream();
    }


}
