package com.market.page;

import javax.swing.*;
import com.market.bookItem.Book;
import com.market.bookItem.BookInit;
import com.market.cart.Cart;
import com.market.cart.CartItem;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// 장바구니 상품 목록 보기 클래스 작성
public class CartItemListPage extends JPanel {
	
	JTable cartTable;
	Object[] tableHeader = { "도서ID", "도서명", "단가", "수량", "총가격" };
	
	Cart mCart = new Cart();
	public static int mSelectRow = -1;
	
	public CartItemListPage(JPanel panel, Cart cart) {
		Font ft;
		ft = new Font("함초롬돋움", Font.BOLD, 15);
		this.mCart = cart;
		this.setLayout(null);
		
		Rectangle rect = panel.getBounds();
		System.out.println(rect);
		this.setPreferredSize(rect.getSize());
		
		// 도서가 담긴 장바구니의 테이블 표시를 위한 패널 영역 설정 및 출력
		JPanel bookPanel = new JPanel();
		bookPanel.setBounds(0, 0, 1000, 400);
		add(bookPanel);
		
		ArrayList<CartItem> cartItem = mCart.getmCartItem();
		Object[][] content = new Object[cartItem.size()][tableHeader.length];
		Integer totalPrice = 0;
		for(int i = 0; i < cartItem.size(); i++) {
			CartItem item = cartItem.get(i);
			content[i][0] = item.getBookID();
			content[i][1] = item.getItemBook().getName();
			content[i][2] = item.getItemBook().getUnitPrice();
			content[i][3] = item.getQuantity();
			content[i][4] = item.getTotalPrice();
			totalPrice += item.getQuantity() * item.getItemBook().getUnitPrice();
		}
		
		cartTable = new JTable(content, tableHeader);
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setPreferredSize(new Dimension(600, 350));
		jScrollPane.setViewportView(cartTable);
		bookPanel.add(jScrollPane);
		
		// 총금액 표시를 위한 패널 영역 설정 및 출력
		JPanel totalPricePanel = new JPanel();
		totalPricePanel.setBounds(0, 400, 1000, 50);
		
		JLabel totalPriceLabel = new JLabel("총금액 : " + totalPrice + " 원");
		totalPriceLabel.setForeground(Color.red);
		totalPriceLabel.setFont(ft);
		totalPricePanel.add(totalPriceLabel);
		add(totalPricePanel);
		
		// <장바구니 비우기>, <장바구니의 항목 삭제하기>, <장바구니 새로 고침> 버튼 표시를 위한 패널 영역 설정 및 출력
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 450, 1000, 50);
		add(buttonPanel);
		
		JLabel buttonLabel = new JLabel("장바구니 비우기");
		buttonLabel.setFont(ft);
		
		JButton clearButton = new JButton();
		clearButton.add(buttonLabel);
		buttonPanel.add(clearButton);
		
		// <장바구니 비우기> 버튼의 클릭 이벤트 처리 작성
		// 해당 버튼을 클릭하면 장바구니에 담긴 모든 항목 삭제
		clearButton.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<CartItem> cartItem = cart.getmCartItem();
				if(cart.mCartCount == 0) {
					JOptionPane.showMessageDialog(clearButton, "장바구니에 항목이 없습니다");
				} else {
					int select = JOptionPane.showConfirmDialog(clearButton, "장바구니의 모든 항목을 삭제하겠습니가? ");
					if(select == 0) {
						TableModel tableModel = new DefaultTableModel(new Object[0][0], tableHeader);
						cartTable.setModel(tableModel);
						totalPriceLabel.setText("총금액 : " + 0 + " 원");
						JOptionPane.showMessageDialog(clearButton, "장바구니의 모든 항목을 삭제했습니다");
						cart.deleteBook();
					}
				}
			}
		});
		
		JLabel removeLabel = new JLabel("장바구니의 항목 삭제하기");
		removeLabel.setFont(ft);
		
		JButton removeButton = new JButton();
		removeButton.add(removeLabel);
		buttonPanel.add(removeButton);
		
		// 장바구니 목록 테이블의 마우스 클릭 이벤트 처리와 버튼 클릭 이벤트 처리 작성
		// 장바구니 목록 테이블의 행을 선택하면 해당 도서 이미지를 출력하고, <장바구니 항목 삭제하기>를 클릭하면 선택한 항목을 삭제
		removeButton.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				if(cart.mCartCount == 0) {
					JOptionPane.showMessageDialog(clearButton, "장바구니에 항목이 없습니다");
				} else if(mSelectRow == -1) {
					JOptionPane.showMessageDialog(clearButton, "장바구니에서 삭제할 항목을 선택");
				} else {
					ArrayList<CartItem> cartItem = cart.getmCartItem();
					cartItem.remove(mSelectRow);
					cart.mCartCount -= 1;
					Object[][] content = new Object[cartItem.size()][tableHeader.length];
					Integer totalPrice = 0;
					for(int i = 0; i < cartItem.size(); i++) {
						CartItem item = cartItem.get(i);
						content[i][0] = item.getBookID();
						content[i][1] = item.getItemBook().getName();
						content[i][2] = item.getItemBook().getUnitPrice();
						content[i][3] = item.getQuantity();
						content[i][4] = item.getTotalPrice();
						totalPrice += item.getQuantity() * item.getItemBook().getUnitPrice();
					}
					
					TableModel tableModel = new DefaultTableModel(content, tableHeader);
					totalPriceLabel.setText("총금액 : " + totalPrice + " 원");
					cartTable.setModel(tableModel);
					mSelectRow = -1;
				}
			}
		});
		
		// 장바구니 테이블의 행 선택에 대한 이벤트 처리
		cartTable.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int row = cartTable.getSelectedRow();
				mSelectRow = row;
			}
			
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
		
		JLabel refreshLabel = new JLabel("장바구니 새로 고침");
		refreshLabel.setFont(ft);
		
		JButton refreshButton = new JButton();
		refreshButton.add(refreshLabel);
		buttonPanel.add(refreshButton);
		
		// <장바구니 새로 고침> 버튼 클릭 이벤트 처리 작성
		refreshButton.addActionListener(new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<CartItem> cartItem = cart.getmCartItem();
				Object[][] content = new Object[cartItem.size()][tableHeader.length];
				Integer totalPrice = 0;
				for(int i = 0; i < cartItem.size(); i++) {
					CartItem item = cartItem.get(i);
					content[i][0] = item.getBookID();
					content[i][1] = item.getItemBook().getName();
					content[i][2] = item.getItemBook().getUnitPrice();
					content[i][3] = item.getQuantity();
					content[i][4] = item.getTotalPrice();
					totalPrice += item.getQuantity() * item.getItemBook().getUnitPrice();
				}
				
				TableModel tableModel = new DefaultTableModel(content, tableHeader);
				totalPriceLabel.setText("총금액 : " + totalPrice + " 원");
				cartTable.setModel(tableModel);
			}
		});
	}
}
