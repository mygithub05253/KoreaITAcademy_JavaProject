package com.market.page;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.io.FileWriter;

// 관리자 클래스 작성
public class AdminPage extends JPanel {
	
	public AdminPage(JPanel panel) {
		Font ft;
		ft = new Font("함초롬돋움", Font.BOLD, 15);
		
		setLayout(null);
		
		Rectangle rect = panel.getBounds();
		System.out.println(rect);
		setPreferredSize(rect.getSize());
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddhhmmss");
		String strDate = formatter.format(date);
		
		// 도서ID 표시를 위한 패널 영역 설정 및 출력
		JPanel idPanel = new JPanel();
		idPanel.setBounds(100, 0, 700, 50);
		
		JLabel idLabel = new JLabel("도서ID : ");
		idLabel.setFont(ft);
		
		JLabel idTextField = new JLabel();
		idTextField.setFont(ft);
		idTextField.setPreferredSize(new Dimension(290, 50));
		idTextField.setText("ISBN" + strDate);
		idPanel.add(idLabel);
		idPanel.add(idTextField);
		add(idPanel);
		
		// 도서명 표시를 위한 패널 영역 설정 및 출력
		JPanel namePanel = new JPanel();
		namePanel.setBounds(100, 50, 700, 50);
		
		JLabel nameLabel = new JLabel("도서명 : ");
		nameLabel.setFont(ft);
		
		JTextField nameTextField = new JTextField(20);
		nameTextField.setFont(ft);
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		add(namePanel);
		
		// 가격 표시를 위한 패널 영역 설정 및 출력
		JPanel pricePanel = new JPanel();
		pricePanel.setBounds(100, 100, 700, 50);
		
		JLabel priceLabel = new JLabel("가  격 : ");
		priceLabel.setFont(ft);
		
		JTextField priceTextField = new JTextField(20);
		priceTextField.setFont(ft);
		pricePanel.add(priceLabel);
		pricePanel.add(priceTextField);
		add(pricePanel);
		
		// 저자 표시를 위한 패널 영역 설정 및 출력
		JPanel authorPanel = new JPanel();
		authorPanel.setBounds(100, 150, 700, 50);
		
		JLabel authorLabel = new JLabel("저  자 : ");
		authorLabel.setFont(ft);
		
		JTextField authorTextField = new JTextField(20);
		authorTextField.setFont(ft);
		authorPanel.add(authorLabel);
		authorPanel.add(authorTextField);
		add(authorPanel);
		
		// 설명 표시를 위한 패널 영역 설정 및 출력
		JPanel descPanel = new JPanel();
		descPanel.setBounds(100, 200, 700, 50);
		
		JLabel descLabel = new JLabel("설  명 : ");
		descLabel.setFont(ft);
		
		JTextField descTextField = new JTextField(20);
		descTextField.setFont(ft);
		descPanel.add(descLabel);
		descPanel.add(descTextField);
		add(descPanel);
		
		// 분야 표시를 위한 패널 영역 설정 및 출력
		JPanel categoryPanel = new JPanel();
		categoryPanel.setBounds(100, 250, 700, 50);
		
		JLabel categoryLabel = new JLabel("분  야 : ");
		categoryLabel.setFont(ft);
		
		JTextField categoryTextField = new JTextField(20);
		categoryTextField.setFont(ft);
		categoryPanel.add(categoryLabel);
		categoryPanel.add(categoryTextField);
		add(categoryPanel);
		
		// 출판일 표시를 위한 패널 영역 설정 및 출력
		JPanel datePanel = new JPanel();
		datePanel.setBounds(100, 300, 700, 50);
		
		JLabel dateLabel = new JLabel("출판일 : ");
		dateLabel.setFont(ft);
		
		JTextField dateTextField = new JTextField(20);
		dateTextField.setFont(ft);
		datePanel.add(dateLabel);
		datePanel.add(dateTextField);
		add(datePanel);
		
		// <추가>, <취소> 버튼 표시를 위한 패널 영역 설정 및 출력
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(100, 350, 700, 50);
		add(buttonPanel);
		
		JLabel okLabel = new JLabel("추가");
		okLabel.setFont(ft);
		
		JButton okButton = new JButton();
		okButton.add(okLabel);
		buttonPanel.add(okButton);
		
		// <추가> 버튼 클릭 이벤트 처리 작성
		okButton.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String[] writeBook = new String[7];
				writeBook[0] = idTextField.getText();
				writeBook[1] = nameTextField.getText();
				writeBook[2] = priceTextField.getText();
				writeBook[3] = authorTextField.getText();
				writeBook[4] = descTextField.getText();
				writeBook[5] = categoryTextField.getText();
				writeBook[6] = dateTextField.getText();
				
				try {
					FileWriter fw = new FileWriter("book.txt", true);
					
					for(int i = 0; i < 7; i++) {
						fw.write(writeBook[i] + "\n");
					}
					
					fw.close();
					JOptionPane.showMessageDialog(okButton, "새 도서 정보가 저장되었습니다");
					
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyMMddhhmmss");
					String strDate = formatter.format(date);
					
					idTextField.setText("ISBN" + strDate);
					nameTextField.setText("");
					priceTextField.setText("");
					authorTextField.setText("");
					descTextField.setText("");
					categoryTextField.setText("");
					dateTextField.setText("");
					
					System.out.println("새 도서 정보가 저장되었습니다.");
				} catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		
		JLabel noLabel = new JLabel("취소");
		noLabel.setFont(ft);
		
		JButton noButton = new JButton();
		noButton.add(noLabel);
		buttonPanel.add(noButton);
		
		// <취소> 버튼 클릭 이벤트 처리 작성
		noButton.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				nameTextField.setText("");
				priceTextField.setText("");
				authorTextField.setText("");
				descTextField.setText("");
				categoryTextField.setText("");
				dateTextField.setText("");
			}
		});
	}
}
