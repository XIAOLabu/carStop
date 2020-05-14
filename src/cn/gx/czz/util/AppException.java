package cn.gx.czz.util;

/**
 * 自定义异常类
 * 
 * @author ASUS
 *
 */
public class AppException extends Exception {
	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private int exceptionCode;// 异常编号
	private String message;// 异常消息

	/**
	 * 构造方法，设置异常消息
	 * 
	 * @param message
	 */
	public AppException(String message) {
		super();
		this.message = message;
	}

	/**
	 * 构造方法，设置异常消息和异常编号
	 * 
	 * @param exceptionCode
	 * @param message
	 */
	public AppException(int exceptionCode, String message) {
		super();
		this.exceptionCode = exceptionCode;
		this.message = message;
	}

	/**
	 * 获取异常编号
	 * 
	 * @return
	 */
	public int getExceptionCode() {
		return exceptionCode;
	}

	/**
	 * 获取详细的异常消息
	 * 
	 * @return detailMessage
	 */
	public String getMessage() {
		String detailMessage = "Detail message:" + exceptionCode + " " + message;
		return detailMessage;
	}

}
