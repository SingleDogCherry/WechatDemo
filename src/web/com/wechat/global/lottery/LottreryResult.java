package com.wechat.global.lottery;

import java.util.HashSet;

import com.wechat.global.entity.base.ClassBase;
/**
 * @author cherryxing
 * @category 中奖情况返回类
 * 
 * {@code  redResult}
 * blueResult  蓝球中奖情况
 * lotteryLevel 中奖级别
 */
public class LottreryResult extends ClassBase{
	/**
	 *redResult  红球中奖情况
	 * */
	private HashSet<?>  redResult;
	/**
	 *blueResult  蓝球中奖情况
	 * */
	private HashSet<?>  blueResult;
	/**
	 *lotteryLevel  中奖级别
	 * */
	private LotteryLevel lotteryLevel;
	public HashSet<?> getRedResult() {
		return redResult;
	}
	public void setRedResult(HashSet<?> redResult) {
		this.redResult = redResult;
	}
	public HashSet<?> getBlueResult() {
		return blueResult;
	}
	public void setBlueResult(HashSet<?> blueResult) {
		this.blueResult = blueResult;
	}
	public LotteryLevel getLotteryLevel() {
		return lotteryLevel;
	}
	public void setLotteryLevel(LotteryLevel lotteryLevel) {
		this.lotteryLevel = lotteryLevel;
	}
	
	
	
	
}
