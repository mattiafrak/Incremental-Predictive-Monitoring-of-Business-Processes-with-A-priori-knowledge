import formula_verificator.FormulaVerificator;
import formula_verificator.FormulaVerificatorWithData;
import formula_verificator.Tester;
import py4j.GatewayServer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StackEntryPoint {

    FormulaVerificatorWithData verificator = new FormulaVerificatorWithData();

    public boolean isTraceViolated(String formula, ArrayList<String> trace){
        return FormulaVerificator.isTraceViolated(formula,trace);
    }

    // takes a declare model with the attributes of one trace and chekc whether the trace is violated
    public boolean isTraceWithDataViolated(String modelFile,
                                        String traceId,
                                        ArrayList<String> activities,
                                        ArrayList<String> groups,
                                        ArrayList<String> times) throws Exception{
        ArrayList<Date> times_final = new ArrayList<>();
        for (String time : times) {
            times_final.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time));
        }

        return verificator.verifyTrace(modelFile, traceId, activities, groups, times_final);
    }

    // Generates an XLog from the attributes of the trace at hand
    public void generateXLog(ArrayList<String> tracesId,
                             ArrayList<ArrayList<String>> activities,
                             ArrayList<ArrayList<String>> groups,
                             ArrayList<ArrayList<String>> times) throws Exception{
        ArrayList<ArrayList<Date>> times_final = new ArrayList<>();
        for (ArrayList<String> trace_times : times) {
            ArrayList<Date> trace_times_final = new ArrayList<>();
            for (String time : trace_times) {
                trace_times_final.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time));
            }
            times_final.add(trace_times_final);
        }
        org.processmining.plugins.declareanalyzer.Tester.generateXesLog(tracesId, activities, groups, times_final);
    }

    public static void main(String[] args) {
        System.out.println("Gateway Server not yet Started");
        StackEntryPoint app = new StackEntryPoint();
        // app is now the gateway.entry_point
        GatewayServer server = new GatewayServer(app);
        server.start();
        System.out.println("Gateway Server Started");
    }
}
