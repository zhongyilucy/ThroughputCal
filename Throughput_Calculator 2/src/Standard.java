import java.util.List;

public class Standard {

	private String name;
	private int spatialStreams;
	private List<encodingBlockSize> sizes;
	private double preamble;
	private int DIFS;
	private int RTS;
	private int SIFS;
	private double ACK;
	private int TCP_ACK;
	private int CTS;
	private double transRate;
	private int MACHeader;


	public Standard(String n, List<encodingBlockSize> s, int ss, double p, int difs, int rts, int sifs, double ack, int tcp_ack, int cts, double t, int m){
		name = n;
		sizes = s;
		spatialStreams = ss;
		preamble = p;
		DIFS = difs;
		RTS = rts;
		SIFS = sifs;
		ACK = ack;
		TCP_ACK = tcp_ack;
		CTS = cts;
		transRate = t;
		MACHeader = m;
	}

	public String getName(){
		return name;
	}


	public List<encodingBlockSize> getSizes() {
		return sizes;
	}

	public encodingBlockSize getSize(double dataRate){
		encodingBlockSize result = null;
		for(encodingBlockSize each : sizes){
			if(each.getDataRate() == dataRate){
				result = each;
			}
		}
		return result;

	}



	public int getSpatialStreams() {
		return spatialStreams;
	}

	public double getPreamble() {
		return preamble;
	}

	public int getDIFS() {
		return DIFS;
	}

	public int getRTS() {
		return RTS;
	}

	public int getSIFS() {
		return SIFS;
	}

	public double getACK() {
		return ACK;
	}

	public int getTCP_ACK() {
		return TCP_ACK;
	}

	public int getCTS() {
		return CTS;
	}

	public double getTransRate() {
		return transRate;
	}

	public int getMACHeader() {
		return MACHeader;
	}
}
