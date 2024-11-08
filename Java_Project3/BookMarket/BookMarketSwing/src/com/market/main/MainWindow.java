package com.market.main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.market.page.GuestInfoPage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.market.cart.Cart;
import com.market.bookItem.BookInit;
import com.market.page.CartAddItemPage;
import com.market.page.CartItemListPage;
import com.market.page.CartShippingPage;
import com.market.page.AdminPage;
import com.market.page.AdminLoginDialog;

// 메뉴 버튼 구성 클래스 작성
public class MainWindow extends JFrame {
	
	static Cart mCart;
	static JPanel mMenuPanel, mPagePanel;
	
	public MainWindow(String title, int x, int y, int width, int height) {
		initContainer(title, x, y, width, height);
		initMenu();
		setVisible(true);
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon("./images/shop.png").getImage());
	}
	
	// 메뉴 생성
	private void initMenu() {
		Font ft;
		ft = new Font("함초롬돋움", Font.BOLD, 15);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu01 = new JMenu("고객");
		menu01.setFont(ft);
		
		JMenuItem item01 = new JMenuItem("고객 정보");
		JMenuItem item11 = new JMenuItem("종료");
		menu01.add(item01);
		menu01.add(item11);
		menuBar.add(menu01);
		
		JMenu menu02 = new JMenu("상품");
		menu02.setFont(ft);
		
		JMenuItem item02 = new JMenuItem("상품 목록");
		menu02.add(item02);
		menuBar.add(menu02);
		
		JMenu menu03 = new JMenu("장바구니");
		menu03.setFont(ft);
		
		JMenuItem item03 = new JMenuItem("항목 추가");
		JMenuItem item04 = new JMenuItem("항목 수량 줄이기");
		JMenuItem item05 = new JMenuItem("항목 삭제하기");
		JMenuItem item06 = new JMenuItem("장바구니 비우기");
		menu03.add(item03);
		menu03.add(item04);
		menu03.add(item05);
		menu03.add(item06);
		menuBar.add(menu03);
		
		JMenu menu04 = new JMenu("주문");
		menu04.setFont(ft);
		
		JMenuItem item07 = new JMenuItem("영수증 표시");
		menu04.add(item07);
		menuBar.add(menu04);
		setJMenuBar(menuBar);
		
		// 메뉴 항목 처리하기
		// 고객 정보, 상품 목록, 종료 메뉴의 클릭 이벤트 작성
		item01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mPagePanel.removeAll();
				mPagePanel.add("고객 정보 확인", new GuestInfoPage(mPagePanel));
				add(mPagePanel);
				mPagePanel.revalidate();
			}
		});
		
		item02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mPagePanel.removeAll();
				BookInit.init();
				mPagePanel.add("장바구니에 항목 추가하기", new CartAddItemPage(mPagePanel, mCart));
				add(mPagePanel);
				mPagePanel.revalidate();
			}
		});
		
		item03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mPagePanel.removeAll();
				setVisible(false);
				new GuestWindow("고객 정보 입력", 0, 0, 1000, 750);
				add(mPagePanel);
				mPagePanel.revalidate();
			}
		});
	}
	
	private void initContainer(String title, int x, int y, int width, int height) {
		setTitle(title);
		setBounds(x, y, width, height);
		setLayout(null);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// 컴퓨터 화면에 맞춰서 프레임 창을 화면 중앙에 출력
		setLocation((screenSize.width - 1000) / 2, (screenSize.height - 750) / 2);
		
		// 메뉴 버튼 표시를 위한 프레임 상단의 패널 영역 설정 및 출력
		mMenuPanel = new JPanel();
		mMenuPanel.setBounds(0, 20, width, 130);
		menuIntroduction();
		add(mMenuPanel);
		
		// 메뉴 버튼별 클릭 시 페이지 표시를 위한 프레임 하단의 패널 영역 설정 및 출력
		mPagePanel = new JPanel();
		mPagePanel.setBounds(0, 150, width, height);
		add(mPagePanel);
	}
	
	// <장바구니 비우기> 버튼 클릭 이벤트 처리 관련 코드
	private void menuCartClear(JButton button) {
		if(mCart.mCartCount == 0) {
			JOptionPane.showMessageDialog(button, "장바구니에 항목이 없습니다"); 
		} else {
			int select = JOptionPane.showConfirmDialog(button, "장바구니의 모든 항목을 삭제하겠습니까? ");
				
			if(select == 0) {
				mCart.deleteBook();
				JOptionPane.showMessageDialog(button, "장바구니의 모든 항목을 삭제했습니다");
			}
		}
	}
	
	private void menuIntroduction() {
		
		mCart = new Cart();
		
		Font ft;
		ft = new Font("함초롬돋움", Font.BOLD, 15);
		
		// <고객 정보 확인하기> 버튼 표시를 위한 패널 영역 설정 및 출력
		JButton button1 = new JButton("고객 정보 확인하기", new ImageIcon("./images/1.png"));
		button1.setBounds(0, 0, 100, 50);
		button1.setFont(ft);
		mMenuPanel.add(button1);
		
		// <고객 정보 확인하기> 버튼 클릭 이벤트 처리 작성
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 패널에 표시된 구성 요소 전부 삭제
				mPagePanel.removeAll();
				mPagePanel.add("고객 정보 확인", new GuestInfoPage(mPagePanel));
				
				// 패널에 GuestInfoPage 내용 출력
				// 구성 요소의 가로세로 속성을 변경하여 호출
				mPagePanel.revalidate();
				// 구성 요소의 모양을 변경하여 호출
				mPagePanel.repaint();
			}
		});
		
		// <장바구니 상품 목록 보기> 버튼 표시를 위한 패널 영역 설정 및 출력
		JButton button2 = new JButton("장바구니 상품 목록 보기", new ImageIcon("./images/2.png"));
		button2.setBounds(0, 0, 100, 30);
		button2.setFont(ft);
		mMenuPanel.add(button2);
		
		// <장바구니 상품 목록 보기> 버튼 클릭 이벤트 처리 작성
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mCart.mCartCount == 0) {
					JOptionPane.showMessageDialog(button2, "장바구니에 항목이 없습니다", "장바구니 상품 목록 보기", JOptionPane.ERROR_MESSAGE);
				} else {
					mPagePanel.removeAll();
					mPagePanel.add("장바구니 상품 목록 보기", new CartItemListPage(mPagePanel, mCart));
					mPagePanel.revalidate();
					mPagePanel.repaint();
				}
			}
		});
		
		// <장바구니 비우기> 버튼 표시를 위한 패널 영역 설정 및 출력
		JButton button3 = new JButton("장바구니 비우기", new ImageIcon("./images/3.png"));
		button3.setBounds(0, 0, 100, 30);
		button3.setFont(ft);
		mMenuPanel.add(button3);
		
		// <장바구니 비우기> 버튼의 클릭 이벤트 처리 작성
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mCart.mCartCount == 0) {
					JOptionPane.showMessageDialog(button3, "장바구니에 항목이 없습니다", "장바구니 비우기", JOptionPane.ERROR_MESSAGE);
				} else {
					mPagePanel.removeAll();
					menuCartClear(button3);
					mPagePanel.add("장바구니 비우기", new CartItemListPage(mPagePanel, mCart));
					mPagePanel.revalidate();
					mPagePanel.repaint();
				}
			}
		});
		
		// <장바구니에 항목 추가하기> 버튼 표시를 위한 패널 영역 설정 및 출력
		JButton button4 = new JButton("장바구니에 항목 추가하기", new ImageIcon("./images/4.png"));
		button4.setFont(ft);
		mMenuPanel.add(button4);
		
		// <장바구니에 항목 추가하기> 버튼 클릭 이벤트 처리 작성
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mPagePanel.removeAll();
				BookInit.init();
				mPagePanel.add("장바구니에 항목 추가하기", new CartAddItemPage(mPagePanel, mCart));
				mPagePanel.revalidate();
				mPagePanel.repaint();
			}
		});
		
		// <장바구니의 항목 수량 줄이기> 버튼 표시를 위한 패널 영역 설정 및 출력
		JButton button5 = new JButton("장바구니의 항목 수량 줄이기", new ImageIcon("./images/5.png"));
		button5.setFont(ft);
		mMenuPanel.add(button5);
		
		// <장바구니의 항목 삭제하기> 버튼 표시를 위한 패널 영역 설정 및 출력
		JButton button6 = new JButton("장바구니의 항목 삭제하기", new ImageIcon("./images/6.png"));
		button6.setFont(ft);
		mMenuPanel.add(button6);
		
		// <장바구니의 항목 삭제하기> 버튼 클릭 이벤트 처리 작성
		// 해당 버튼을 클릭하면 장바구니 테이블에서 선택된 행 삭제
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mCart.mCartCount == 0) {
					JOptionPane.showMessageDialog(button3, "장바구니에 항목이 없습니다", "장바구니 비우기", JOptionPane.ERROR_MESSAGE);
				} else {
					mPagePanel.removeAll();
					CartItemListPage cartList = new CartItemListPage(mPagePanel, mCart);
					if(mCart.mCartCount == 0) {
						JOptionPane.showMessageDialog(button6, "장바구니에 항목이 없습니다");
					} else if(cartList.mSelectRow == -1) {
						JOptionPane.showMessageDialog(button6, "장바구니에서 삭제할 항목을 선택하세요");
					} else {
						mCart.removeCart(cartList.mSelectRow);
						
						// 장바구니에 선택 항목 삭제하기
						cartList.mSelectRow = -1;
					}
				}
				
				mPagePanel.add("장바구니의 항목 삭제하기", new CartItemListPage(mPagePanel, mCart));
				mPagePanel.revalidate();
				mPagePanel.repaint();
			}
		});
		
		// <주문하기> 버튼 표시를 위한 패널 영역 설정 및 출력
		JButton button7 = new JButton("주문하기", new ImageIcon("./images/7.png"));
		button7.setFont(ft);
		mMenuPanel.add(button7);
		
		// <주문하기> 버튼 클릭 이벤트 처리 작성
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mCart.mCartCount == 0) {
					JOptionPane.showMessageDialog(button7, "장바구니에 항목이 없습니다", "주문처리", JOptionPane.ERROR_MESSAGE);
				} else {
					mPagePanel.removeAll();
					mPagePanel.add("주문 배송지", new CartShippingPage(mPagePanel, mCart));
					mPagePanel.revalidate();
					mPagePanel.repaint();
				}
			}
		});
		
		// <종료> 버튼 표시를 위한 패널 영역 설정 및 출력
		JButton button8 = new JButton("종료", new ImageIcon("./images/8.png"));
		button8.setFont(ft);
		mMenuPanel.add(button8);
		
		// <종료> 버튼 클릭 이벤트 처리 작성
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(button8, "쇼핑몰을 종료하겠습니까? ");
				if(select == 0) {
					System.exit(1);
				}
			}
		});
		
		// <관리자> 버튼 표시를 위한 패널 영역 설정 및 출력
		JButton button9 = new JButton("관리자", new ImageIcon("./images/9.png"));
		button9.setFont(ft);
		mMenuPanel.add(button9);
		
		// <관리자> 버튼 클릭 이벤트 처리 작성
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLoginDialog adminDialog;
				JFrame frame = new JFrame();
				adminDialog = new AdminLoginDialog(frame, "관리자 로그인");
				adminDialog.setVisible(true);
				if(adminDialog.isLogin) {
					mPagePanel.removeAll();
					mPagePanel.add("관리자", new AdminPage(mPagePanel));
					mPagePanel.revalidate();
					mPagePanel.repaint();
				}
			}
		});
		
		// 메뉴 버튼 구성 프레임 처리하기
		// 프레임 닫기(x) 버튼의 클릭 이벤트 처리 작성
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				// 현재 프레임 감추기
				setVisible(false);
				new GuestWindow("고객 정보 입력", 0, 0, 1000, 750);
			}
		});
	}
}
