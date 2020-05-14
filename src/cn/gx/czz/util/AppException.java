package cn.gx.czz.util;

/**
 * �Զ����쳣��
 * 
 * @author ASUS
 *
 */
public class AppException extends Exception {
	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private int exceptionCode;// �쳣���
	private String message;// �쳣��Ϣ

	/**
	 * ���췽���������쳣��Ϣ
	 * 
	 * @param message
	 */
	public AppException(String message) {
		super();
		this.message = message;
	}

	/**
	 * ���췽���������쳣��Ϣ���쳣���
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
	 * ��ȡ�쳣���
	 * 
	 * @return
	 */
	public int getExceptionCode() {
		return exceptionCode;
	}

	/**
	 * ��ȡ��ϸ���쳣��Ϣ
	 * 
	 * @return detailMessage
	 */
	public String getMessage() {
		String detailMessage = "Detail message:" + exceptionCode + " " + message;
		return detailMessage;
	}

}
