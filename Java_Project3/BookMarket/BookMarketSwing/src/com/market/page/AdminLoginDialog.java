package com.market.page;

import com.market.member.Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// 관리자 로그인 대화 상자 클래스 작성
public class AdminLoginDialog extends JDialog {
	JTextField pwField, idField;
	public boolean isLogin = false;
	
	public AdminLoginDialog(JFrame frame, String str) {
		super(frame, "관리자 로그인", true);
		
		Font ft;
		ft = new Font("함초롬돋움", Font.BOLD, 15);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screenSize.width - 400) / 2, (screenSize.height - 300) / 2);
		setSize(400, 300);
		setLayout(null);
		
		// 관리자 로그인 표시를 위한 패널 영역 설정 및 출력
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 20, 400, 50);
		add(titlePanel);
		
		JLabel titleLabel = new JLabel("관리자 로그인");
		titleLabel.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		titlePanel.add(titleLabel);
		
		// 아이디 표시를 위한 패널 영역 설정 및 출력
		JPanel idPanel = new JPanel();
		idPanel.setBounds(0, 70, 400, 50);
		add(idPanel);
		
		JLabel idLabel = new JLabel("아 이 디 : ");
		idLabel.setFont(ft);
		
		idField = new JTextField(10);
		idField.setFont(ft);
		idPanel.add(idLabel);
		idPanel.add(idField);
		
		// 비밀번호 표시를 위한 패널 영역 설정 및 출력
		JPanel pwPanel = new JPanel();
		pwPanel.setBounds(0, 120, 400, 50);
		add(pwPanel);
		
		JLabel pwLabel = new JLabel("비밀번호 : ");
		pwLabel.setFont(ft);
		
		pwField = new JTextField(10);
		pwField.setFont(ft);
		pwPanel.add(pwLabel);
		pwPanel.add(pwField);
		
		// <확인>, <취소> 버튼 표시를 위한 패널 영역 설정 및 출력
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 170, 400, 50);
		add(buttonPanel);
		
		JLabel okLabel = new JLabel("확인");
		okLabel.setFont(ft);
		
		JButton okButton = new JButton();
		okButton.add(okLabel);
		buttonPanel.add(okButton);
		
		// <확인> 버튼 클릭 이벤트 처리
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin admin = new Admin("", -1);
				System.out.println(pwField.getText() + idField.getText());
				System.out.println(admin.getID() + admin.getPassword());
				
				if(admin.getID().equals(idField.getText()) && admin.getPassword().equals(pwField.getText())) {
					isLogin = true;
					dispose();
				} else {
					JOptionPane.showMessageDialog(okButton, "관리자 정보가 일치하지 않습니다");
				}
			}
		});
		
		JLabel cancelLabel = new JLabel("취소");
		cancelLabel.setFont(ft);
		
		JButton cancelButton = new JButton();
		cancelButton.add(cancelLabel);
		buttonPanel.add(cancelButton);
		
		// 취소 버튼 클릭 이벤트 처리
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isLogin = false;
				dispose();
			}
		});
	}
}
