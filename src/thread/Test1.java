package thread;

public class Test1{
    public static void main(String[] args){

        CSD1 cs = new CSD1();
        CSD1 cs1 = new CSD1();
        Thread th1 = new Thread(cs);
        Thread th2 = new Thread(cs1);
        th1.start();
        th2.start();
    }

}

class CSD1 implements Runnable{

    public int a;

    public void run(){
        synchronized(this){ // 该对象锁就为cs
            a++;
            try{

                System.out.println("【当前线程】-----" + Thread.currentThread().getName() + "----a---" + a);
                Thread.sleep(5000);// 休眠5秒
            }
            catch(InterruptedException e){
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
