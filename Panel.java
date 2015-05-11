import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

/**
 * Creates the frame or the board for the GUI
 * @author Brian and Alex
 *
 */
public class Panel extends JFrame
{
	JPanel pane = new JPanel();
	public Panel()
	{
		super("Cellular Automata");
		setBounds(250,250,750,750);
	}
	
}
