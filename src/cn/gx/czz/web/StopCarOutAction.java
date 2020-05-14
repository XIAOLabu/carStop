package cn.gx.czz.web;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gx.czz.model.Cost;
import cn.gx.czz.model.MomCost;
import cn.gx.czz.model.Mrate;
import cn.gx.czz.model.Stop;
import cn.gx.czz.service.CostService;
import cn.gx.czz.service.MomCostService;
import cn.gx.czz.service.MrateService;
import cn.gx.czz.service.PosiTionService;
import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * 配置停车车辆出场的Action
 * 
 * @author ASUS
 *
 */
public class StopCarOutAction extends ActionSupport implements ModelDriven<Stop> {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private Stop stop = new Stop(); // 初始化停车信息实体类
	private Date date; // 获取当前时间
	private StopService stopService = new StopService();
	private PosiTionService positionService = new PosiTionService();
	private String c; // 获取停车位置的号码
	private CostService costService = new CostService();
	private Cost cost = new Cost(); // 初始化 停车费用实体类
	private MrateService mrateService = new MrateService();
	private Mrate mrate = new Mrate(); // 初始化 停车费率实体类
	HttpServletRequest erquest = ServletActionContext.getRequest();
	private MomCost momcost = new MomCost();
	private MomCostService momService = new MomCostService();

	@Override
	public Stop getModel() {
		// TODO Auto-generated method stub
		return stop;
	}

	@Override
	public String execute() throws AppException {
		try {
			// 通过s_id获取原来对象信息
			stop = stopService.selectStop(stop.getS_id());
			date = new Date();
			stop.setS_cot(new Timestamp(date.getTime()));
			long i = (stop.getS_cot().getTime() - stop.getS_cit().getTime()) / (60 * 60 * 1000);
			// 不足一小时 按一小时扣费
			if (i == 0) {
				stop.setS_time(1);
			} else {
				stop.setS_time((int) i);
			}
			c = stop.getS_tcw().substring(3);
			boolean b = positionService.isnoadd(c);
			if (b) {
				// 入场时，记录该车位，并更新车位状态
				positionService.upcw_state(c, "闲置");
			}
			// 对原对象 写入新的信息 --车辆出场时间、车辆停放时长 ---再把新的对象信息存回去
			cost.setM_time(stop.getS_time());
			cost.setM_cno(stop.getS_tcn());
			mrate = mrateService.showMrateObj();
			if (stop.getS_tcu() == 0) {
				cost.setM_charge(mrate.getR_scu());
			} else {
				cost.setM_charge(mrate.getR_scutmp());
			}
			double op = cost.getM_time() * cost.getM_charge();
			cost.setM_cost(BigDecimal.valueOf(op));
			// 记录该停车车辆用的费用，并存入数据库里
			costService.addCost(cost);
			// 设置该车辆为出场车辆
			stop.setS_cost(BigDecimal.valueOf(op));

			if (stop.getS_tcu() == 0) {
				momcost.setMc_icost(BigDecimal.valueOf(op));
			} else {
				momcost.setMc_zcost(BigDecimal.valueOf(op));
			}
			momcost.setMc_time(new Timestamp(date.getTime()));
			momService.saveData(momcost);

			stopService.up2Stop(stop);
			return "stopOut";
		} catch (AppException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
