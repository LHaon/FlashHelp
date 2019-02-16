package com.fhelp.test;

import java.io.IOException;
import java.util.UUID;

import org.junit.Test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestDemo {
	private static String src = "zhangyongjian";

	@Test
	public void huhxBase64() {
	    try {
	        BASE64Encoder encoder = new BASE64Encoder();
	        String encode = encoder.encode(src.getBytes());
	        System.out.println("encode: " + encode);

	        BASE64Decoder decoder = new BASE64Decoder();
	        String decode = new String(decoder.decodeBuffer(encode));
	        System.out.println("decode: " + decode);
	        
	        System.out.println("hashCode: "+UUID.randomUUID().toString());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
