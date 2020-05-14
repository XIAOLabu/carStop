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
 * ����ͣ������������Action
 * 
 * @author ASUS
 *
 */
public class StopCarOutAction extends ActionSupport implements ModelDriven<Stop> {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	private Stop stop = new Stop(); // ��ʼ��ͣ����Ϣʵ����
	private Date date; // ��ȡ��ǰʱ��
	private StopService stopService = new StopService();
	private PosiTionService positionService = new PosiTionService();
	private String c; // ��ȡͣ��λ�õĺ���
	private CostService costService = new CostService();
	private Cost cost = new Cost(); // ��ʼ�� ͣ������ʵ����
	private MrateService mrateService = new MrateService();
	private Mrate mrate = new Mrate(); // ��ʼ�� ͣ������ʵ����
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
			// ͨ��s_id��ȡԭ��������Ϣ
			stop = stopService.selectStop(stop.getS_id());
			date = new Date();
			stop.setS_cot(new Timestamp(date.getTime()));
			long i = (stop.getS_cot().getTime() - stop.getS_cit().getTime()) / (60 * 60 * 1000);
			// ����һСʱ ��һСʱ�۷�
			if (i == 0) {
				stop.setS_time(1);
			} else {
				stop.setS_time((int) i);
			}
			c = stop.getS_tcw().substring(3);
			boolean b = positionService.isnoadd(c);
			if (b) {
				// �볡ʱ����¼�ó�λ�������³�λ״̬
				positionService.upcw_state(c, "����");
			}
			// ��ԭ���� д���µ���Ϣ --��������ʱ�䡢����ͣ��ʱ�� ---�ٰ��µĶ�����Ϣ���ȥ
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
			// ��¼��ͣ�������õķ��ã����������ݿ���
			costService.addCost(cost);
			// ���øó���Ϊ��������
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
