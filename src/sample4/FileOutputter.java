package sample4;

import java.io.FileWriter;

public class FileOutputter implements Outputter {
	private String filePath;
	// set메서드 통해서 주입
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public void output(String message) throws Exception {
		// 메세지 -> 파일에 쓰기
		FileWriter out = new FileWriter(filePath);
		out.write(message);
		out.close();
	}
}
