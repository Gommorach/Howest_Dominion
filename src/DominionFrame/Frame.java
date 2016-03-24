package DominionFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Frame extends JFrame {
	private int width = 800;
	private int height = 600;
    public static void main(String[] args) {
        new Frame();
    }
    
	public Frame()
	{
		setSize(this.width,this.height);
		setVisible(true);
		setTitle("Dominion");
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowOpened(WindowEvent e)
			{
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				int x = (dim.width - width)/2;
				int y = (dim.height - height)/2;
				setLocation(x,y);
			}
			@Override
			public void windowClosing(WindowEvent e)
			{
				int confirm = JOptionPane.showConfirmDialog(null,"Do you really want to quit the game","QUIT",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (confirm == JOptionPane.NO_OPTION)
				{
					setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				}
				else
				{
					dispose();
				}
			}
		});
		Container content = getContentPane();
		
	}

}
