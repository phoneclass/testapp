package example.classphone;

public class Logbook implements Runnable {
	MainActivity mainActivity;
	public boolean running;

	public Logbook(MainActivity mainActivity) {
		// TODO Auto-generated constructor stub
		this.mainActivity = mainActivity;
		running = true;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (running) {
			if (mainActivity.Wifinf()) {
				mainActivity.disableWIFI();
				//mainActivity.enableAirplane();
				mainActivity.Counter++;
			}
			try {
				Thread.sleep((long)2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
