# ThroughputCal
This project is used to calculate the throughput of few standards under 802.11
To use this calculator, first write down the protocol, then the ideal throughput, and finally the standard.
e.g: UDP,54,802.11a

The calculator will then calculate the actual throughput, the throughput under best cases, and the time that will be consumed to transfer 10GB of data under normal case.

The difference between advertized data and actual data is caused by the consumption of time for sending requests, adding extensions, DIFS, SIFS, and Preamble.

However, better performance will lead to low capacity. Higher capacity means low robustness.
