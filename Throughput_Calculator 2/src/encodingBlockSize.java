
public class encodingBlockSize {
	private int CWidth;
	private int NBits;
	private double CRate;
	private int NChan;
	private double dataRate;

	public encodingBlockSize(int cw, int nb, double c, int nc, double d){
		CWidth = cw;
		NBits = nb;
		CRate = c;
		NChan = nc;
		dataRate = d;
	}

	public int getNBits(){
		return NBits;
	}

	public double getCRate(){
		return CRate;
	}

	public int getNChan(){
		return NChan;
	}

	public double getDataRate(){
		return dataRate;
	}

	public int getCWidth() {
		return CWidth;
	}
}
