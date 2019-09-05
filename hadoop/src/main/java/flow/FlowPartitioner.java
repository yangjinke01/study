package flow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FlowPartitioner extends Partitioner<Text, FlowBean> {

    @Override
    public int getPartition(Text key, FlowBean value, int numPartitions) {
        String phoneNum = key.toString().substring(0, 3);

        int partitions = 4;

        if ("135".equals(phoneNum)) {
            partitions = 0;
        } else if ("136".equals(phoneNum)) {
            partitions = 1;
        } else if ("137".equals(phoneNum)) {
            partitions = 2;
        } else if ("138".equals(phoneNum)) {
            partitions = 3;
        }

        return partitions;
    }

}
