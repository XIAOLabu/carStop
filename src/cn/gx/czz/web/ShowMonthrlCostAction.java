package cn.gx.czz.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.gx.czz.model.MomCost;
import cn.gx.czz.model.Stop;
import cn.gx.czz.service.MomCostService;
import cn.gx.czz.service.StopService;
import cn.gx.czz.util.AppException;

/**
 * 配置查询月报表的Action
 * 
 * @author ASUS
 *
 */
public class ShowMonthrlCostAction extends ActionSupport {

	/**
	 * 兼容性
	 */
	private static final long serialVersionUID = 1L;
	private int mi = 0; // 获取操作指令
	private Stop stop = new Stop();
	private StopService stopService = new StopService();
	private Timestamp s_citt;
	HttpServletRequest request = ServletActionContext.getRequest();
	private List<Stop> stopList;
	private MomCostService momService = new MomCostService();
	private List<MomCost> momcostList;
	private String message;

	@Override
	public String execute() throws AppException {
		try {
			System.out.println(mi);
			// 获取当前时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null, date1 = null; // 初始化日期 第一天， 最后一天
			switch (mi) {

			case 0:
				// 获取当前月第一天：
				Calendar c = Calendar.getInstance();
				c.add(Calendar.MONTH, 0);
				c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
				String first = format.format(c.getTime());
				System.out.println("===============first:" + first);
				// 把字符类型 的日期转换为 Date 类型日期 再转换为 时间戳类型的日期
				date = new SimpleDateFormat("yyyy-MM-dd").parse(first);
				stop.setS_cit(new Timestamp(date.getTime()));
				// 获取当前月最后一天
				Calendar ca = Calendar.getInstance();
				ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
				String last = format.format(ca.getTime());
				System.out.println("===============last:" + last);
				// 把字符类型 的日期转换为 Date 类型日期 再转换为 时间戳类型的日期
				date1 = new SimpleDateFormat("yyyy-MM-dd").parse(last);
				s_citt = new Timestamp(date1.getTime());
				message = first.toString().split("-")[0] + "-" + first.toString().split("-")[1] + "  收费表";
				break;

			case -1:
				// 获取前月的第一天
				Calendar cal_1 = Calendar.getInstance();// 获取当前日期
				cal_1.add(Calendar.MONTH, -1);
				cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
				String firstDay = format.format(cal_1.getTime());
				System.out.println("-----1------firstDay:" + firstDay);
				// 把字符类型 的日期转换为 Date 类型日期 再转换为 时间戳类型的日期
				date = new SimpleDateFormat("yyyy-MM-dd").parse(firstDay);
				stop.setS_cit(new Timestamp(date.getTime()));
				// 获取前月的最后一天
				Calendar cale_1 = Calendar.getInstance();
				cale_1.set(Calendar.DAY_OF_MONTH, 0);// 设置为1号,当前日期既为本月第一天
				String lastDay = format.format(cale_1.getTime());
				System.out.println("-----2------lastDay:" + lastDay);
				// 把字符类型 的日期转换为 Date 类型日期 再转换为 时间戳类型的日期
				date1 = new SimpleDateFormat("yyyy-MM-dd").parse(lastDay);
				s_citt = new Timestamp(date1.getTime());
				message = firstDay.toString().split("-")[0] + "-" + firstDay.toString().split("-")[1] + "  收费表";
				break;

			case -2:
				// 获取前两个月的第一天
				Calendar cal_2 = Calendar.getInstance();// 获取当前日期
				cal_2.add(Calendar.MONTH, -2);
				cal_2.set(Calendar.DAY_OF_MONTH, 1);
				String firsttwoDay = format.format(cal_2.getTime());
				System.out.println("-----1------firsttwoDay:" + firsttwoDay);
				// 把字符类型 的日期转换为 Date 类型日期 再转换为 时间戳类型的日期
				date = new SimpleDateFormat("yyyy-MM-dd").parse(firsttwoDay);
				stop.setS_cit(new Timestamp(date.getTime()));
				// System.out.println(stop.getS_cit());

				// 获取前两个月的最后一天
				Calendar cale_2 = Calendar.getInstance();// 获取当前日期
				cale_2.set(Calendar.DAY_OF_MONTH, 0);
				cale_2.add(Calendar.MONTH, -2);
				cale_2.add(Calendar.DATE, 29);
				String lastTwoDay = format.format(cale_2.getTime());
				System.out.println("-----2------lastTwoDay:" + lastTwoDay);
				// 把字符类型 的日期转换为 Date 类型日期 再转换为 时间戳类型的日期
				date1 = new SimpleDateFormat("yyyy-MM-dd").parse(lastTwoDay);
				s_citt = new Timestamp(date1.getTime());
				// System.out.println(s_citt);
				message = lastTwoDay.toString().split("-")[0] + "-" + lastTwoDay.toString().split("-")[1] + "  收费表";
				break;

			default:
				message = "查询失败：请重新查询";
				// System.out.println("查询失败！");
				break;
			}
			stopList = stopService.queryStop(stop, s_citt);
			System.out.println(stopList);
			java.sql.Date sql_date = new java.sql.Date(date.getTime());// 每个月的第一天
			java.sql.Date sql_date1 = new java.sql.Date(date1.getTime());// 每个月的最后一天
			momcostList = momService.selectDate(sql_date, sql_date1);
			for (int i = 0; i < momcostList.size(); i++) {
				System.out.println(momcostList.get(i));
			}
			request.setAttribute("momcostList", momcostList);
			return "showMonthly";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getMi() {
		return mi;
	}

	public void setMi(int mi) {
		this.mi = mi;
	}

}
