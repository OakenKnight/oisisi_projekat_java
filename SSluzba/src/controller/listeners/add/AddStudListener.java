package controller.listeners.add;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.AddStudentFrame;
import view.TabbedPane;

public class AddStudListener implements MouseListener {
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(TabbedPane.getInstance().getSelectedIndex()==0) {
			AddStudentFrame diag = new AddStudentFrame();
		}
	}

	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
