package com.example.challenge.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @author <a href="mailto:abeljose13@gmail.com">Avelardo Gavide</a>
 *
 */
public abstract class ChallengeUtil 
{
	/**
	 * Validate if parameter date is before to current date
	 * 
	 * @param date
	 * @return boolean value
	 */
	public static boolean isPastDate(LocalDate date)
	{
		LocalDate currentDate = LocalDate.now();
		
		if (date.isBefore(currentDate))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Validate that the checkinDate is before that checkoutDate
	 * 
	 * @param checkinDate
	 * @param checkoutDate
	 * @return boolean value
	 */
	public static boolean isValidCheckinDate(LocalDate checkinDate, LocalDate checkoutDate)
	{
		if (checkinDate.isBefore(checkoutDate))
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * Return numbers of days of reservation
	 * 
	 * @param checkinDate
	 * @param checkoutDate
	 * @return Numbers of days
	 */
	public static long isValidCheckoutDays(LocalDate checkinDate, LocalDate checkoutDate)
	{
		return ChronoUnit.DAYS.between(checkinDate, checkoutDate);
	}
}
