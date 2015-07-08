package com.base.easy.da;

import java.io.*;
import java.rmi.server.UID;

public final class FileHandler {

	private FileHandler() {
	}

	public static String createUniqueTempFile(String extension) {
		UID uniqueId = new UID();
		File tempFile = null;
		try {
			tempFile = File.createTempFile(
					uniqueId.toString().replaceAll(":", "_"), extension);
			tempFile.deleteOnExit();
		} catch (Exception e) {
		}
		return tempFile.getAbsolutePath();
	}

	public static String createUniqueTempFile() {
		return createUniqueTempFile("");
	}

	public static String createUniqueTempFile(byte fileData[], String extension) {
		UID uniqueId;
		BufferedOutputStream bos;
		uniqueId = new UID();
		File tempFile = null;
		bos = null;
		String s = null;
		try {
			tempFile = File.createTempFile(
					uniqueId.toString().replaceAll(":", "_"), extension);
			bos = new BufferedOutputStream(new FileOutputStream(tempFile));
			bos.write(fileData);
			bos.flush();
			s = tempFile.getAbsolutePath();
		} catch (IOException e) {
		}
		if (bos != null)
			try {
				bos.close();
			} catch (IOException ioexception) {
			}
		return s;

	}

	public static String createUserTempFile(byte fileData[], String fileName) {
		String tmpDir;
		BufferedOutputStream bos;
		tmpDir = System.getProperty("java.io.tmpdir");
		File tempFile = null;
		bos = null;
		String s = null;
		try {
			tempFile = new File(tmpDir, fileName);
			bos = new BufferedOutputStream(new FileOutputStream(tempFile));
			bos.write(fileData);
			bos.flush();
			s = tempFile.getAbsolutePath();
		} catch (IOException e) {
		}
		return s;

	}


	public static byte[] getByte(String filePath) {
		InputStream is;
		ByteArrayOutputStream baos;
		is = null;
		baos = null;
		try {
			byte buffer[] = new byte[(int) (new File(filePath)).length()];
			is = new FileInputStream(filePath);
			baos = new ByteArrayOutputStream();
			int bytesRead;
			while ((bytesRead = is.read(buffer)) != -1)
				baos.write(buffer, 0, bytesRead);
		} catch (Exception e) {
		}
		if (is != null)
			try {
				is.close();
			} catch (IOException e) {
			}
		return null;

	}
}
