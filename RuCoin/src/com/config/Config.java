package com.config;

import java.text.SimpleDateFormat;

public final class Config {
	
    private Config() {
    }
    public static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    public static final String hostOne = "localhost";
    public static final int portOne = 1231;

    public static final String hostTwo = "localhost";
    public static final int portTwo = 1232;
    public static final int messageSize = 16;

}
