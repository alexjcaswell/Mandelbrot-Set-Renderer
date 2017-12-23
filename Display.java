import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Display extends JFrame{

	
	private static final long serialVersionUID = 1L;

	BufferedImage image;
	int[] data;
	int width, height;
	
	public Display(int width, int height){
		this.width = width;
		this.height = height;
		this.setSize(width,height);
		this.setResizable(false);
		this.setTitle("FRACTALS MAN... LIKE WOAH");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		data = new int[width * height * 3];
		set(0,0,width,height,0);
	}
	
	public void render(){
		image.getRaster().setPixels(0, 0, width, height, data);
		getGraphics().drawImage(image, 0, 0, null);
	}

	public void set(int x, int y, int r, int g, int b){
		int loc = (x + y*width)*3;
		data[loc] = r;
		data[loc + 1] = g;
		data[loc + 2] = b;
	}
	
	public void set(int x, int y, int w, int h, int r, int g, int b){
		for(int xx = x; xx < x + w; xx ++){
			for(int yy = y; yy < y + h; yy ++){
				set(xx,yy,r,g,b);
			}
		}
	}
}
