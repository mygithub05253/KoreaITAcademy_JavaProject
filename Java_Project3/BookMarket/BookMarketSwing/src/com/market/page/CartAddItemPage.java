package com.market.page;

import javax.swing.*;
import com.market.bookItem.Book;
import com.market.bookItem.BookInit;
import com.market.cart.Cart;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// 장바구니에 항목 추가 클래스 작성
public class CartAddItemPage extends JPanel {
	
	ImageIcon imageBook;
	int mSelectRow = 0;
	
	Cart mCart;
	
	public CartAddItemPage(JPanel panel, Cart cart) {
		Font ft;
		ft = new Font("함초롬돋움", Font.BOLD, 15);
		
		setLayout(null);
		
		Rectangle rect = panel.getBounds();
		System.out.println(rect);
		setPreferredSize(rect.getSize());
		
		mCart = cart;
		
		// 도서 이미지 표시를 위한 패널 영역 설정 및 출력
		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(20, 0, 300, 400);
		imageBook = new ImageIcon("./images/ISBN1234.jpg");
		imageBook.setImage(imageBook.getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT));
		
		JLabel label = new JLabel(imageBook);
		imagePanel.add(label);
		add(imagePanel);
		
		// 도서 목록 테이블 표시를 위한 패널 영역 설정 및 출력
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(300, 0, 700, 400);
		add(tablePanel);
		
		ArrayList<Book> bookList = BookInit.getmBookList();
		Object[] tableHeader = { "도서ID", "도서명", "가격", "저자", "설명", "분야", "출판일" };
		Object[][] content = new Object[bookList.size()][tableHeader.length];
		
		for(int i = 0; i < bookList.size(); i++) {
			Book bookItem = bookList.get(i);
			content[i][0] = bookItem.getBookID();
			content[i][1] = bookItem.getName();
			content[i][2] = bookItem.getUnitPrice();
			content[i][3] = bookItem.getAuthor();
			content[i][4] = bookItem.getDescription();
			content[i][5] = bookItem.getCategory();
			content[i][6] = bookItem.getReleaseDate();	
		}
		
		JTable bookTable = new JTable(content, tableHeader);
		bookTable.setRowSelectionInterval(0, 0);
		bookTable.getSelectedColumn();
		
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new Dimension(600, 350));
		jScrollPane.setViewportView(bookTable);
		tablePanel.add(jScrollPane);
		
		// <장바구니에 담기> 버튼 표시를 위한 패널 영역 설정 및 출력
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 400, 1000, 400);
		add(buttonPanel);
		
		JLabel buttonLabel = new JLabel("장바구니에 담기");
		buttonLabel.setFont(ft);
		
		JButton addButton = new JButton();
		addButton.add(buttonLabel);
		buttonPanel.add(addButton);
		
		// 도서 목록 테이블의 마우스 클릭 이벤츠 처리와 버튼의 클릭 이벤트 처리 작성
		// 도서 목록 테이블의 행을 선택하면 해당 도서 이미지를 출력하고, <장바구니에 담기>를 클릭하면 선택한 도서 정보를 장바구니에 저장
		bookTable.addMouseListener(new MouseListener() {
			// 마우스 클릭 이벤트 처리
			public void mouseClicked(MouseEvent e) {
				int row = bookTable.getSelectedRow();
				int col = bookTable.getSelectedColumn();
				mSelectRow = row;
				Object value = bookTable.getValueAt(row, 0);
				String str = value + ".jpg";
				imageBook = new ImageIcon("./images/" + str);
				imageBook.setImage(imageBook.getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT));
				
				JLabel label = new JLabel(imageBook);
				imagePanel.removeAll();
				imagePanel.add(label);
				imagePanel.revalidate();
				imagePanel.repaint();
;			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		
		// <장바구니에 담기> 버튼 클릭 이벤트 처리
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Book> bookList = BookInit.getmBookList();
				int select = JOptionPane.showConfirmDialog(addButton, "장바구니에 추가하겠습니까?");
				if(select == 0) {
					int numID = mSelectRow;
					if(!isCartInBook(bookList.get(numID).getBookID())) {
						mCart.insertBook(bookList.get(numID));
					}
					JOptionPane.showMessageDialog(addButton, "추가했습니다");
				}
			}
		});
	}
	
	public boolean isCartInBook(String bookID) {
		return mCart.isCartInBook(bookID);
	}
}
