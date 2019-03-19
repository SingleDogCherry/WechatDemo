package com.wechat.global.lottery;

import java.io.Serializable;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author cherryxing 中奖级别
 *
 */

public final class LotteryLevel implements Comparable<LotteryLevel>, Serializable {
	public static final LotteryLevel OFF;
	public static final LotteryLevel FIRST;
	public static final LotteryLevel SECOND;
	public static final LotteryLevel THIRD;
	public static final LotteryLevel FOURTH;
	public static final LotteryLevel FIFTH;
	public static final LotteryLevel SIXTH;
	public static final LotteryLevel ALL;

	public static final String CATEGORY = "LotteryLevel";

	private static final ConcurrentMap<String, LotteryLevel> LEVELS = new ConcurrentHashMap<>(); // SUPPRESS CHECKSTYLE

	private static final long serialVersionUID = 1L;
	static {
		OFF = new LotteryLevel("未中奖", StandardLotteryLevel.OFF.intLevel());
		FIRST = new LotteryLevel("一等奖", StandardLotteryLevel.FIRST.intLevel());
		SECOND = new LotteryLevel("二等奖", StandardLotteryLevel.SECOND.intLevel());
		THIRD = new LotteryLevel("三等奖", StandardLotteryLevel.THIRD.intLevel());
		FOURTH = new LotteryLevel("四等奖", StandardLotteryLevel.FOURTH.intLevel());
		FIFTH = new LotteryLevel("五等奖", StandardLotteryLevel.FIFTH.intLevel());
		SIXTH = new LotteryLevel("六等奖", StandardLotteryLevel.SIXTH.intLevel());
		ALL = new LotteryLevel("ALL", StandardLotteryLevel.ALL.intLevel());
	}
	private final StandardLotteryLevel standardLotteryLevel;
	private final String name;
	private final int intLevel;

	private LotteryLevel(final String name, final int intLevel) {
		if (isEmpty(name)) {
			throw new IllegalArgumentException("Illegal null or empty LotteryLevel name.");
		}
		if (intLevel < 0) {
			throw new IllegalArgumentException("Illegal LotteryLevel int less than zero.");
		}
		this.name = name;
		this.intLevel = intLevel;
		this.standardLotteryLevel = StandardLotteryLevel.getStandardLotteryLevel(intLevel);
		if (LEVELS.putIfAbsent(name, this) != null) {
			throw new IllegalStateException("LotteryLevel " + name + " has already been defined.");
		}
	}

	@Override
	public int compareTo(final LotteryLevel other) {
		// TODO Auto-generated method stub
		return intLevel < other.intLevel ? -1 : (intLevel > other.intLevel ? 1 : 0);
	}

	/**
	 * Gets the integral value of this LotteryLevel.
	 *
	 * @return the value of this LotteryLevel.
	 */
	public int intLevel() {
		return this.intLevel;
	}

	public StandardLotteryLevel getStandardLotteryLevel() {
		return standardLotteryLevel;
	}

	public LotteryLevel getLotteryLevel(final String name) {
		return LEVELS.get(name);
	}

	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	@Override
	
	// CHECKSTYLE:OFF
	public LotteryLevel clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	@Override
	public boolean equals(final Object other) {
		return other instanceof LotteryLevel && other == this;
	}

	public Class<StandardLotteryLevel> getDeclaringClass() {
		return StandardLotteryLevel.class;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	public String name() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * Retrieves an existing Level or creates on if it didn't previously exist.
	 *
	 * @param name     The name of the level.
	 * @param intValue The integer value for the Level. If the level was previously
	 *                 created this value is ignored.
	 * @return The Level.
	 * @throws java.lang.IllegalArgumentException if the name is null or intValue is
	 *         less than zero.
	 */
	public static LotteryLevel forName(final String name, final int intValue) {
		final LotteryLevel level = LEVELS.get(name);
		if (level != null) {
			return level;
		}
		try {
			return new LotteryLevel(name, intValue);
		} catch (final IllegalStateException ex) {
			// The level was added by something else so just return that one.
			return LEVELS.get(name);
		}
	}

	/**
	 * Return the Level associated with the name or null if the Level cannot be
	 * found.
	 *
	 * @param name The name of the Level.
	 * @return The Level or null.
	 */
	public static LotteryLevel getLevel(final String name) {
		return LEVELS.get(name);
	}

	public static LotteryLevel toLevel(final String sArg) {
		return toLotteryLevel(sArg, LotteryLevel.OFF);
	}

	/**
	 * Converts the string passed as argument to a level. If the conversion fails,
	 * then this method returns the value of <code>defaultLevel</code>.
	 *
	 * @param name         The name of the desired Level.
	 * @param defaultLevel The Level to use if the String is invalid.
	 * @return The Level associated with the String.
	 */
	public static LotteryLevel toLotteryLevel(final String name, final LotteryLevel defaultLevel) {
		if (name == null) {
			return defaultLevel;
		}
		final LotteryLevel level = LEVELS.get(toUpperCase(name));
		return level == null ? defaultLevel : level;
	}

	private static String toUpperCase(final String name) {
		return name.toUpperCase(Locale.ENGLISH);
	}

	/**
	 * Return an array of all the Levels that have been registered.
	 *
	 * @return An array of Levels.
	 */
	public static LotteryLevel[] values() {
		final Collection<LotteryLevel> values = LotteryLevel.LEVELS.values();
		return values.toArray(new LotteryLevel[values.size()]);
	}

	/**
	 * Return the Level associated with the name.
	 *
	 * @param name The name of the Level to return.
	 * @return The Level.
	 * @throws java.lang.NullPointerException if the Level name is {@code null}.
	 * @throws java.lang.IllegalArgumentException if the Level name is not
	 *         registered.
	 */
	public static LotteryLevel valueOf(final String name) {
		Objects.requireNonNull(name, "No LotteryLevel name given.");
		final String levelName = toUpperCase(name);
		final LotteryLevel level = LEVELS.get(levelName);
		if (level != null) {
			return level;
		}
		throw new IllegalArgumentException("Unknown LotteryLevel constant [" + levelName + "].");
	}

	public static <T extends Enum<T>> T valueOf(final Class<T> enumType, final String name) {
		return Enum.valueOf(enumType, name);
	}

	// for deserialization
	protected Object readResolve() {
		return LotteryLevel.valueOf(this.name);
	}

}
