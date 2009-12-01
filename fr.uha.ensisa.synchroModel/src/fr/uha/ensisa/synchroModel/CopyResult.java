package fr.uha.ensisa.synchroModel;

import java.util.ArrayList;
import java.util.List;

public class CopyResult {
	private List<String> messages = null;
	private List<String> errors = null;
	private int lastProg = 0;
	
	protected CopyResult() {
	}
	
	public boolean hasError() {
		return this.getErrorNumber() != 0;
	}
	
	public int getErrorNumber() {
		return errors == null ? 0 : errors.size();
	}
	
	public void addError(String error) {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		this.errors.add(error);
		System.err.println(error);
	}
	
	public boolean hasMessages() {
		return this.getMessageNumber() != 0;
	}
	
	public int getMessageNumber() {
		return messages == null ? 0 : messages.size();
	}
	
	public void addMessage(String message) {
		if (this.messages == null) {
			this.messages = new ArrayList<String>();
		}
		this.messages.add(message);
		if (lastProg != 0) {
			System.out.println();
			lastProg = 0;
		}
		System.out.println(message);
	}
	
	public void printProgress(String message) {
		for(; lastProg > 0; lastProg--) {
			System.out.print('\b');
		}
		System.out.print(message);
		lastProg = message.length();
	}
}
