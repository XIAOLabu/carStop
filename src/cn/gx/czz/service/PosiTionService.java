package cn.gx.czz.service;

import java.util.List;

import cn.gx.czz.dao.PosiTionDao;
import cn.gx.czz.dao.impl.PosiTionDaoImpl;
import cn.gx.czz.model.Page;
import cn.gx.czz.model.PosiTion;
import cn.gx.czz.util.AppException;

/**
 * 车位业务逻辑类
 * 
 * @author ASUS
 *
 */
public class PosiTionService {
	// 初始化用户数据库访问实现层
	private PosiTionDao positionDao = new PosiTionDaoImpl();

	/**
	 * 进行重名判断
	 * 
	 * @param cw_no
	 *            车位号
	 * @return
	 * @throws AppException
	 */
	public boolean isnoadd(String cw_no) throws AppException {
		boolean flag = true;
		try {
			flag = positionDao.isPosi(cw_no);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.isnoadd");
		}
		return flag;

	}

	/**
	 * 对增加车位进行保存到数据库
	 * 
	 * @param position
	 *            车位信息对象
	 * @return
	 * @throws AppException
	 */
	public boolean addseve(PosiTion position) throws AppException {
		boolean flag = false;
		try {
			// 对车位号进行相同判断
			if (!positionDao.isPosi(position.getCw_no())) {
				flag = positionDao.addPosi(position);
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.addseve");
		}
		// 增加成功，返回true ,否者返回false
		return flag;
	}

	/**
	 * 分页查询
	 * 
	 * @param pageSize
	 *            每一页行数
	 * @param pageNow
	 *            当前页数
	 * @return
	 * @throws AppException
	 */
	public Page<PosiTion> querPage(Integer pageSize, Integer pageNow) throws AppException {
		try {
			return positionDao.querPage(pageSize, pageNow);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.querPage");
		}

	}

	/**
	 * 根据车位ID删除该车位对象
	 * 
	 * @param cw_id
	 *            车位ID
	 * @return
	 * @throws AppException
	 */
	public boolean deletePosi(int cw_id) throws AppException {
		try {
			return positionDao.deleteUser(cw_id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.deletePosi");
		}
	}

	/**
	 * 根据车位ID查询车位对象信息
	 * 
	 * @param cw_id
	 *            车位ID
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_id(int cw_id) throws AppException {
		List<PosiTion> flag = null;
		try {
			flag = positionDao.selectPostcw_id(cw_id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.selectPostcw_id");
		}
		return flag;
	}

	/**
	 * 根据车位用户查询车位对象信息
	 * 
	 * @param cw_user
	 *            车位用户
	 * @return
	 */
	public List<PosiTion> selectPostcw_user(String cw_user) throws AppException {
		List<PosiTion> flag = null;
		try {
			flag = positionDao.selectPostcw_user(cw_user);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.selectPostcw_user");
		}
		return flag;
	}

	/**
	 * 根据车位位置查询车位对象信息
	 * 
	 * @param cw_wz
	 *            车位位置
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_wz(String cw_wz) throws AppException {
		List<PosiTion> flag = null;
		try {
			flag = positionDao.selectPostcw_wz(cw_wz);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.selectPostcw_wz");
		}
		return flag;
	}

	/**
	 * 根据车位状态查询车位对象信息
	 * 
	 * @param cw_state
	 *            车位状态
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_state(String cw_state) throws AppException {
		List<PosiTion> flag = null;
		try {
			flag = positionDao.selectPostcw_state(cw_state);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.selectPostcw_state");
		}
		return flag;
	}

	/**
	 * 根据车位类型查询车位对象信息
	 * 
	 * @param cw_type
	 *            车位类型
	 * @return
	 * @throws AppException
	 */
	public List<PosiTion> selectPostcw_type(int cw_type) throws AppException {
		List<PosiTion> flag = null;
		try {
			flag = positionDao.selectPostcw_type(cw_type);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.selectPostcw_type");
		}
		return flag;
	}

	/**
	 * 对实体进行数据更新
	 * 
	 * @param position
	 *            车位实体对象
	 * @return
	 * @throws AppException
	 */
	public boolean updatePosi(PosiTion position) throws AppException {
		boolean flag;
		try {
			flag = positionDao.updatePosi(position);
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.updatePosi");
		}

	}

	/**
	 * 根据传回来的车位号 对车位状态进行更改 、、、、 车辆入场时调用一次 车辆出场时调用一次
	 * 
	 * @param cw_no
	 *            车位号
	 * @return
	 * @throws AppException
	 */
	public boolean upcw_state(String cw_no, String cw_state) throws AppException {
		boolean flag = false;
		try {
			flag = positionDao.upcw_state(cw_no, cw_state);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.upcw_state");
		}
		return flag;

	}

	/**
	 * 删除选中的车位信息
	 * 
	 * @param pidList
	 *            车位ID集合
	 * @return
	 * @throws AppException
	 */
	public boolean deleteAllPosi(String[] pidList) throws AppException {
		try {
			boolean flag = false;
			for (String cw_id : pidList) {
				flag = positionDao.deleteUser(Integer.parseInt(cw_id));
			}
			return flag;
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("cn.gx.czz.Servie.PosiTionService.upcw_state");
		}
	}

}
