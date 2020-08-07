package test.mypac;

public class RemoconImpl implements Remocon{

	@Override
	public void up() {
		System.out.println("볼륨을 높여요");
	}

	@Override
	public void down() {
		System.out.println("볼륨을 낮춰요");
	}
}
