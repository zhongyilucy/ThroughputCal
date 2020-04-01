import jdk.internal.cmm.SystemResourcePressureImpl;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.math.BigDecimal;
import java.util.*;

public class calculator {

    public static void main(String[] args){

        //encoding block sizes of 802.11a/g
        List<encodingBlockSize> listA = new ArrayList<>();
        listA.add(new encodingBlockSize(20, 1, 0.5, 48, 6));
        listA.add(new encodingBlockSize(20, 1,0.75,48,9));
        listA.add(new encodingBlockSize(20, 2, 0.5, 48, 12));
        listA.add(new encodingBlockSize(20, 2, 0.75, 48, 18));
        listA.add(new encodingBlockSize(20, 4, 0.5, 48, 24));
        listA.add(new encodingBlockSize(20, 4, 0.75, 48, 36));
        listA.add(new encodingBlockSize(20, 6, 0.67, 48, 48));
        listA.add(new encodingBlockSize(20, 6, 0.75, 48, 54));

        //common encoding block sizes of 802.11n/ac
        List<encodingBlockSize> listN = new ArrayList<>();
        listN.add(new encodingBlockSize(20, 1, 0.5, 52, 7.2));
        listN.add(new encodingBlockSize(20, 2, 0.5, 52, 14.4));
        listN.add(new encodingBlockSize(20, 2, 0.75, 52, 21.7));
        listN.add(new encodingBlockSize(20, 4, 0.5, 52, 28.9));
        listN.add(new encodingBlockSize(20, 4, 0.75, 52, 43.3));
        listN.add(new encodingBlockSize(20, 6, 0.67, 52, 57.8));
        listN.add(new encodingBlockSize(20, 6,0.75, 52,  65));
        listN.add(new encodingBlockSize(20, 6, 0.83, 52, 72.2));


        //Optional maximum data rates of 802.11n
        List<encodingBlockSize> listNOpt = listN;
        listNOpt.add(new encodingBlockSize(40, 6, 0.83, 108, 150));

        //encoding block sizes of 802.11ac
        List<encodingBlockSize> listAC = listN;
        listAC.add(new encodingBlockSize(20, 8, 0.75, 52, 86.7));
        listAC.add(new encodingBlockSize(20, 8, 0.83, 52, 96.3));

        //Optional maximum data rates of 802.11ac_w1
        List<encodingBlockSize> listACOpt1 = listAC;
        listACOpt1.add(new encodingBlockSize(40, 8, 0.83, 108, 96.3));
        listACOpt1.add(new encodingBlockSize(80, 8, 0.83, 234, 433.3));

        //Optional maximum data rates of 802.11ac_w2
        List<encodingBlockSize> listACOpt2 = listACOpt1;
        listACOpt2.add(new encodingBlockSize(160, 8, 0.83, 468, 866.7));

        //encoding block sizes of 802.11ax
        List<encodingBlockSize> listAX = new ArrayList<>();
        listAX.add(new encodingBlockSize(20, 1,0.5, 234, 8.6));
        listAX.add(new encodingBlockSize(20, 2, 0.5, 234, 17.2));
        listAX.add(new encodingBlockSize(20, 2, 0.85, 234, 25.8));
        listAX.add(new encodingBlockSize(20, 4, 0.5, 234, 34.4));
        listAX.add(new encodingBlockSize(20, 4, 0.75, 234, 51.6));
        listAX.add(new encodingBlockSize(20, 6, 0.67, 234, 68.8));
        listAX.add(new encodingBlockSize(20, 6, 0.75, 234, 77.4));
        listAX.add(new encodingBlockSize(20, 6, 0.83, 234, 86));
        listAX.add(new encodingBlockSize(20, 8, 0.75, 234, 103.2));
        listAX.add(new encodingBlockSize(20, 8, 0.83, 234, 129));
        listAX.add(new encodingBlockSize(20, 10, 0.75, 234, 129));
        listAX.add(new encodingBlockSize(20, 10, 0.83, 234, 143.4));

        //Optional maximum date rates of 802.11ax
        List<encodingBlockSize> listAXOpt = new ArrayList<>();
        listAXOpt.add(new encodingBlockSize(20, 1,0.5, 1960, 576.5));
        listAXOpt.add(new encodingBlockSize(20, 2, 0.5, 1960, 1152.9));
        listAXOpt.add(new encodingBlockSize(20, 2, 0.75, 1960, 1729.4));
        listAXOpt.add(new encodingBlockSize(20, 4, 0.5, 1960, 2305.9));
        listAXOpt.add(new encodingBlockSize(20, 4, 0.75, 1960, 3458.8));
        listAXOpt.add(new encodingBlockSize(20, 6, 0.67, 1960, 4611.8));
        listAXOpt.add(new encodingBlockSize(20, 6, 0.75, 1960, 5188.2));
        listAXOpt.add(new encodingBlockSize(20, 6, 0.83, 1960, 5764.7));
        listAXOpt.add(new encodingBlockSize(20, 8, 0.75, 1960, 6917.6));
        listAXOpt.add(new encodingBlockSize(20, 8, 0.83, 1960, 7686.3));
        listAXOpt.add(new encodingBlockSize(20, 10, 0.75, 1960, 8647.1));
        listAXOpt.add(new encodingBlockSize(20, 10, 0.83, 1960, 9607.8));

        //standards
        Set<Standard> standards = new HashSet<>();

        Standard a = new Standard("802.11a", listA, 1, 20,34, 20, 16, 14, 40, 14, 4, 42);
        Standard g = new Standard("802.11g", listA, 1, 20, 28, 20, 10, 14, 40, 14,4, 42);
        Standard n = new Standard("802.11n", listN, 1, 20, 34, 20, 16, 14, 40, 14, 3.6, 48);
        Standard nOpt = new Standard("802.11n max", listNOpt, 4, 46, 34, 20, 16, 14, 40, 14, 3.6, 48);
        Standard ac = new Standard("802.11ac", listAC, 1, 20, 34, 20, 16, 14, 40, 14, 3.6, 48);
        Standard ac_w1 = new Standard("802.11ac_w1", listACOpt1, 1, 56.8, 34, 20, 16, 14, 40, 14, 3.6, 48);
        Standard ac_w2 = new Standard("802.11ac_w2",listACOpt2, 1, 92.8, 34, 29, 16, 14, 40, 14, 3.6, 48);
        Standard ax = new Standard("802.11ax", listAX, 1, 20, 34, 20, 16, 14, 40, 14, 13.6, 48);
        Standard axOpt = new Standard("802.11ax max", listAXOpt, 8, 92.8, 34, 20, 16, 14, 40, 14, 13.6, 48);

        standards.add(a);
        standards.add(g);
        standards.add(n);
        standards.add(nOpt);
        standards.add(ac);
        standards.add(ac_w1);
        standards.add(ac_w2);
        standards.add(ax);
        standards.add(axOpt);


        //read the input from the user
        Scanner sc  = new Scanner(System.in);
        String input = sc.nextLine();
        String[] restrictions = input.split(",");
        String protocol = restrictions[0];
        String dataRate = restrictions[1];
        String standard = restrictions[2];

        //get the standard
        Standard target = null;
        for (Standard each : standards){
            if(each.getName().equals(standard)){
                target = each;
            }
        }

        //get the block size
        encodingBlockSize block = target.getSize(Double.parseDouble(dataRate));
        int nb = 0;
        double cr = 0;
        int nc = 0;
        int ss = 0;
        nb = block.getNBits();
        cr = block.getCRate();
        nc = block.getNChan();
        ss = target.getSpatialStreams();

        //calculate bitsPer symbol
        double BPSymbol = getBitsPerSymbol(nb,cr,nc,ss);
        double time = UDPTime(target,BPSymbol,1);

        //calculate the throughput
        double throughput = (1500*8)/time;
        BigDecimal bigDecimal = new BigDecimal(throughput);
        throughput = bigDecimal.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("The actual throughput:" + throughput);

        //compute the best cases
        double maxtime = 0;
        if(standard.equals("802.11n")){
            double maxbpsym = getBitsPerSymbol(block.getNBits(),block.getCRate(),108,4);
            if(protocol.equals("UDP")){
                maxtime = UDPTime(target,maxbpsym,1);
            }else{
                maxtime = TCPTime(target,maxbpsym,1);
            }
        }if(standard.equals("802.11ac_w1")){
            double maxbpsym = getBitsPerSymbol(block.getNBits(), block.getCRate(), 234, 3);
            if(protocol.equals("UDP")){
                maxtime = UDPTime(target,maxbpsym,1);
            }else{
                maxtime = TCPTime(target,maxbpsym,1);
            }
        }if(standard.equals("802.11ac_w2")){
            double maxbpsym = getBitsPerSymbol(block.getNBits(),block.getCRate(),468,8);
            if(protocol.equals("UDP")){
                maxtime = UDPTime(target,maxbpsym,1);
            }else{
                maxtime = TCPTime(target,maxbpsym,1);
            }
        }if(standard.equals("802.11ax")){
            target = axOpt;
            double maxbpsym = getBitsPerSymbol(block.getNBits(),block.getCRate(),1960,8);
            if(protocol.equals("UDP")){
                maxtime = UDPTime(target,maxbpsym,1);
            }else{
                maxtime = UDPTime(target,maxbpsym,1);
            }
        }else{
            maxtime = time;
        }

        //compute the throughput of best cases
        double maxthroughput = (1500*8)/maxtime;
        BigDecimal bigDecimal1 = new BigDecimal(maxthroughput);
        maxthroughput = bigDecimal1.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("The maximum throughput:" + maxthroughput);

        //compute the case of transferring 10GB
        int seg = 7158279;
        double tenTime = 0;
        if(protocol.equals("UDP")){
            tenTime = UDPTime(target,BPSymbol,7158279);
        }else{
            tenTime = TCPTime(target,BPSymbol,7158279);
        }
        System.out.println("The time used to transfer 10GB:"+String.valueOf(tenTime)+"microseconds");
    }

