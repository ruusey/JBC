package com.net;

import java.net.InetSocketAddress;

import com.config.Config;


public class JBCNodeTwo extends JBCNodeBase {

    public JBCNodeTwo(final InetSocketAddress self, final InetSocketAddress peer, final int messageSize) {
        super(self, peer, messageSize);
    }

    public static void main(final String[] args) throws Exception {
        
        final InetSocketAddress self = new InetSocketAddress(Config.hostTwo, Config.portTwo);
        final InetSocketAddress peer = new InetSocketAddress(Config.hostOne, Config.portOne);
        new JBCNodeTwo(self, peer, Config.messageSize).run();
    }
}
