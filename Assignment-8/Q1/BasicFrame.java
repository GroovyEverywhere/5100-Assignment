package Assignment8;

import java.awt.Container;

import javax.swing.JFrame;

public abstract class BasicFrame extends JFrame{
	public BasicFrame() {
		create();
		Container con = getContentPane();
		add(con);
		addListeners();
		makeItVisible();
	}

	public abstract void create();

	public abstract void add(Container con);

	public abstract void addListeners();

	public void makeItVisible() {
		setSize(600, 600);
		setVisible(true);
	}
}