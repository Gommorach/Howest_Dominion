package DominionFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Panel extends JPanel {
	
	private JButton btnSettings;
	private JLabel lblRes;
	private int[] width = {800,1280,1600,1920};
	private int[] height = {600,720,900,1080};
	public Panel()
	{
		createComponents();
		layoutComponents();
		addListeners();
	}
	private void createComponents()
	{
		btnSettings = new JButton("Settings");
		lblRes = new JLabel("Resolution");
	}
	private void layoutComponents()
	{
		setLayout(new FlowLayout());
		JPanel Settings = new JPanel();
		Settings.setLayout(new GridLayout(1,0));
		add(btnSettings,FlowLayout.RIGHT);
	}
	private void addListeners()
	{
		btnSettings.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
	}
}
