// public class MyApp extends Configured implements Tool {
// *     
// *       public int run(String[] args) throws Exception {
// *         // <code>Configuration</code> processed by <code>ToolRunner</code>
// *         Configuration conf = getConf();
// *         
// *         // Create a JobConf using the processed <code>conf</code>
// *         JobConf job = new JobConf(conf, MyApp.class);
// *         
// *         // Process custom command-line options
// *         Path in = new Path(args[1]);
// *         Path out = new Path(args[2]);
// *         
// *         // Specify various job-specific parameters     
// *         job.setJobName("my-app");
// *         job.setInputPath(in);
// *         job.setOutputPath(out);
// *         job.setMapperClass(MyMapper.class);
// *         job.setReducerClass(MyReducer.class);
// *
// *         // Submit the job, then poll for progress until the job is complete
// *         JobClient.runJob(job);
// *         return 0;
// *       }
// *       
// *       public static void main(String[] args) throws Exception {
// *         // Let <code>ToolRunner</code> handle generic command-line options 
// *         int res = ToolRunner.run(new Configuration(), new MyApp(), args);
// *         
// *         System.exit(res);
// *       }
// *     }