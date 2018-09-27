package anue.project1.model;

import org.springframework.stereotype.Component;

@Component
public class VideoDataFromDb {
	private String filedA;
	private String filedB;
	private String filedC;

	public String getFiledA() {
		return filedA;
	}

	public void setFiledA(String filedA) {
		this.filedA = filedA;
	}

	public String getFiledB() {
		return filedB;
	}

	public void setFiledB(String filedB) {
		this.filedB = filedB;
	}

	public String getFiledC() {
		return filedC;
	}

	public void setFiledC(String filedC) {
		this.filedC = filedC;
	}
}
