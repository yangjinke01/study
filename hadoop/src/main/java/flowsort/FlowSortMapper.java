package flowsort;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlowSortMapper extends Mapper<LongWritable, Text, FlowBean, Text>{
	FlowBean bean = new FlowBean();
	Text v = new Text();
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		
		String[] fields = line.split("\t");
		
		long upFlow = Long.parseLong(fields[1]);
		long downFlow = Long.parseLong(fields[2]);
		
		bean.set(upFlow, downFlow);
		v.set(fields[0]);
		
		context.write(bean, v);
	}
}
