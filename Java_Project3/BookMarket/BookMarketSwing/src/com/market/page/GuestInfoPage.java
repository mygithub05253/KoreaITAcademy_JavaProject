package com.market.page;

import javax.swing.*;
import java.awt.*;
import com.market.member.UserInit;

// 고객 정보 확인 클래스 작성
public class GuestInfoPage extends JPanel {
	
	public GuestInfoPage(JPanel panel) {
		Font ft;
		ft = new Font("함초롬돋움", Font.BOLD, 15);
		
		setLayout(null);
		
		Rectangle rect = panel.getBounds();
		System.out.println(rect);
		setPreferredSize(rect.getSize());
		
		// 이름 표시를 위한 패널 영역 설정 및 출력
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 100, 1000, 50);
		add(namePanel);
		
		JLabel nameLabel = new JLabel("이  름 : ");
		nameLabel.setFont(ft);
		nameLabel.setBackground(Color.BLUE);
		
		JLabel nameField = new JLabel();
		// nameField.setText("입력된 고객 이름");
		nameField.setText(UserInit.getmUser().getName());
		nameField.setFont(ft);
		
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		// 연락처 표시를 위한 패널 영역 설정 및 출력
		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(0, 150, 1000, 100);
		add(phonePanel);
		
		JLabel phoneLabel = new JLabel("연락처 : ");
		phoneLabel.setFont(ft);
		
		JLabel phoneField = new JLabel();
		// phoneField.setText("입력된 고객 연락처");
		phoneField.setText(String.valueOf(UserInit.getmUser().getPhone()));
		phoneField.setFont(ft);
		
		phonePanel.add(phoneLabel);
		phonePanel.add(phoneField);
	}

}
