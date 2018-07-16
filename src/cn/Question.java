package cn;

public class Question {

	public int tid;
	public String question;
	public String optA;
	public String optB;
	public String optC;
	public String optD;
	public String answer;

	public Question() {

	}

	public Question(int tid, String question, String optA, String optB,
			String optC, String optD, String answer) {
		this.tid = tid;
		this.question = question;
		this.optA = optA;
		this.optB = optB;
		this.optC = optC;
		this.optD = optD;
		this.answer = answer;
	}

	public static void main(String[] args) {

	}

}
