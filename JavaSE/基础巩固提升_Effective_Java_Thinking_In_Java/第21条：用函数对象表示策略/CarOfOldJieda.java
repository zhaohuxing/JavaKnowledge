public class CarOfOldJieda implements Car {
	@Override
	public void lightSimulate() {
		System.out.println("向右转两次，开启近光灯");
		System.out.println("向上拨开启远光灯");
		System.out.println("向上拨关闭远光灯");
		System.out.println("向上拨四次近远光灯交替");
		System.out.println("向左转两次关闭灯光");
	}

	@Override
	public void otherProgram() {
		System.out.println("起步");
		System.out.println("...........");
		System.out.println("考试合格请求大厅打印成绩");
	}
}
