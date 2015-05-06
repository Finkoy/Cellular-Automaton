import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Display extends JPanel
{
	Cell[][] cell;
	int row;
	int column;
	int rowCount;
	int colCount;
	Panel panel;
	
	public Display()
	{
		row = 35;
		column = 35;
		rowCount = 0;
		colCount = 0;
		cell = new Cell[row][column];
		panel = new Panel();
		GridLayout Board = new GridLayout(row,column,1,1);
		panel.setLayout(Board);
		addCells();
		panel.setVisible(true);
		
		ActionListener draw = new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				cell[rowCount][colCount].colorChange();
				colCount++;
				if (colCount == column)
				{
					rowCount++;
					colCount = 0;
				}
				if (rowCount == row)
				{
					rowCount = 0;
				}
			}
			
		};
		Timer t = new Timer(1,draw);
		t.setRepeats(true);
		t.start();
	}
	
	private void addCells()
	{
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < column; j++)
			{
				panel.add(cell[i][j] = new Cell(i,j,this));
			}
		}
	}
}
