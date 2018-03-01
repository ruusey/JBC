package com.net;

import java.net.InetSocketAddress;

import com.config.Config;

public class JBCNodeOne extends JBCNodeBase {

    public JBCNodeOne(final InetSocketAddress self, final InetSocketAddress peer, final int messageSize) {
        super(self, peer, messageSize);
    }

    public static void main(final String[] args) throws Exception {
        final int messageSize = 64 * 1024;
        final InetSocketAddress self = new InetSocketAddress(Config.hostOne, Config.portOne);
        final InetSocketAddress peer = new InetSocketAddress(Config.hostTwo, Config.portTwo);
        new JBCNodeOne(self, peer, messageSize).run();
    }
}
