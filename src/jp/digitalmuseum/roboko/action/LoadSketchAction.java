package jp.digitalmuseum.roboko.action;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;

import processing.app.RobokoSketch;

import jp.digitalmuseum.roboko.RobokoMain;
import jp.digitalmuseum.roboko.RobokoSettings;

public class LoadSketchAction extends AbstractAction {
	private static final long serialVersionUID = -5270448663489465136L;
	private RobokoMain robokoMain;

	public LoadSketchAction(RobokoMain robokoMain) {
		this.robokoMain = robokoMain;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileDialog fd = new FileDialog(
				robokoMain.getRobokoFrame(),
				"Open a Roboko sketch...",
				FileDialog.LOAD);
		fd.setDirectory(RobokoSettings.getProjectsFolderPath());
		fd.setVisible(true);

		String newParentDir = fd.getDirectory();
	    String newName = fd.getFile();

	    // user canceled selection
	    if (newName == null) return;

	    // check to make sure that this .pde file is
	    // in a folder of the same name
	    File parentFile = new File(newParentDir);
	    String parentName = parentFile.getName();
	    String pdeName = parentName + ".pde";
	    
	    try {
			RobokoSketch robokoSketch = new RobokoSketch(robokoMain,
					parentFile.getAbsolutePath() + File.separatorChar + pdeName);
		    robokoMain.setSketch(robokoSketch);
		} catch (IOException e1) {
			return;
		}
	}
}
