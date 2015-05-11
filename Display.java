import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/**
 * GUI Class with the rules for Conway's Game of Life
 * @author Brian and Alex
 */
public class Display extends JPanel
{
	Cell[][] cell;
	int row;
	int column;
	int rowCount;
	int colCount;
	int[][] neighbors;
	boolean[][] gameState;
	Panel panel;
	
	/**
	 * Constructs the display or the GUI and runs it with Conway's rules
	 */
	public Display()
	{
		row = 50;
		column = 50;
		rowCount = 0;
		colCount = 0;
		cell = new Cell[row][column];
		panel = new Panel();
		GridLayout Board = new GridLayout(row,column,1,1);
		panel.setLayout(Board);
		addCells();
		startCells();
		gameState = gameState();
		neighbors = numNeighbors();
		panel.setVisible(true);
		
		/**
		 * Refreshes the board
		 */
		ActionListener update = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				for (int i = 0; i < row; i++)
				{
					for (int j = 0; j < column; j++)
					{
						//The rules of the game depending if the cells are alive
						if (gameState[i][j] == true && neighbors[i][j] > 3)
						{
							cell[i][j].setDefault();
						}
						if (gameState[i][j] == true && neighbors[i][j] < 2)
						{
							cell[i][j].setDefault();
						}
						if(gameState[i][j] == false && neighbors[i][j] == 3)
						{
							cell[i][j].colorChange();
						}
					}
				}
				gameState = gameState();
				neighbors = numNeighbors();
			}
			
		};
		//Timer that repeats the update method that refreshes the screen
		Timer t = new Timer(8,update);
		t.setRepeats(true);
		t.start();
	}
	
	/**
	 * Counts the number of alive neighbors
	 * @param row of the specific cell
	 * @param column of the specific cell
	 * @return the number of cells that are alive around the designated cell
	 */
	public int numNeighbors(int row, int column)
	{
		int counter = 0;
		if (row - 1 >= 0 && column -1 >= 0)
		{
			if (cell[row-1][column-1].isAlive())
			{
				counter++;
			}
		}
		if (row - 1 >= 0)
		{
			if (cell[row-1][column].isAlive())
			{
				counter++;
			}
		}
		if (row - 1 >= 0 && column + 1 < this.column)
		{
			if (cell[row-1][column+1].isAlive())
			{
				counter++;
			}
		}
		if(column - 1 >= 0)
		{
			if (cell[row][column-1].isAlive())
			{
				counter++;
			}
		}
		if (column + 1 < this.column)
		{
			if (cell[row][column+1].isAlive())
			{
				counter++;
			}
		}
		if (row + 1 < this.row && column - 1 >= 0)
		{
			if (cell[row+1][column-1].isAlive())
			{
				counter++;
			}
		}
		if (row + 1 < this.row)
		{
			if (cell[row+1][column].isAlive())
			{
				counter++;
			}
		}
		if (row + 1 < this.row && column + 1 < this.column)
		{
			if (cell[row+1][column+1].isAlive())
			{
				counter++;
			}
		}
		return counter;
			
	}
	
	/**
	 * @return an array of numbers that has the counter for the number of neighbors each cell contains
	 */
	public int[][] numNeighbors()
	{
		int[][] neighbors = new int[row][column];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
			{
				neighbors[i][j] = numNeighbors(i,j);
			}
		}
		return neighbors;
	}
	
	/**
	 * checks if a specific cell will be dead or alive depending on neighbors
	 * @param row of the specific cell
	 * @param column of the specific cell
	 * @return true if Conway's conditions for death are obeyed
	 */
	public boolean death(int row, int column)
	{
		int neighbors = numNeighbors(row, column);
		if (cell[row][column].isAlive())
		{
			if (neighbors < 2 || neighbors > 3)
			{
				return true;
			}
			else if (neighbors == 2 || neighbors == 3)
			{
				return false;
			}
		}
		else if (!cell[row][column].isAlive() && neighbors == 3)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * Keeps track of all the cells on the board to see if they are dead or alive
	 * @return an array of the statuses of each cell
	 */
	public boolean[][] gameState()
	{
		boolean[][] state = new boolean[row][column];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
			{
				state[i][j] = death(i,j);
			}
		}
		return state;
	}
	
	/**
	 * Adds all of the dead cells onto the GUI board
	 */
	public void addCells()
	{
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
			{
				panel.add(cell[i][j] = new Cell(i,j,this));
			}
		}
	}
	
	/**
	 * Changes the state of specific cells to alive
	 */
	public void startCells()
	{
		//Original glider cells
		cell[5][5].colorChange();
		cell[5][6].colorChange();
		cell[6][5].colorChange();
		cell[6][6].colorChange();
		cell[5][9].colorChange();
		cell[5][10].colorChange();
		cell[6][9].colorChange();
		cell[6][10].colorChange();
		cell[7][9].colorChange();
		cell[7][10].colorChange();
		cell[3][14].colorChange();
		cell[4][14].colorChange();
		cell[8][14].colorChange();
		cell[9][14].colorChange();
		cell[4][15].colorChange();
		cell[5][15].colorChange();
		cell[6][15].colorChange();
		cell[7][15].colorChange();
		cell[8][15].colorChange();
		cell[5][16].colorChange();
		cell[6][16].colorChange();
		cell[7][16].colorChange();
		cell[6][17].colorChange();
		cell[1][31].colorChange();
		cell[2][31].colorChange();
		cell[6][31].colorChange();
		cell[7][31].colorChange();
		cell[3][32].colorChange();
		cell[4][32].colorChange();
		cell[5][32].colorChange();
		cell[2][33].colorChange();
		cell[6][33].colorChange();
		cell[3][34].colorChange();
		cell[5][34].colorChange();
		cell[4][35].colorChange();
		cell[3][39].colorChange();
		cell[4][39].colorChange();
		cell[3][40].colorChange();
		cell[4][40].colorChange();
		
		//random pattern
		for (int i = row * 3/4; i < row; i++)
		{
			for (int j = 0; j < column * 1/4; j++)
			{
				cell[i][j].colorChange();
			}
		}
	}
}
