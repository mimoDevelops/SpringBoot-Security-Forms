package ca.sheridancollege.joshua.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
	private String name;
	private int rows;
	private int columns;
	private int yPos;
	private int xPos;
	private int numTurns;
	private double avgMoves;
	private double stanDev;
	
	

	public double getStanDev() {
		return stanDev;
	}


	public void setStanDev(double stanDev) {
		this.stanDev = stanDev;
	}


	public String getName() {
		return name;
	}


	public int getyPos() {
		return yPos;
	}


	public int getxPos() {
		return xPos;
	}


	public int getNumTurns() {
		return numTurns;
	}


	public double getAvgMoves() {
		return avgMoves;
	}





	public void setName(String name) {
		this.name = name;
	}


	public void setyPos(int yPos) {
		this.yPos = yPos;
	}


	public void setxPos(int xPos) {
		this.xPos = xPos;
	}


	public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}


	public void setAvgMoves(double avgMoves2) {
		this.avgMoves = avgMoves2;
	}



	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public void setColumns(int columns) {
		this.columns = columns;
	}
}
