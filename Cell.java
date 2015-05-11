import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Creates a cell to be put in the grid
 * @author Brian and Alex
 *
 */
public class Cell extends JPanel
{
	private int row;
	private int column;
	private Display GUI;
	private Color color;
	
	/**
	 * Creates a cell
	 * @param row the Row the cell is in
	 * @param column the Column the cell is in
	 * @param GUI the interface
	 */
	public Cell(int row, int column, Display GUI)
	{
		this.row = row;
		this.column = column;
		this.GUI = GUI;
		this.color = Color.white;
		setBorder(new LineBorder(Color.black, 1));
		setBackground(color);
	}
	
	/**
	 * Changes the color to the desired color
	 */
	public void colorChange()
	{
		color = Color.black;
		setBackground(color);
	}
	
	/**
	 * @return the color of the cell
	 */
	public Color getColor()
	{
		return color;
	}
	
	/**
	 * Changes the color to white
	 */
	public void setDefault()
	{
		color = Color.white;
		setBackground(color);
	}
	
	/**
	 * @return true if the cell has been colored in and is alive
	 */
	public boolean isAlive()
	{
		if (getColor() == Color.black)
		{
			return true;
		}
		return false;
	}
}
