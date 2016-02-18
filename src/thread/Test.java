package thread;

public class Test{
    public static void main(String[] args){

        CSD cs = new CSD();
        Thread th1 = new Thread(cs);
        Thread th2 = new Thread(cs);
        th1.start();
        th2.start();
    }

}

class CSD implements Runnable{

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
