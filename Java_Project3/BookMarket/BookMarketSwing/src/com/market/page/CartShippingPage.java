package com.market.page;

import javax.swing.*;

import com.market.bookItem.BookInit;
import com.market.cart.Cart;
import com.market.member.UserInit;
import java.awt.event.ActionEvent;
import java.awt.*;

// 주문 배송지 입력 클래스 작성
public class CartShippingPage extends JPanel {
	
	Cart mCart;
	JPanel shippingPanel;
	JPanel radioPanel;
	
	public CartShippingPage(JPanel panel, Cart cart) {
		Font ft;
		ft = new Font("함초롬돋움", Font.BOLD, 15);
		
		setLayout(null);
		
		Rectangle rect = panel.getBounds();
		System.out.println(rect);
		this.setPreferredSize(rect.getSize());
		
		// 고객 정보 라디오버튼 선택 표시를 위한 패널 영역 설정 및 출력
		radioPanel = new JPanel();
		radioPanel.setBounds(300, 0, 700, 50);
		radioPanel.setLayout(new FlowLayout());
		add(radioPanel);
		
		JLabel radioLabel = new JLabel("배송받을 분은 고객 정보와 같습니까?");
		radioLabel.setFont(ft);
		
		JRadioButton radioOk = new JRadioButton("예");
		radioOk.setFont(ft);
		JRadioButton radioNo = new JRadioButton("아니요");
		radioNo.setFont(ft);
		
		radioPanel.add(radioLabel);
		radioPanel.add(radioOk);
		radioPanel.add(radioNo);
		
		// 배송지 입력, 영수증 표시를 위한 패널 영역 설정 및 출력
		shippingPanel = new JPanel();
		shippingPanel.setBounds(200, 50, 700, 500);
		shippingPanel.setLayout(null);
		add(shippingPanel);
		
		radioOk.setSelected(true);
		radioNo.setSelected(false);
		UserShippingInfo(true);
		
		this.mCart = cart;
		
		// <예> 라디오 버튼 클릭 이벤트 처리 작성
		radioOk.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(radioOk.isSelected()) {
					shippingPanel.removeAll();
					UserShippingInfo(true);
					shippingPanel.revalidate();
					shippingPanel.repaint();
					radioNo.setSelected(false);
				}
			}
		});
		
		// <아니요> 라디오 버튼 클릭 이벤트 처리 작성
		radioNo.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(radioNo.isSelected()) {
					shippingPanel.removeAll();
					UserShippingInfo(true);
					shippingPanel.revalidate();
					shippingPanel.repaint();
					radioOk.setSelected(false);
				}
			}
		});
	}
	
	public void UserShippingInfo(boolean select) {
		Font ft;
		ft = new Font("함초롬돋움", Font.BOLD, 15);
		
		// 고객명 표시를 위한 패널 영역 설정 및 출력
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 100, 700, 50);
		
		JLabel nameLabel = new JLabel("고객명 : ");
		nameLabel.setFont(ft);
		namePanel.add(nameLabel);
		
		JTextField nameLabel2 = new JTextField(15);
		nameLabel2.setFont(ft);
		if(select) {
			nameLabel2.setBackground(Color.LIGHT_GRAY);
			// nameLabel2.setText("입력된 고객 이름");
			nameLabel2.setText(UserInit.getmUser().getName());
		}
		namePanel.add(nameLabel2);
		shippingPanel.add(namePanel);
		
		// 연락처 표시를 위한 패널 영역 설정 및 출력
		JPanel phonePanel = new JPanel();
		phonePanel.setBounds(0, 150, 700, 50);
		
		JLabel phoneLabel = new JLabel("연락처 : ");
		phoneLabel.setFont(ft);
		phonePanel.add(phoneLabel);
		
		JTextField phoneLabel2 = new JTextField(15);
		phoneLabel2.setFont(ft);
		if(select) {
			phoneLabel2.setBackground(Color.LIGHT_GRAY);
			// phoneLabel2.setText("입력된 고객 연락처");
			phoneLabel2.setText(String.valueOf(UserInit.getmUser().getPhone()));
		}
		phonePanel.add(phoneLabel2);
		shippingPanel.add(phonePanel);
		
		// 배송지 표시를 위한 패널 영역 설정 및 출력
		JPanel addressPanel = new JPanel();
		addressPanel.setBounds(0, 200, 700, 50);
		
		JLabel label = new JLabel("배송지 : ");
		label.setFont(ft);
		addressPanel.add(label);
		
		JTextField addressText = new JTextField(15);
		addressText.setFont(ft);
		addressPanel.add(addressText);
		shippingPanel.add(addressPanel);
		
		// <주문 완료> 버튼 표시를 위한 패널 영역 설정 및 출력
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 300, 700, 100);
		
		JLabel buttonLabel = new JLabel("주문 완료");
		buttonLabel.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		
		JButton orderButton = new JButton();
		orderButton.add(buttonLabel);
		buttonPanel.add(orderButton);
		shippingPanel.add(buttonPanel);
		
		orderButton.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				radioPanel.removeAll();
				radioPanel.revalidate();
				radioPanel.repaint();
				shippingPanel.removeAll();
				shippingPanel.add("주문 배송지", new CartOrderBillPage(shippingPanel, mCart));
				mCart.deleteBook();
				shippingPanel.revalidate();
				shippingPanel.repaint();
			}
		});
	}
}
