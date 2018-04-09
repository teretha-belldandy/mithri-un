package net.picenter.pictest.file;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FileProcessDemo {

	private static final String DIR = "E:\\mygitspace\\ecf-mfs";
	
	public static void main(String[] args) {
		File dir = new File(DIR);
		Queue<File> fileQueue = new ConcurrentLinkedQueue<File>();
		fileQueue.add(dir);
		while (!fileQueue.isEmpty()) {
			File file = fileQueue.poll();
			if (null == file || !file.exists()) {
				continue;
			} else if (file.isDirectory()) {
				File[] subFiles = file.listFiles();
				for (File sf : subFiles) {
					fileQueue.add(sf);
				}
			}
			
			if(match(file)) {
				process(file);
			} 
		}

	}
	
	private static boolean match(File file) {
		if (file.getName().endsWith("finstr")) {
			return true;
		}
		return false;
	}
	
	private static void process(File file) {

	}

}
