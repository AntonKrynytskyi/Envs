package pro.mrgr3n.env.info;

import java.io.IOException;
import java.util.List;


public class EnvsApp {

    public static final String HEADER_MSG = "|>>>>CQ/AEM.size=[%d]";
    public static final String FOOTER_MSG = "|>>>>>>>>>>[%d]";

    public static void main(String[] args) throws IOException {
        AemInstanceInfoManager manager = new AemInstanceInfoManager();
        List<AemInstanceInfo> ameInstList = manager.find();
        printResult(ameInstList);
    }

    private static void printResult(List<AemInstanceInfo> ameInstList) {
        System.out.println(String.format(HEADER_MSG, ameInstList.size()));
        for (int i = 0; i < ameInstList.size(); i++) {
            System.out.println(String.format("|------>Env#%d:", (i + 1)));
            System.out.println("|>>>>>Pid=" + ameInstList.get(i).getPid());
            System.out.println("|>>>>Port=" + ameInstList.get(i).getPort());
            System.out.println("|>>>DebugPort=" + ameInstList.get(i).getDebugPort());
            System.out.println("|>>RunMods=" + ameInstList.get(i).getRunMods());
            System.out.println("|>Path=" + ameInstList.get(i).getPath() + "\n");

        }
        System.out.println(String.format(FOOTER_MSG, ameInstList.size()));

    }

}
