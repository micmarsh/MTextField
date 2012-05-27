package javax.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.text.Document;
import javax.swing.text.JTextComponent;


public class MTextField extends JPasswordField {
	private boolean password;
	private boolean gray = false;
	private final char bullet = '\u2022';
	private final char noBullet = (char)0;
	private  String prompt = null;
	private final Listeners listener = new Listeners();
	
	
	
	public MTextField(){
		init();
	}
	public MTextField(Document doc, String txt, int columns){
		super(doc,txt,columns);
		init();
	}
	public MTextField(int columns) {
		super(columns);
		init();
	}
	public MTextField(String text){
		super(text);
		init();
	}
	public MTextField(String text, int columns){
		super(text,columns);
		init();
		
	}
	
	private void init(){
		setEchoChar(noBullet);
		setupListeners();
	}
	
	private void setupListeners(){
		addFocusListener(listener);
		addKeyListener(listener);
	}
	
	private void setGrayText(String text){
		setText(text);
		
		setForeground(Color.gray);

		gray = true;
		if(password)
			setEchoChar(noBullet);
	}
	
	public void setPrompt(String text){
		if(text.equals(""))
			prompt = null;
		else{
			prompt = text;	
			setGrayText(text);
		}
		
	}
	
	public void setHidden(boolean hidden){
		password = hidden;
		if(password && !gray)
			setEchoChar(bullet);
		else
			setEchoChar(noBullet);
	}
	
	@Override 
	public String getText(){
		return new String(getPassword());
	}
	
	public void disablePrompt(){
		if(gray)
			setText("");
		gray = false;
		prompt = null;
		
	}
	
	private class Listeners implements FocusListener,KeyListener{
	
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void focusLost(FocusEvent e) {
			if(prompt != null && getText().equals("") ){
				setGrayText(prompt);
			}
		}
		
		
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			if(gray){
				setText("");
				setForeground(Color.black);
				gray = false;
				if(password)
					setEchoChar(bullet);
			}
			
		}
	
		@Override
		public void keyReleased(KeyEvent arg0) {
			if( prompt != null && getText().equals("")){
				setGrayText(prompt);
				setCaretPosition(0);
			}
			
		}
	
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	@Override
	public void setSize(int width,int height){
		setMinimumSize(new Dimension(width,height));
		setMaximumSize(new Dimension(width,height));
		setPreferredSize(new Dimension(width,height));
	}
	
	@Override
	public Dimension getSize(){
		
		return getPreferredSize();
		
	}
	
	
}
