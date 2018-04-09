package net.picenter.pictest.file;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.cxf.helpers.FileUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class FileComparator {

	public static void main(String[] args) {
		File dirone = new File("C:\\Users\\xiongneng\\Desktop\\rtjar\\rt-jdk\\com\\oracle\\net");
		File dirtwo = new File("C:\\Users\\xiongneng\\Desktop\\rtjar\\rt-jre\\com\\oracle\\net");
		Map<String, FileCompareStatus> compareFileRes = compareFilesWithName(dirone, dirtwo);
		System.out.println(compareFileRes.size());
		int num = 0;
		for (String key : compareFileRes.keySet()) {
			if (FileCompareStatus.Equal != compareFileRes.get(key)) {
				System.out.println(String.format("%s\t\t\t%s", key, compareFileRes.get(key).desc));
				num++;
			}
		}
		System.out.println(num);
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

	public static List<File> listFilesSorted(File dir) {
		List<File> allFiles = listFilesR(dir);
		Collections.sort(allFiles, new Comparator<File>() {
			public int compare(File o1, File o2) {
				if (null == o1 && null == o2)
					return 0;
				else if (null == o1)
					return -1;
				else if (null == o2)
					return 1;
				else
					return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
			}
		});
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
			List<File> fileList = listFilesSorted(pathtwo);
			for (File file : fileList) {
				if (0 < file.getName().compareTo(pathone.getName()))
					comparePath.put(file.getName(), FileCompareStatus.OneUnExist);
				else if (0 == file.getName().compareTo(pathone.getName()))
					comparePath.put(file.getName(), getFileMD5(file).equals(getFileMD5(pathone))
							? FileCompareStatus.Equal : FileCompareStatus.UnEqual);
				else
					comparePath.put(file.getName(), FileCompareStatus.OneUnExist);
				if (null == comparePath.get(pathone.getName()))
					comparePath.put(pathone.getName(), FileCompareStatus.TwoUnExist);
			}
		} else if (pathone.isDirectory() && pathtwo.isFile()) {
			List<File> fileList = listFilesSorted(pathone);
			for (File file : fileList) {
				if (0 < file.getName().compareTo(pathtwo.getName()))
					comparePath.put(file.getName(), FileCompareStatus.OneUnExist);
				else if (0 == file.getName().compareTo(pathtwo.getName()))
					comparePath.put(file.getName(), getFileMD5(file).equals(getFileMD5(pathtwo))
							? FileCompareStatus.Equal : FileCompareStatus.UnEqual);
				else
					comparePath.put(file.getName(), FileCompareStatus.TwoUnExist);
				if (null == comparePath.get(pathone.getName()))
					comparePath.put(pathone.getName(), FileCompareStatus.OneUnExist);
			}
		} else if (pathone.isDirectory() && pathtwo.isDirectory()) {
			List<File> pathoneList = listFilesSorted(pathone);
			List<File> pathtwoList = listFilesSorted(pathtwo);
			for (int i = 0, j = 0; i < pathoneList.size() && j < pathtwoList.size();) {
				if (pathoneList.get(i).getName().compareTo(pathtwoList.get(j).getName()) < 0) {
					comparePath.put(pathoneList.get(i).getName(), FileCompareStatus.TwoUnExist);
					i++;
				} else if (pathoneList.get(i).getName().compareTo(pathtwoList.get(j).getName()) < 0) {
					comparePath.put(pathtwoList.get(j).getName(), FileCompareStatus.OneUnExist);
					j++;
				} else {
					comparePath.put(pathoneList.get(i).getName(),
							getFileMD5(pathoneList.get(i)).equals(getFileMD5(pathtwoList.get(j)))
									? FileCompareStatus.Equal : FileCompareStatus.UnEqual);
					i++;
					j++;
				}
			}
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

	// �����ļ��� SHA-1 ֵ
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
	Equal("���"), UnEqual("�����"), OneUnExist("·��һ������"), TwoUnExist("·����������");

	String desc;

	FileCompareStatus(String desc) {
		this.desc = desc;
	}
}
