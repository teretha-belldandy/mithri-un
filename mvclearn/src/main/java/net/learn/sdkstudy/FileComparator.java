package net.learn.sdkstudy;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;

import org.apache.cxf.helpers.FileUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class FileComparator {

	public static void main(String[] args) {
		File dir = new File("C:\\Users\\xiongneng\\Desktop\\rtjar");
		List<File> files = listFilesR(dir);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println(files.size());
	}
	
	public static List<File> listFilesR(File dir) {
		List<File> allFiles = Lists.newArrayList();
		if (!dir.isDirectory()) {
			allFiles.add(dir);
		} else {
			List<File> tmpFiles = FileUtils.getFiles(dir, ".*");
			for (File file : tmpFiles) {
				if (!file.isDirectory()) {
					allFiles.add(file);
				} else {
					allFiles.addAll(listFilesR(file));
				}
			}
		}
		return allFiles;
	}

	public static Map<String, FileCompareStatus> compareFilesWithName(File pathone, File pathtwo) {
		Map<String, FileCompareStatus> comparePath = Maps.newHashMap();
		if (pathone.isFile() && pathtwo.isFile()) {
			if (pathone.getName().equals(pathtwo.getName())) {
				comparePath.put(pathone.getName(), getFileMD5(pathone).equals(getFileMD5(pathtwo))
						? FileCompareStatus.Equal : FileCompareStatus.UnEqual);
			} else {
				comparePath.put(pathone.getName(), FileCompareStatus.TwoUnExist);
				comparePath.put(pathtwo.getName(), FileCompareStatus.OneUnExist);
			}
		} else if (pathone.isFile() && pathtwo.isDirectory()) {
			// File[] one = null;
		}
		return comparePath;
	}

	public static String getFileMD5(File file) {
		if (!file.isFile()) {
			return null;
		}
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[8192];
		int len;
		try {
			digest = MessageDigest.getInstance("MD5");
			in = new FileInputStream(file);
			while ((len = in.read(buffer)) != -1) {
				digest.update(buffer, 0, len);
			}
			BigInteger bigInt = new BigInteger(1, digest.digest());
			return bigInt.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 计算文件的 SHA-1 值
	public static String getFileSha1(File file) {
		if (!file.isFile()) {
			return null;
		}
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[8192];
		int len;
		try {
			digest = MessageDigest.getInstance("SHA-1");
			in = new FileInputStream(file);
			while ((len = in.read(buffer)) != -1) {
				digest.update(buffer, 0, len);
			}
			BigInteger bigInt = new BigInteger(1, digest.digest());
			return bigInt.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

enum FileCompareStatus {
	Equal("相等"), UnEqual("不相等"), OneUnExist("路径一不存在"), TwoUnExist("路径二不存在");

	String desc;

	FileCompareStatus(String desc) {
		this.desc = desc;
	}
}
