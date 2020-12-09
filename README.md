# lab3
## 阅读程序：
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



package j;


public interface StudentInterface {
	
	// 设置学生的学费
	public abstract void setFee(double fee);
	
	// 获取学生的学费
	public abstract void getFee(double fee);
}





package j;


public interface TeacherInterface {
	
	// 设置教师的工资
	public abstract void setPay(double pay);
	
	// 获取教师的工资
	public abstract void getPay(double pay);
}



## 实验目的
掌握Java中抽象类和抽象方法的定义； 
掌握Java中接口的定义，熟练掌握接口的定义形式以及接口的实现方法
了解异常的使用方法，并在程序中根据输入情况做异常处理

## 实验内容
某学校为了给学生提供勤工俭学机会，也减轻授课教师的部分压力，准许博士研究生参与课程的助教工作。此时，该博士研究生有双重身份：学生和助教教师。
设计两个管理接口：学生管理接口和教师管理接口。学生接口必须包括缴纳学费、查学费的方法；教师接口包括发放薪水和查询薪水的方法。
设计博士研究生类，实现上述的两个接口，该博士研究生应具有姓名、性别、年龄、每学期学费、每月薪水等属性。（其他属性及方法，可自行发挥）
编写测试类，并实例化至少两名博士研究生，统计他们的年收入和学费。根据两者之差，算出每名博士研究生的年应纳税金额（国家最新工资纳税标准，请自行检索）。

## 思路
① 产生异常的条件是余额少于取额，因此是否抛出异常要先判断该条件。
② 确定产生异常的方法，应该在取钱方法（withdrawal）中产生异常InsufficientFundsException 。
③ 处理异常安排在调用withdrawal的时候，因此withdrawal方法要声明异常，由上级方法捕获并处理。
④ 要定义好自己的异常
NumberFormatException异常在当字符串转换成整型而字符串格式错误时出现，是数字格式匹配的失误
因此首先设置两个String类型实例，代表两个字符串
String num1,num2;
这两个实例在输入后转换成整型时可能会抛出NumberFormatException异常
例如如果输入的内容无法转换则就会返回这个异常

## 体会
本次的实验是新学的知识：异常处理，这在之前的C++语言中是没有接触过的，因此在写这块的程序的时候比较卡手，需要先查找每个异常或错误对应的类型和出现的情况并在程
序的try块中实现对异常的抛出，在catch语句中实现处理，也因为这个原因，在写这块的代码的时候会对这块的东西印象更为深刻。同时对try-catch模式的代码有了更深的理
解，实践出真知，在理论学习时总是以为自己听懂了，但只有在自己真的去实现和使用出现各种问题的时候才会对知识有更深一步的理解和记忆。
