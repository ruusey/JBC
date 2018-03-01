package com.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ByteUtil {
	public static byte[] reverseBytes(byte[] bytes) {
		// We could use the XOR trick here but it's easier to understand if we don't. If
		// we find this is really a
		// performance issue the matter can be revisited.
		byte[] buf = new byte[bytes.length];
		for (int i = 0; i < bytes.length; i++)
			buf[i] = bytes[bytes.length - 1 - i];
		return buf;
	}

	public static byte[] doubleDigestTwoBuffers(byte[] input1, int offset1, int length1, byte[] input2, int offset2,
			int length2) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(input1, offset1, length1);
			digest.update(input2, offset2, length2);
			byte[] first = digest.digest();
			return digest.digest(first);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e); // Cannot happen.
		}
	}
}
