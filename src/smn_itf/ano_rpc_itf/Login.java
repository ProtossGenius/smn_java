package smn_itf.ano_rpc_itf;
//product by auto-code tools, you should never change it .
//author SureMoonNet

public interface Login {
	pb.ano_rpc_itf.Login_DoLogin_Ret DoLogin(String user, String pswd, long code);
	long[] Test1(String[] a, long[] b, long[] c, long[] d, int[] e);
	boolean Test2(String key, com.suremoon.net.Conn c);
}
