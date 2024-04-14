package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String inputString) {

        BigInteger hashResult;

        try {
            //MD5 hashing algorithm
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            // upate the digest using the bytes of the str
            messageDigest.update(inputString.getBytes());

            // hash computation
            byte[] digestBytes = messageDigest.digest();

            // byte arr to a hex str
            String hexString = toHex(digestBytes);

            // Convert the hex str to a "BigInteger"
            hashResult = new BigInteger(hexString, 16);

        } catch (NoSuchAlgorithmException e) {
            // Throw an unchecked exception if the algorithm does not exist
            throw new RuntimeException(e);
        }

        return hashResult;
    }
	
	public static BigInteger addressSize() {
		
		
		// compute the number of bits = bitSize()
		return new BigInteger("2").pow(128);
	}
	
	public static int bitSize() {
		
		int digestlen = 128;
		
		// find the digest length
		
		return digestlen;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			// Append each byte as a hex str
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
