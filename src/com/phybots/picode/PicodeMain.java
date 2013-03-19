package com.phybots.picode;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingUtilities;
import processing.app.PicodeSketch;
import processing.app.SketchCode;
import processing.app.SketchException;

import com.phybots.Phybots;
import com.phybots.picode.api.Human;
import com.phybots.picode.api.PoseLibrary;
import com.phybots.picode.api.PoserLibrary;
import com.phybots.picode.builder.Builder;
import com.phybots.picode.ui.PicodeFrame;

public class PicodeMain {

	public static void main(String[] args) {
		new PicodeMain(args);
	}

	private ProcessingIntegration pintegration;

	private PicodeSettings settings;

	private PicodeSketch sketch;

	private PicodeFrame picodeFrame;

	private Builder builder;

	public PicodeMain(String[] args) {

		ProcessingIntegration.init();

		// Get parameters
		boolean debug = false;
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-debug")) {
				debug = true;
			}
		}
		if (debug) {
			Phybots.getInstance().showDebugFrame();
		}

		// Launch main UI
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				// Initialize GUI components.
				initGUI();
				PoseLibrary.getInstance().attachIDE(picodeFrame);
				PoserLibrary.getInstance().attachIDE(picodeFrame);

				// Load settings.
				settings = new PicodeSettings();
				if (!settings.load()) {

					// Add human instance by default.
					new Human("No name");
				}

				// Show the window.
				getFrame().setVisible(true);
			}
		});
	}

	private void initGUI() {

		picodeFrame = new PicodeFrame(this);
		loadSketch(PicodeSketch.newInstance(this));
		picodeFrame.setRunnable(true);

		Dimension d = new Dimension(840, 600);
		picodeFrame.setPreferredSize(d);
		picodeFrame.setSize(d);
		// picodeFrame.setDividerLocation(.5);
		picodeFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				PicodeMain.this.dispose();
				Phybots.getInstance().dispose();
				e.getWindow().dispose();
			}
		});
	}

	public void dispose() {

		// Save settings.
		if (settings != null) {
			settings.save();
		}

		// Disconnect from posers.
		PoserLibrary.getInstance().dispose();

		// If there's any building/running app, stop it.
		if (builder != null) {
			builder.stop();
		}
	}

	public ProcessingIntegration getPintegration() {
		if (pintegration == null) {
			pintegration = new ProcessingIntegration(this);
		}
		return pintegration;
	}

	public PicodeFrame getFrame() {
		return picodeFrame;
	}

	public void loadSketch(PicodeSketch sketch) {
		this.sketch = sketch;

		// Clear the editor.
		getFrame().clearEditors();
		for (int i = 0; i < sketch.getCodeCount(); i++) {
			SketchCode code = sketch.getCode(i);
			getFrame().addEditor(code);
		}

		// Update window title.
		getPintegration().updateTitle();
		// JViewport viewport = frame.getJScrollPane().getViewport();
		// int caret = editor.getCaretPosition();
		// editor.setCaretPosition(caret);
		// frame.getJScrollPane().setViewport(viewport);
	}

	public PicodeSketch getSketch() {
		return sketch;
	}

	public void runSketch() {
		picodeFrame.setRunnable(false);
		if (builder != null) {
			builder.stop();
		}

		// Hide capture frame before we run the app.
		PoserLibrary.getInstance().showCameraFrame(false);

		// Run the app.
		builder = new Builder(this, sketch);
		try {
			builder.run();
		} catch (SketchException se) {
			builder = null;
			picodeFrame.setRunnable(true);
			getPintegration().statusError(se);
		}
	}

	public void stopSketch() {
		if (builder != null) {
			builder.stop();
			builder = null;
			picodeFrame.setRunnable(true);
		}
	}

	public static Font getDefaultFont() {
		return Phybots.getInstance().getDefaultFont();
	}

}
