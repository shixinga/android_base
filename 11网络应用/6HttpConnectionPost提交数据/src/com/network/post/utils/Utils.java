package com.network.post.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {

	//将输入流转换成String
	public static String getStringByInputStream(InputStream is) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int n;
		try {
			while((n = is.read(buffer)) != -1) {
				baos.write(buffer, 0, n);
			}
			return new String(baos.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
