package rest.common;

import java.util.List;

public class ResultObject {
	
	private String result_code;
	private String result_msg;
	
	public ResultObject(String result_code, String result_msg) {
		this.result_code = result_code;
		this.result_msg = result_msg;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getResult_msg() {
		return result_msg;
	}
	public void setResult_msg(String result_msg) {
		this.result_msg = result_msg;
	}

	
}
