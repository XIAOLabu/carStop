package cn.gx.czz.model;

import java.util.List;

/**
 * 公共分页查询模板
 * 
 * @author ASUS
 *
 * @param <T>
 *            需要用到时，传的类
 */
public class Page<T> {
	private Integer pageNow; // 当前页数
	@SuppressWarnings("unused")
	private Integer pageCount;// 总页数
	private Integer rowCount; // 总行数
	private Integer pageSize; // 每一页行数
	private List<T> pageRow; // 当前页表格数据

	public Page() {
		super();
	}

	/**
	 * 
	 * @param pageNow
	 *            当前页数
	 * @param pageCount
	 *            总页数
	 * @param rowCount
	 *            总行数
	 * @param pageSize
	 *            每一页行数
	 * @param pageRow
	 *            当前页表格数据
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
		// 假设总数是50，是能够被5整除的，那么就有10页
		// 假设总数是51，不能够被5整除的，那么就有11页
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
