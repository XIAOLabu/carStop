package cn.gx.czz.model;

import java.util.List;

/**
 * ������ҳ��ѯģ��
 * 
 * @author ASUS
 *
 * @param <T>
 *            ��Ҫ�õ�ʱ��������
 */
public class Page<T> {
	private Integer pageNow; // ��ǰҳ��
	@SuppressWarnings("unused")
	private Integer pageCount;// ��ҳ��
	private Integer rowCount; // ������
	private Integer pageSize; // ÿһҳ����
	private List<T> pageRow; // ��ǰҳ�������

	public Page() {
		super();
	}

	/**
	 * 
	 * @param pageNow
	 *            ��ǰҳ��
	 * @param pageCount
	 *            ��ҳ��
	 * @param rowCount
	 *            ������
	 * @param pageSize
	 *            ÿһҳ����
	 * @param pageRow
	 *            ��ǰҳ�������
	 */
	public Page(Integer pageNow, Integer pageCount, Integer rowCount, Integer pageSize, List<T> pageRow) {
		super();
		this.pageNow = pageNow;
		this.pageCount = pageCount;
		this.rowCount = rowCount;
		this.pageSize = pageSize;
		this.pageRow = pageRow;
	}

	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getPageCount() {
		Integer pageCount = rowCount % pageSize == 0 ? rowCount / pageSize : (rowCount / pageSize + 1);
		// ����������50�����ܹ���5�����ģ���ô����10ҳ
		// ����������51�����ܹ���5�����ģ���ô����11ҳ
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getPageRow() {
		return pageRow;
	}

	public void setPageRow(List<T> pageRow) {
		this.pageRow = pageRow;
	}

}
