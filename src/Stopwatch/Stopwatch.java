package Stopwatch;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Stopwatch implements ActionListener {
	
	// global variables and objects
	
	JFrame frame = new JFrame();
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	
	int elapsedTime = 0; // milliseconds unit
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	
	// seconds, minutes, hours을 string으로 표현(00으로 시작)
	String seconds_string = String.format("%02d", seconds); 
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	// 1 second(value:1000)
	Timer timer = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			elapsedTime += 1000; // 1초 추가
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			
			seconds_string = String.format("%02d", seconds); 
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			
			timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
		}
	});
	
	boolean started = false;
	
	// Constructor
	Stopwatch(){
		
		// 시, 분, 초 Text
		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("IM혜민체", Font.PLAIN, 35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		// start/stop , reset 버튼
		startButton.setBounds(100,200,100,50);
		startButton.setFont(new Font("IM혜민체", Font.ITALIC, 20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		resetButton.setBounds(200,200,100,50);
		resetButton.setFont(new Font("IM혜민체", Font.ITALIC, 20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
	
		frame.add(timeLabel);
		frame.add(startButton);
		frame.add(resetButton);
		
		frame.setLocationRelativeTo(null); 
		frame.setTitle("My Stopwatch");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// startButton에 대한 action (started의 값에 따라 start/stop)
		if(e.getSource()==startButton) {
			if(started==false) {
				started=true;
				startButton.setText("STOP");
				start();
			}
			else {
				started=false;
				startButton.setText("START");
				stop();
			}
		}
		
		// resetButton에 대한 action
		if(e.getSource()==resetButton) {
			started=false;
			startButton.setText("START");
			reset();
		}
		
	}
	
	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}
	
	void reset() {
		timer.stop();
		// 모든 value를 0으로 재설정
		elapsedTime=0;
		minutes=0;
		hours=0;
		seconds=0;
		
		seconds_string = String.format("%02d", seconds); 
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		
		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
	}
	
}
