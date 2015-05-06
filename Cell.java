import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Creates a cell to be put in the grid
 * @author Brian
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
		this.color = Color.lightGray;
		setBorder(new LineBorder(Color.black, 1));
		setBackground(color);
	}
	
	/**
	 * Changes the color to the desired color
	 */
	public void colorChange()
	{
		color = Color.orange;
		setBackground(color);
	}
	
	public Color getColor()
	{
		return color;
	}
	
	/**
	 * Changes the color to light gray
	 */
	public void setDefault()
	{
		color = Color.lightGray;
		setBackground(color);
	}
}