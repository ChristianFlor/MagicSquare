/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Icesi University (Cali - Colombia)
 * TIC Department- Algorithms and programming II
 * Five Lab
 * @Author: Christian Flor christian.flor1@correo.icesi.edu.co> 
 * @Date: 26 January 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

import customExceptions.IllegalSizeException;
import customExceptions.UncompatibleValuesException;

public class MagicSquare {
	// -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
	public final static String NORTH="NORTH";
	public final static String SOUTH="SOUTH";
	public final static String EAST="EAST";
	public final static String WEST="WEST";
	
	public final static String NORTHWEST="NORTHWEST";
	public final static String NORTHEAST="NORTHEAST";
	public final static String SOUTHWEST="SOUTHWEST";
	public final static String SOUTHEAST="SOUTHEAST";
	
	// -----------------------------------------------------------------
    // Atributes
    // -----------------------------------------------------------------
	private int[][] magicSquare;
	private String startPoint;
	private String direction;
	private int size;
	
	// -----------------------------------------------------------------
    // Builder
    // -----------------------------------------------------------------
	/**
	 * Builder for MagicSquare class.<br>
	 * It allows you to create a MagicSquare object that could be shown on screen<br>
	 * <b> pre: </b>  the integer for size has to be an odd number.
	 * <b> post: </b>  a magic square object could be initialized.
	 * @param startPoint indicates which point the magic square should start to be filled in.
	 * @param direction indicates the diagonal direction that the filling process should follow.
	 * @param size indicates the order for the magic square, it has to be an odd number.
	 * @throws UncompatibleValuesException 
	 * @throws IllegalSizeException 
	 */
	public MagicSquare(String startPoint, String direction, int size) throws IllegalSizeException, UncompatibleValuesException {
		if(size<1 || size > 100 || size%2 ==0) {
			throw new IllegalSizeException(size);
		}
		
		if(startPoint.equals(NORTH)) {
			if(direction.equals(SOUTHWEST) || direction.equals(SOUTHEAST)) {
				throw new UncompatibleValuesException(startPoint, direction);
			}
		}else if(startPoint.equals(SOUTH)){
			if(direction.equals(NORTHWEST) || direction.equals(NORTHEAST)) {
				throw new UncompatibleValuesException(startPoint, direction);
			}
		}else if(startPoint.equals(EAST)){
			if(direction.equals(NORTHWEST) || direction.equals(SOUTHWEST)) {
				throw new UncompatibleValuesException(startPoint, direction);
			}
		}else if(startPoint.equals(WEST)){
			if(direction.equals(SOUTHEAST) || direction.equals(NORTHEAST)) {
				throw new UncompatibleValuesException(startPoint, direction);
			}
		}
		this.startPoint=startPoint;
		this.direction=direction;
		this.size=size;
		this.magicSquare = new int[size][size];
		
	}
	
	// -----------------------------------------------------------------
    // Methods Atributes
    // -----------------------------------------------------------------
	/**
	 * This method return the initial position
	 * @return a matrix
	 */
	public int[][] getMagicSquare() {
		return magicSquare;
	}
	/**
	 * This method return the initial position
	 * @return a String of direction 
	 */
	public String getDirection() {
		return direction;
	}
	/**
	 * This method return the size
	 * @return a integer of the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * This method return the initial position
	 * @return a String with initial position
	 */
	public String getStartPoint() {
		return startPoint;
	}
	/**
	 * This method changes the matrix
	 * @param magicSquare
	 */
	public void setMagicSquare(int[][] magicSquare) {
		this.magicSquare = magicSquare;
	}
	/**
	 * This method changes the direction
	 * @param direction
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/**
	 * This method changes the size
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * This method changes the initial position
	 * @param startPoint
	 */
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
	
	// -----------------------------------------------------------------
    // Methods 
    // -----------------------------------------------------------------
	/**
	 * This method calculate the magic constant.
	 * @return a integer that magic constant
	 */
	public int magicConstant() {
		return (size*(size*size + 1))/2;
	}
	
	/**
	 * This method allows a MagicSquare object to fill the magicSquare integer matrix when it's created.<br>
	 * <b> pre: </b> all the attributes have to be initialized and contain correct values.
	 * <b> post: </b> every position in the magicSquare matrix will have its correspondent value.
	 */
	public void generate( ) {
		
		int rowMove = direction.equals("NORTHEAST") || direction.equals("NORTHWEST")?-1:1;
		int columnMove = direction.equals("SOUTHEAST") || direction.equals("SOUTHEAST")?1:-1;
		
		int[] up = {-1,0}, down = {1,0}, right = {0,1}, left = {0,-1};
		
		int[] correction = startPoint.equals("NORTH") ? down:startPoint.equals("WEST") ? right :
							startPoint.equals("SOUTH") ? up : left;

		int ini = 0;
		int i = startPoint.equals("WEST") || startPoint.equals("EAST") ? magicSquare.length/2
				: startPoint.equals("NORTH") ? 0: magicSquare.length-1;
		int j = startPoint.equals("NORTH") || startPoint.equals("SOUTH") ? magicSquare.length/2
				: startPoint.equals("WEST") ? 0: magicSquare.length-1;
		
		while(ini < size*size) {
			if(ini == 0) {
				ini++;
				magicSquare[i][j] = ini;
			}else {
				int initRow = i;
				int initColumn = j;
				
				i+= rowMove;
				j+= columnMove;
				
				if(i == -1) {
					i = magicSquare.length-1;
				}else if(i == magicSquare.length){
					i = 0;
				}
				if(j == -1) {
					j = magicSquare.length-1;
				}else if(j == magicSquare.length){
					j = 0;
				}
				ini++;
				if(magicSquare[i][j] == 0) {
					magicSquare[i][j] = ini;
				}else {
					i = initRow + correction[0];
					j = initColumn + correction[1];
					if(i == -1) {
						i = magicSquare.length;
					}
					else if(i == magicSquare.length){
						i = 0;
					}
					if(j == -1) {
						j = magicSquare.length;
					}
					else if(j == magicSquare.length){
						j = 0;
					}
					magicSquare[i][j] = ini;
				}
			}
		}
	}

}
