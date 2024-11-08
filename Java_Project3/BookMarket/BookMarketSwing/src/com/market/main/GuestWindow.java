package com.market.main;

import javax.swing.*;
import java.awt.*;

// 고객 정보 입력 프레임 처리하기
import com.market.member.UserInit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 메인 프레임 화면 만들기
public class GuestWindow extends JFrame {
	
	public GuestWindow(String title, int x, int y, int width, int height) {
		initContainer(title, x, y, width, height);
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon("./images/shop.png").getImage());
	}
	
	private void initContainer(String title, int x, int y, int width, int height) {
		// 프레임 제목 설정
		setTitle(title);
		
		// 프레임 위치, 크기 설정
		setBounds(x, y, width, height);
		
		// 프레임 레이아웃 미설정
		setLayout(null);
		
		// 글꼴, 스타일, 크기 설정
		Font ft;
		ft = new Font("함초롬돋움", Font.BOLD, 15);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// 컴퓨터 화면에 맞춰서 프레임 창을 화면 중앙에 출력
		setLocation((screenSize.width - 1000) / 2, (screenSize.height - 750) / 2);
		
		// user.png 이미지 표시를 위한 패널 영역 설정 및 출력
		JPanel userPanel = new JPanel();
		userPanel.setBounds(0, 100, 1000, 256);
		
		ImageIcon imageIcon = new ImageIcon("./images/user.png");
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH));
		
		JLabel userLabel = new JLabel(imageIcon);
		userPanel.add(userLabel);
		add(userPanel);
		
		// -- 고객 정보를 입력하세요. -- 표시를 위한 패널 영역 설정 및 출력
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 350, 1000, 50);
		add(titlePanel);
		
		JLabel titleLabel = new JLabel("-- 고객 정보를 입력하세요 --");
		titleLabel.setFont(ft);
		titleLabel.setForeground(Color.BLUE);
		titlePanel.add(titleLabel);
		
		// 이름 표시를 위한 패널 영역 설정 및 출력
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 400, 1000, 50);
		add(namePanel);
		
		JLabel nameLabel = new JLabel("이  름 : ");
		nameLabel.setFont(ft);
		namePanel.add(nameLabel);
		
		JTextField nameField = new JTextField(10);
		nameField.setFont(ft);
		namePanel.add(nameField);
		
		// 연락처 표시를 위한 패널 영역 설정 및 출력
		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(0, 450, 1000, 50);
		add(phonePanel);
		
		JLabel phoneLabel = new JLabel("연락처 : ");
		phoneLabel.setFont(ft);
		phonePanel.add(phoneLabel);
		
		JTextField phoneField = new JTextField(10);
		phoneField.setFont(ft);
		phonePanel.add(phoneField);
		
		// <쇼핑하기> 버튼 표시를 위한 패널 영역 설정 및 출력
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 500, 1000, 100);
		add(buttonPanel);
		
		JLabel buttonLabel = new JLabel("쇼핑하기", new ImageIcon("images/shop.png"), JLabel.LEFT);
		buttonLabel.setFont(ft);
		
		JButton enterButton = new JButton();
		enterButton.add(buttonLabel);
		buttonPanel.add(enterButton);
		
		// 버튼의 클릭 이벤트 처리 작성
		// 고객 정보를 입력하면 다음 프레임을 호출하고, 입력하지 않으면 경고 창 출력
		// <쇼핑하기> 버튼의 클릭 이벤트 처리 작성
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel message = new JLabel("고객 정보를 입력하세요");
				// 대화 상자의 메시지 글꼴 설정
				message.setFont(ft);
				
				// 이름 또는 연락처를 입력하지 않았을 때 오류 메시지 대화상자 표시
				if(nameField.getText().isEmpty() || phoneField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(enterButton, message, "고객 정보", JOptionPane.ERROR_MESSAGE);
				} else {
					// 이름 또는 연락처를 입력했을 때 온라인 서점 프레임 생성 및 호출
					// 입력한 고객 정보 저장
					UserInit.init(nameField.getText(), Integer.parseInt(phoneField.getText()));
					
					// 대화상자 닫기
					dispose();
					
					// MainWindow 프레임 호출
					new MainWindow("온라인 서점", 0, 0, 1000, 750);
				}
			}
		});
	}

}
