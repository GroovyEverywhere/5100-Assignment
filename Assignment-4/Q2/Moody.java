package Assignment4;

public abstract class Moody {
	protected abstract String getMood();
	protected abstract void expressFeelings();
	
	public static void main(String args[]) {
		PsychiatristObject p = new PsychiatristObject();
		Moody s = new SadObject();
		Moody h = new HappyObject();
		p.examine(h);
		p.observe(h);
		System.out.println();
		p.examine(s);
		p.observe(s);
	}
	
	public void queryMood() {
		System.out.println("I feel " + this.getMood() + " today!");
	}
}
class SadObject extends Moody{
	String MoodReport = "Subject cries a lot.";
	@Override
	protected String getMood() {
		return "sad";
	}

	@Override
	protected void expressFeelings() {
		System.out.println("'wah' 'boo hoo' 'weep' 'sob' 'weep' ");
	}
	public String toString() {
		return MoodReport;
	}
	
	
}

class HappyObject extends Moody{
	String MoodReport = "Subject laughs a lot.";
	@Override
	protected String getMood() {
		return "happy";
	}

	@Override
	protected void expressFeelings() {
		System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
	}
	public String toString() {
		return MoodReport;
	}
	
}


class PsychiatristObject{
	public void examine(Moody m) {
		System.out.println("How are you feeling today?");
		m.queryMood();
		m.expressFeelings();
	}
	public void observe(Moody m) {
		System.out.println("Observation: " + m);
	}
}
