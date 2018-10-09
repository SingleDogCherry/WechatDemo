/**
 * 
 */
package com.wechat.global.lottery;

import java.util.EnumSet;


/**
 * @author cherryxing
 *
 */
public enum StandardLotteryLevel {
	OFF(0),
	FIRST(1),
	SECOND(2),
	THIRD(3),
	FOURTH(4),
	FIFTH(5),
	SIXTH(6),
	ALL(Integer.MAX_VALUE)
	;
	private static final EnumSet<StandardLotteryLevel> LEVELSET = EnumSet.allOf(StandardLotteryLevel.class);
	
	
	
	private final int intLevel;

	StandardLotteryLevel(final int val) {
		intLevel = val;
	}

	/**
	 * Returns the integer value of the Level.
	 * 
	 * @return the integer value of the Level.
	 */
	public int intLevel() {
		return intLevel;
	}

	/**
	 * Method to convert custom Levels into a StandardLotteryLevel for conversion to other
	 * systems.
	 * 
	 * @param intLevel The integer value of the Level.
	 * @return The StandardLotteryLevel.
	 */
	public static StandardLotteryLevel getStandardLotteryLevel(final int intLevel) {
		StandardLotteryLevel level = StandardLotteryLevel.OFF;
		for (final StandardLotteryLevel lvl : LEVELSET) {
			if (lvl.intLevel() > intLevel) {
				break;
			}
			level = lvl;
		}
		return level;
	}

}
