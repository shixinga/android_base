package com.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {

	public static String getStringByInputStream(InputStream is) {
		byte[] buffer = new byte[1024];
		int n;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			while((n = is.read(buffer)) != -1) {
				bos.write(buffer, 0, n);
			}
			return new String(bos.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
