package cn.gx.czz.dao;

import java.util.List;

import cn.gx.czz.model.Page;
import cn.gx.czz.model.PosiTion;
import cn.gx.czz.util.AppException;

/**
 * 车位数据 访问接口
 * 
 * @author ASUS
 *
 */
public interface PosiTionDao {

	/**
	 * 检查是否有车位号重复
	 * 
	 * @param cw_no
	 *            车位号
	 * @return
	 * @throws AppException
	 */
	public boolean isPosi(String cw_no) throws AppException;

	/**
	 * 新增车位信息
	 * 
	 * @param positon
	 *            车位对象
	 * @return
	 * @throws AppException
	 */
	public boolean addPosi(PosiTion position) throws AppException;

	/**
	 * 车位分页查询显示
	 * 
	 * @param pageSize
	 *            每一页行数
	 * @param pageNow
	 *            当前页数
	 * @return
	 * @throws AppException
	 */
	public Page<PosiTion> querPage(int pageSize, int pageNow) throws AppException;

	/**
	 * 根据车位ID删除车位对象
	 * 
	 * @param cw_id
	 *            车位ID
	 * @return
	 * @throws AppException
	 */
	public boolean deleteUser(int cw_id) throws AppException;

	/**
	 * 根据车位ID查询车位对象信息 并返回车位对象集合
	 * 
	 * @param cw_id
	 *            车位ID
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_id(int cw_id) throws AppException;

	/**
	 * 根据车位用户查询车位对象信息 并返回车位对象集合
	 * 
	 * @param cw_user
	 *            车位用户
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_user(String cw_user) throws AppException;

	/**
	 * 根据车位类型查询车位对象信息 并返回车位对象集合
	 * 
	 * @param cw_type
	 *            车位类型
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_type(int cw_type) throws AppException;

	/**
	 * 根据车位状态查询车位对象信息 并返回车位对象集合
	 * 
	 * @param cw_state
	 *            车位状态
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_state(String cw_state) throws AppException;

	/**
	 * 根据车位位置查询车位对象信息 并返回车位对象集合
	 * 
	 * @param cw_wz
	 *            车位位置
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_wz(String cw_wz) throws AppException;

	/**
	 * 对获取到的车位对象进行更新
	 * 
	 * @param position
	 *            车位对象实体
	 * @return
	 * @throws AppException
	 */
	public boolean updatePosi(PosiTion position) throws AppException;

	/**
	 * 根据传回来的车位号 对车位状态进行更改 、、、、 车辆入场时调用一次 车辆出场时调用一次
	 * 
	 * @param cw_no
	 *            车位号
	 * @return
	 * @throws AppException
	 */
	public boolean upcw_state(String cw_no, String cw_state) throws AppException;

}
