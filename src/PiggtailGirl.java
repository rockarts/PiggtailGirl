import java.awt.Rectangle;
import java.util.ArrayList;

public class PiggtailGirl {

	final int JUMPSPEED = -15;
	final int MOVESPEED = 5;

	private int centerX = 1;
	// Sprite is 48px center is about 24px. Ground is at 440px.
	private int centerY = 398;

	private boolean jumped = false;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean ducked = false;
	private boolean readyToFire = true;

	private static Background bg1 = StartingClass.getBg1();
	private static Background bg2 = StartingClass.getBg2();

	private int speedX = 0;
	private int speedY = 0;

	// Vertical
	//Rectangle(height, width, The X coordinate of the upper-left corner, The Y coordinate of the upper-left corner);
	public static Rectangle rect = new Rectangle(0, 0, 0, 0);
	public static Rectangle rect2 = new Rectangle(0, 0, 0, 0);
	// Hands
	//public static Rectangle rect3 = new Rectangle(0, 0, 0, 0);
	//public static Rectangle rect4 = new Rectangle(0, 0, 0, 0);
	//
	public static Rectangle yellowRed = new Rectangle(0, 0, 0, 0);

	//public static Rectangle footleft = new Rectangle(0, 0, 0, 0);
	//public static Rectangle footright = new Rectangle(0, 0, 0, 0);

	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public void update() {

		// Moves Character or Scrolls Background accordingly.
		if (speedX < 0) {
			centerX += speedX;
		}

		if (speedX == 0 || speedX < 0) {
			bg1.setSpeedX(0);
			bg2.setSpeedX(0);
		}

		if (centerX <= 200 && speedX > 0) {
			centerX += speedX;
		}

		//The background will move at 1/5 the character's speed.
		if (speedX > 0 && centerX > 200) {
			bg1.setSpeedX(-MOVESPEED / 5);
			bg2.setSpeedX(-MOVESPEED / 5);
		}

		// Updates Y Position
		centerY += speedY;

		// Handles Jumping
		speedY += 1;

		if (speedY > 3) {
			jumped = true;
		}

		// Prevents going beyond X coordinate of 0
		if (centerX + speedX <= 60) {
			centerX = 61;
		}

		//Rectangle(The X coordinate of the upper-left corner, 
		//The Y coordinate of the upper-left corner,
		//width, height);
		rect.setRect(centerX + 24, centerY + 28, 48, 30);
		rect2.setRect(centerX + 30, centerY + 32 , 15, 10);
		//rect2.setRect(rect.getX(), rect.getY() + 63, 32, 32);

		//rect3.setRect(rect.getX() - 26, rect.getY() + 32, 26, 20);
		//rect4.setRect(rect.getX() + 68, rect.getY() + 32, 26, 20);

		yellowRed.setRect(centerX - 110, centerY - 110, 180, 180);

		
		//footright.setRect(centerX, centerY + 20, 50, 15);
	}

	public void moveRight() {
		if (ducked == false) {
			speedX = MOVESPEED;
		}
	}

	public void moveLeft() {
		if (ducked == false) {
			speedX = -MOVESPEED;
		}
	}

	public void stopRight() {
		setMovingRight(false);
		stop();
	}

	public void stopLeft() {
		setMovingLeft(false);
		stop();
	}

	public void stop() {
		if (isMovingRight() == false && isMovingLeft() == false) {
			speedX = 0;
		}

		if (isMovingRight() == false && isMovingLeft() == true) {
			moveLeft();
		}

		if (isMovingRight() == true && isMovingLeft() == false) {
			moveRight();
		}
	}

	public void jump() {
		if (jumped == false) {
			speedY = JUMPSPEED;
			jumped = true;
		}

	}

	public void shoot() {
		if (readyToFire) {
			Projectile p = new Projectile(centerX + 24, centerY + 26);
			projectiles.add(p);
		}
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public boolean isJumped() {
		return jumped;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public boolean isDucked() {
		return ducked;
	}

	public void setDucked(boolean ducked) {
		this.ducked = ducked;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public ArrayList getProjectiles() {
		return projectiles;
	}

	public boolean isReadyToFire() {
		return readyToFire;
	}

	public void setReadyToFire(boolean readyToFire) {
		this.readyToFire = readyToFire;
	}
}