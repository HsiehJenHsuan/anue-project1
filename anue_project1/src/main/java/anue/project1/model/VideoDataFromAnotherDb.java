package anue.project1.model;

import org.springframework.stereotype.Component;

@Component
public class VideoDataFromAnotherDb {
	private String filedD;

	public String getFiledD() {
		return filedD;
	}

	public void setFiledD(String filedD) {
		this.filedD = filedD;
	}

	public String getFiledE() {
		return filedE;
	}

	public void setFiledE(String filedE) {
		this.filedE = filedE;
	}

	private String filedE;
}
