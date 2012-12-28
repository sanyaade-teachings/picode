package jp.digitalmuseum.roboko.ui;

import javax.swing.JFrame;

import com.phybots.gui.ImageProviderPanel;
import com.phybots.service.Camera;
import jp.digitalmuseum.roboko.RobokoMain;
import jp.digitalmuseum.roboko.action.CapturePoseAction;
import jp.digitalmuseum.roboko.action.StartPreviewAction;
import jp.digitalmuseum.roboko.action.StopPreviewAction;
import jp.digitalmuseum.roboko.ui.library.PoseManager;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class CaptureFrameAbstractImpl extends JFrame {
	private static final long serialVersionUID = -6546319871953483357L;

	private JButton btnStart;
	private JButton btnStop;

	private transient RobokoMain robokoMain;
	private transient boolean isClosing;

	public CaptureFrameAbstractImpl(RobokoMain robokoMain) {
		this.robokoMain = robokoMain;

		com.phybots.service.Camera camera = robokoMain.getCamera();
		PoseManager poseManager = robokoMain.getPoseManager();

		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel toolPanel = new JPanel();
		getContentPane().add(toolPanel, BorderLayout.NORTH);
		toolPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblCamera = new JLabel("Camera:");
		toolPanel.add(lblCamera);
		
		btnStart = new JButton();
		btnStart.setAction(new StartPreviewAction(camera));
		btnStart.setText("Start");
		toolPanel.add(btnStart);
		
		btnStop = new JButton();
		btnStop.setAction(new StopPreviewAction(camera));
		btnStop.setText("Stop");
		toolPanel.add(btnStop);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		toolPanel.add(separator);
		
		JLabel lblPose = new JLabel("Pose:");
		toolPanel.add(lblPose);
		
		JButton btnCapture = new JButton();
		btnCapture.setAction(new CapturePoseAction(poseManager));
		btnCapture.setText("Capture");
		toolPanel.add(btnCapture);
		
		JPanel imageProviderPanel = new com.phybots.gui.ImageProviderPanel(camera);
		getContentPane().add(imageProviderPanel, BorderLayout.CENTER);
		
		getContentPane().add(
				getConfigurationComponent(),
				BorderLayout.EAST);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				if (!isClosing) {
					CaptureFrameAbstractImpl.this.windowClosing();
				}
			}
		});
	}

	protected abstract JComponent getConfigurationComponent();

	@Override
	public void setVisible(boolean isVisible) {
		if (isVisible) {
			windowOpening();
		}
		super.setVisible(isVisible);
	}

	private void windowOpening() {
		((StartPreviewAction) btnStart.getAction()).actionPerformed(null);
		robokoMain.getRobot().setEditable(true);
		robokoMain.getRobokoFrame().setEnabled(false);
	}

	private void windowClosing() {
		((StopPreviewAction) btnStop.getAction()).actionPerformed(null);
		robokoMain.getRobot().setEditable(false);
		robokoMain.getRobokoFrame().setEnabled(true);
	}
}
