package j;


import java.util.Scanner;
 
/**
 * 研究生类
 * @author Administrator
 *
 */
public class Graduate implements StudentInterface,TeacherInterface{
	// 成员变量
	String name;
	String sex;
	int age;
	double fee;
	double pay;
	
	// 实现接口中的抽象方法
	@Override
	public void setPay(double pay) {
		this.pay = pay * 12;
		System.out.println("你的年收入为：" + this.pay);
	}
	
	// 实现接口中的抽象方法
	@Override
	public void getPay(double pay) {
		this.pay = pay * 12;
		System.out.println("你的年收入为：" + this.pay);
	}
	
	// 实现接口中的抽象方法
	@Override
	public void setFee(double fee) {
		this.fee = fee;
		System.out.println("你的学费设置为：" + this.fee);
	}
	
	// 实现接口中的抽象方法
	@Override
	public void getFee(double fee) {
		this.fee = fee;
		System.out.println("你的学费为：" + this.fee);
	}
	
	/**
	 *  是否要贷款
	 * @return
	 */
	public boolean Loan(){
		if ((this.pay - this.fee) < 2000) {
			System.out.println("你的年收入" + this.pay + ",减去学费" + this.fee + "等于" + (this.pay - this.fee));
			return true;
		}
		System.out.println("你的年收入" + this.pay + ",减去学费" + this.fee + "等于" + (this.pay - this.fee));
		return false;
	}
	
	public static void main(String[] args) {
		// 创建一个研究生对象
		Graduate graduate = new Graduate();
		// 研究生对象的初始化
		graduate.name = "zhangsan";
		System.out.println("你好:" + graduate.name);
		
		// 设置月工资
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你的月工资：");
		double pay = scanner.nextDouble();
		graduate.setPay(pay);
		
		// 设置学费
		System.out.println("请输入你的学费：");
		double fee = scanner.nextDouble();
		graduate.setFee(fee);
		
		// 判断是否需要贷款
		boolean flag = graduate.Loan();
		if (flag) {
			System.out.println("provide a loan(需要贷款)");
		}else {
			System.out.println("自给自足，丰衣足食");
		}
	}
 
}
