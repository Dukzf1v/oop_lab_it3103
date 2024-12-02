package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc(int id, String title, String category, float cost, String director, int length) {
		super(id, title, category, cost, director, length);
		nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		nbDigitalVideoDiscs++;
	}

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}