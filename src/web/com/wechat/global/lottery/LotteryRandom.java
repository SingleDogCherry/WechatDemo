package com.wechat.global.lottery;

import java.util.Arrays;
import java.util.HashSet;

/***
 * @author cherryxing
 * @category 彩票随机算法
 * 
 */
public class LotteryRandom {
	private Lottery lottery;
	private LottreryResult ltr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LotteryRandom lotr = new LotteryRandom();
		// lotr.setLottery_blue(new int[5]);
		// lotr.setLottery_red(new int[2]);
		lotr.setLottery(new Lottery());
		lotr.daletou();
		// int[] def_red = { 06, 22, 26, 28, 31 };
		// int[] def_blue = { 01, 07 };
		// ArrayList<Integer> def_red = new h
		StandardLotteryLevel stLevel = StandardLotteryLevel.getStandardLotteryLevel(0);
		System.out.println("等级是：" + stLevel.intLevel());
		boolean bflag = LotteryRandom.isEmpty("2");
		System.out.println("输出的内容是 ： " + bflag);
		int[] temp = { 1, 2, 3, 3 };
		Arrays.sort(temp);
		System.out.println("相同内容数组输出" + Arrays.toString(temp));
		Lottery mylottery = null, resulteLotter = null;
		String[] def_red = { "06", "22", "26", "28", "31" };
		String[] def_blue = { "03", "04" };
		String[] def_red1 = { "06", "22", "26", "28", "31" };
		String[] def_blue1 = { "01", "07" };
		mylottery = new Lottery();
		resulteLotter = new Lottery();
		Arrays.asList(def_blue).toString();

		mylottery.setLottery_blue(new HashSet<String>(Arrays.asList(def_blue)));
		mylottery.setLottery_red(new HashSet<>(Arrays.asList(def_red)));
		resulteLotter.setLottery_blue(new HashSet<>(Arrays.asList(def_blue1)));
		resulteLotter.setLottery_red(new HashSet<>(Arrays.asList(def_red1)));
		lotr.checkDaletou(mylottery, resulteLotter);

	}

	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	/**
	 * 判断大乐透是否中奖
	 * 
	 * 调用之前自行判断输入参数是否为空 或者返回空对象
	 */
	public LottreryResult checkDaletou(Lottery mylottery, Lottery resulteLotter) {
		ltr = new LottreryResult();
		if (mylottery.equals(null) || resulteLotter.equals(null)) {
			System.out.println("传入参数为空");
		} else {
			/**
			 * 1.如果是仅仅判断是否中奖，将两个数组合并，去重后，比较数组长度即可 2.不仅要判断是否中奖，还要判断哪几个元素中奖了
			 * 
			 */
			HashSet<?> red_set = resulteLotter.getLottery_red();
			red_set.retainAll(mylottery.getLottery_red());
			HashSet<?> blue_set = resulteLotter.getLottery_blue();
			blue_set.retainAll(mylottery.getLottery_blue());
			System.out.println("篮球的相同元素个数     ：------" + blue_set.size());
			ltr.setBlueResult(blue_set);
			ltr.setRedResult(red_set);
			if (red_set.size() == 5 && blue_set.size() == 2) {
				ltr.setLotteryLevel(LotteryLevel.FIRST);
			} else if (red_set.size() == 5 && blue_set.size() == 1) {
				ltr.setLotteryLevel(LotteryLevel.SECOND);
			} else if ((red_set.size() == 5 && blue_set.size() == 0) || (red_set.size() == 4 && blue_set.size() == 2)) {
				ltr.setLotteryLevel(LotteryLevel.THIRD);
			} else if ((red_set.size() == 4 && blue_set.size() == 1) || (red_set.size() == 3 && blue_set.size() == 2)) {
				ltr.setLotteryLevel(LotteryLevel.FOURTH);
			} else if ((red_set.size() == 4 && blue_set.size() == 0) || (red_set.size() == 3 && blue_set.size() == 1)
					|| (red_set.size() == 2 && blue_set.size() == 2)) {
				ltr.setLotteryLevel(LotteryLevel.FIFTH);
			} else if ((red_set.size() == 3 && blue_set.size() == 0) || (red_set.size() == 1 && blue_set.size() == 2)
					|| (red_set.size() == 2 && blue_set.size() == 1) || (red_set.size() == 0 && blue_set.size() == 2)) {
				ltr.setLotteryLevel(LotteryLevel.SIXTH);
			} else {
				ltr.setLotteryLevel(LotteryLevel.OFF);
			}
		}
		return ltr;
	}

	/**
	 * 大乐透随机算法
	 * 
	 */
	void daletou() {
		int lottery_red[] = new int[5];
		int lottery_blue[] = new int[2];
		int redLength = 35;
		int[] red = new int[redLength];
		int blueLength = 12;
		int[] blue = new int[blueLength];
		for (int i = 0; i < red.length; i++) {
			red[i] = i + 1;
		}
		for (int i = 0; i < blue.length; i++) {
			blue[i] = i + 1;
		}
		System.out.println("所有红球" + Arrays.toString(red));
		System.out.println("所有蓝球" + Arrays.toString(blue));

		for (int i = 0; i < lottery_red.length; i++) {
			int temp = (int) (Math.random() * redLength);
			lottery_red[i] = red[temp];
			red[temp] = red[redLength - 1];
			redLength--;
		}

		for (int i = 0; i < lottery_blue.length; i++) {
			int temp = (int) (Math.random() * blueLength);
			lottery_blue[i] = blue[temp];
			blue[temp] = blue[blueLength - 1];
			blueLength--;
		}

		System.out.println();
		Arrays.sort(lottery_red);
		Arrays.sort(lottery_blue);
		System.out.println("红球 " + Arrays.toString(lottery_red));
		System.out.println("篮球 " + Arrays.toString(lottery_blue));
		// lottery = new Lottery();
	}

	/**
	 * 双色球算法
	 * 
	 */
	void shuangseqiu() {

	}

	public LottreryResult getLtr() {
		return ltr;
	}

	public void setLtr(LottreryResult ltr) {
		this.ltr = ltr;
	}

	public Lottery getLottery() {
		return lottery;
	}

	public void setLottery(Lottery lottery) {
		this.lottery = lottery;
	}

}