    public static double getBitsPerSymbol(int nb, double cr, int nc, int nss){
        return nb * cr * nc * nss;
    }

    public static double UDPTime(Standard s, double bps, int seg){
        double pre = s.getPreamble();
        int difs = s.getDIFS();
        double rts = s.getRTS();
        int sifs = s.getSIFS();
        double ack = s.getACK();
        double cts = s.getCTS();
        double trans = s.getTransRate();
        int macHeader = s.getMACHeader();

        //calculate the time in microsecond
        rts = Math.ceil((rts*8+6)/bps)*trans;
        ack = Math.ceil((ack*8+6)/bps)*trans;
        cts = Math.ceil((cts*8+6)/bps)*trans;
        double data = Math.ceil(((seg*1500+macHeader)*8+6)/bps)*trans;

        //add extension
        if(s.getName().equals("802.11g")){
            rts = rts+6;
            cts = cts+6;
            ack = ack+6;
            data = data+6;
        }

        double time = difs+pre+rts+sifs+pre+cts+sifs+pre+data+sifs+pre+ack;
        return time;
    }

    public static double TCPTime(Standard s, double bps, int seg){
        double pre = s.getPreamble();
        int difs = s.getDIFS();
        double rts = s.getRTS();
        int sifs = s.getSIFS();
        double ack = s.getACK();
        double cts = s.getCTS();
        double trans = s.getTransRate();
        int macHeader = s.getMACHeader();
        double tcpAck = s.getTCP_ACK();

        //calculate the time in microsecond
        rts = Math.ceil((rts*8+6)/bps)*trans;
        ack = Math.ceil((ack*8+6)/bps)*trans;
        cts = Math.ceil((cts*8+6)/bps)*trans;
        double data = Math.ceil(((seg*1500+macHeader)*8+6)/bps)*trans;
        tcpAck = Math.ceil(((tcpAck+macHeader)*8+6)/bps)*trans;

        //add extension
        if(s.getName().equals("802.11g")){
            rts = rts+6;
            cts = cts+6;
            ack = ack+6;
            data = data+6;
            tcpAck = tcpAck+6;
        }

        double time = difs+pre+rts+sifs+pre+cts+sifs+pre+data+sifs+pre+ack+difs+pre+rts+sifs+pre+cts+sifs+pre+tcpAck+sifs+pre+ack;
        return time;

    }
}
