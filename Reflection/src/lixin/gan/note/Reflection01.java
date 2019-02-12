package lixin.gan.note;

public class Reflection01 {
	public static void main(String[] args) {
		
/*
 * ������ǰ��ʹ��new�ؼ��������������ʱ��JVM�����Ƚ���class���أ��������һ��ģ�ӣ�
 * ֮��ʹ��new�ؼ����������Ķ���֤����һ���ġ����ģ�ӱ�����class��������Ϣ���ṹ�����ԣ�
 * 
 * ������ʱ�������ڹ����У���Ҫʵ����������ʱ����δ֪�ģ���ͬ�������Ҫʵ������ͬ���ࣩ
 * ��ʱ������ϣ���ܶ�̬�Ĵ���������֣�Ȼ����ʵ��������࣬�����ǽ�����д��
 * 
 * һ����ֻ��Ӧһ��Class����Ҳ����˵��һ�����Ͷ�Ӧһ��class����
 */
		
		try {
			String path = "lixin.gan.orm.annotation.Person";
			Class clas1 = Class.forName(path);
			Class clas2 = Class.forName(path);
			System.out.println(clas1.hashCode() == clas2.hashCode()); // true
			// ˵���������������һ��Class����
			
			// ע�⣬������ͬ�����Ӧ��Class������ͬ������������ԣ��������Ԫ�����ͺ�ά����أ��볤���޹�
			int[] a1 = new int[10];
			int[] a2 = new int[20];
			int[][] a3 = new int[10][20];
			System.out.println(a1.getClass().hashCode() == a2.getClass().hashCode());  // true
			System.out.println(a1.getClass().hashCode() == a3.getClass().hashCode());  // false
			
			double[] d4 = new double[10];
			System.out.println(d4.getClass().hashCode() == a1.getClass().hashCode());  // false
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
