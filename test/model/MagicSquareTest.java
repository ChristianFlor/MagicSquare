package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import customExceptions.IllegalSizeException;
import customExceptions.UncompatibleValuesException;

public class MagicSquareTest {
	
	private void setupScenary1() { }
	private void setupScenary2() { }
	private void setupScenary3() { }
	
	/**
	 * This test verifies the correct creation of a magic square using stage 1
	 * @throws UncompatibleValuesException 
	 * @throws IllegalSizeException 
	 */
	@Test
	public void testMagicSquare() {
		setupScenary1();
		
		String st = "NORTH";
		String di= "NORTHWEST";
		int si= 7;
		
		MagicSquare newMagic1;
		try {
			newMagic1 = new MagicSquare(st, di, si);
			assertNotNull("Fail create a new magic square", newMagic1);
			assertTrue("The start point assigment fail", st.equals(newMagic1.getStartPoint()));
			assertTrue("The direction assigment fail", di.equals(newMagic1.getDirection()));
			assertTrue("The size assigment fail", si==newMagic1.getSize());
		} catch (IllegalSizeException | UncompatibleValuesException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	/**
	 * This test Verify that the magic square is filled correctly.<br>
	 * with 4 possible cases, the first will have 9 verifications and the other 3 will have 2 verifications.
	 * @throws UncompatibleValuesException 
	 * @throws IllegalSizeException 
	 */
	@Test
	public void testMagicSquareGenerate() {
		setupScenary2();
		String st = "WEST";
		String di= "NORTHWEST";
		int si= 5;

		MagicSquare newMagic2;
		try {
			newMagic2 = new MagicSquare(st, di, si);
			assertNotNull("Fail create a new magic square", newMagic2);
			newMagic2.generate();
			assertEquals("The number one is not in the middle of the first column",1,newMagic2.getMagicSquare()[2][0]);
			assertEquals("The number twenty-five is not in the middle of the last column",25,newMagic2.getMagicSquare()[2][4]);
			assertEquals("The number thirteen is not in the middle of the magic square",13,newMagic2.getMagicSquare()[2][2]);
			assertEquals("The number four is not in the middle of the last row",4,newMagic2.getMagicSquare()[4][2]);
			assertEquals("The number twenty-two is not in the middle of the first row",22,newMagic2.getMagicSquare()[0][2]);
			assertEquals("The number fifteen is not in the first position of the row and column of the magic square",15,newMagic2.getMagicSquare()[0][0]);
			assertEquals("The number seventeen is not in the last position of the column and first of the row of the magic square",17,newMagic2.getMagicSquare()[4][0]);
			assertEquals("The number nine is not in the last position of the row and first of the column of the magic square",9,newMagic2.getMagicSquare()[0][4]);
			assertEquals("The number eleven is not in the last position of the row and column of the magic square",11,newMagic2.getMagicSquare()[4][4]);
		} catch (IllegalSizeException | UncompatibleValuesException e) {
			System.out.println(e.getMessage());
		}
		
		
		st = "EAST";
		di= "SOUTHEAST";
		si= 7;
		try {
			newMagic2= new MagicSquare(st, di, si);
			assertNotNull("Fail create a new magic square", newMagic2);
			newMagic2.generate();
			assertEquals("The number one is not in the middle of the first column",1,newMagic2.getMagicSquare()[3][6]);
			assertEquals("The number forty nine is not in the middle of the first column",49,newMagic2.getMagicSquare()[3][0]);
		} catch (IllegalSizeException | UncompatibleValuesException e) {
			System.out.println(e.getMessage());
		}
		
	
		st = "NORTH";
		di= "NORTHWEST";
		si= 13;
		try {
			newMagic2= new MagicSquare(st, di, si);
			assertNotNull("Fail create a new magic square", newMagic2);
			newMagic2.generate();
			assertEquals("The number one is not in the middle of the first row",1,newMagic2.getMagicSquare()[0][6]);
			assertEquals("The one hundred and sixty-nine number is not in the middle of the last row",169,newMagic2.getMagicSquare()[12][6]);
			
		} catch (IllegalSizeException | UncompatibleValuesException e) {
			System.out.println(e.getMessage());
		}
		
		st = "SOUTH";
		di= "SOUTHEAST";
		si= 15;
		try {
			newMagic2= new MagicSquare(st, di, si);
			assertNotNull("Fail create a new magic square", newMagic2);
			newMagic2.generate();
			assertEquals("The number one is not in the middle of the last row",1,newMagic2.getMagicSquare()[14][7]);
			assertEquals("The number two hundred and twenty-five is not in the middle of the first row",225,newMagic2.getMagicSquare()[0][7]);
		
		} catch (IllegalSizeException | UncompatibleValuesException e) {
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * This test Verify that the sum of the rows and columns of the magic square is equal to the calculated magic constant.
	 * @throws UncompatibleValuesException 
	 * @throws IllegalSizeException 
	 */
	@Test
	public void testMagicConstant(){
		setupScenary3();
		String st = "SOUTH";
		String di= "SOUTHWEST";
		int si= 3;
		MagicSquare magic;
		try {
			magic = new MagicSquare(st, di, si);
			magic.generate();
			int constant= magic.magicConstant();
			assertNotNull("Fail create a new magic square", magic);
			int r=0;
			int c=0;
			int a=0;
			int e=0;
			int f=0;
			
			for (int i = 0; i < magic.getMagicSquare().length; i++) {
				r+=magic.getMagicSquare()[i][0];
				for (int j = 0; j < magic.getMagicSquare().length; j++) {
					a=magic.getMagicSquare()[0][0];
					e=magic.getMagicSquare()[1][0];
					f=magic.getMagicSquare()[2][0];
				}
			}
			c=a+e+f;
			assertTrue("The constant is not equal to the row assignment", constant==r);
			assertTrue("The constant is not equal to the column assignment", constant==c);
			
			
		} catch (IllegalSizeException | UncompatibleValuesException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This test verify that the custom exception (Illegal Size Exception) is working correctly <br>
	 * and verify when a number is negative.
	 * @throws UncompatibleValuesException 
	 * @throws IllegalSizeException 
	 */
	@Test
	public void testMagicSquareNegative() {
		setupScenary1();
		try {
			@SuppressWarnings("unused")
			MagicSquare ms = new MagicSquare(MagicSquare.NORTH, MagicSquare.NORTHWEST, -3);
			fail();
		}catch(IllegalSizeException | UncompatibleValuesException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This test verify that the customized exception (IllegalSizeException) is working correctly <br>
	 * and verify when a number is greater than 100, is made by recommendation to the user <br>
	 * so that the computer does not exceed the memory space.
	 * @throws UncompatibleValuesException 
	 * @throws IllegalSizeException 
	 */
	@Test
	public void testMagicSquareLargeNumber(){
		setupScenary1();
		try {
			@SuppressWarnings("unused")
			MagicSquare ms = new MagicSquare(MagicSquare.NORTH, MagicSquare.NORTHWEST, 200);
			fail();
		}catch (IllegalSizeException | UncompatibleValuesException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This test verify that the custom exception (IllegalSizeException) is working correctly and verify when a number is even.
	 * @throws UncompatibleValuesException 
	 * @throws IllegalSizeException 
	 */
	@Test
	public void testMagicSquareOddNumber(){
		setupScenary1();
		try {
			@SuppressWarnings("unused")
			MagicSquare ms = new MagicSquare(MagicSquare.NORTH, MagicSquare.NORTHWEST, 8);
			fail();
		}catch (IllegalSizeException | UncompatibleValuesException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This test verify that the custom exception (UncompatibleValues Exception) is working correctly <br>
	 * and verify when the starting point with the chosen address is not compatible.
	 * @throws UncompatibleValuesException 
	 * @throws IllegalSizeException 
	 */
	@Test
	public void testMagicSquareUncompatible(){
		setupScenary1();
		try {
			@SuppressWarnings("unused")
			MagicSquare ms = new MagicSquare(MagicSquare.NORTH, MagicSquare.SOUTHEAST, 7);
			fail();
		}catch (IllegalSizeException | UncompatibleValuesException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This test verify that the two custom exceptions (IllegalSizeException & UncompatibleValuesException) are working correctly <br>
	 * and verify when the starting point with the chosen address is not compatible. And verify when a number is even.
	 * @throws UncompatibleValuesException 
	 * @throws IllegalSizeException 
	 */
	@Test
	public void testMagicSquareUncompatibleIllegal(){
		setupScenary1();
		try {
			@SuppressWarnings("unused")
			MagicSquare ms = new MagicSquare(MagicSquare.NORTH, MagicSquare.SOUTHEAST, 10);
			fail();
		}catch (IllegalSizeException | UncompatibleValuesException e) {
			System.out.println(e.getMessage());
		}
	}
		
}
