import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.JOptionPane;
/*<applet code=MyApplet45 width=400 height=400></applet>*/
public class MyApplet45 extends Applet implements ActionListener
{
	String s[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14"};
	Label l1;
	int size;
	Choice c1;
	Button b1;		
	public void init()
	{
		l1=new Label("Size");
		add(l1);
		c1=new Choice();
		for(String x:s)
		c1.add(x);
		add(c1);
		b1=new Button("OK");
		add(b1);	
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		size=Integer.parseInt(c1.getSelectedItem());
		MyFrame f1=new MyFrame(size);
		f1.start();
	}
	
}
class MyFrame extends Frame implements ActionListener
{
	String msg[]=new String[15];
	int b[]=new int[15];
	int s,s2=0;
	Button b2;
	TextField t2;
	HeapSort h1=new HeapSort();
	Label l2;
	Dimension d[]=new Dimension[15];
	MyFrame(int sz)
	{
		s=sz;	
		l2=new Label("Element");
		this.add(l2);
		t2=new TextField("0",3);
		this.add(t2);
		t2.setEditable(true);
		b2=new Button("Iterate");
		this.add(b2);
		this.setVisible(true);
		this.setSize(800,800);
		this.setLayout(new FlowLayout());
		b2.addActionListener(this);
		addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent we)	
		{
			dispose();
			
		}
				});
		d[0]=new Dimension(375,200);
		d[1]=new Dimension(175,270);
		d[2]=new Dimension(575,270);
		d[3]=new Dimension(75,350);   
		d[4]=new Dimension(275,350);
		d[5]=new Dimension(475,350);
		d[6]=new Dimension(675,350);
		d[7]=new Dimension(25,500);
		d[8]=new Dimension(125,500);
		d[9]=new Dimension(225,500);
		d[10]=new Dimension(325,500);
		d[11]=new Dimension(425,500);
		d[12]=new Dimension(525,500);
		d[13]=new Dimension(625,500);
		d[14]=new Dimension(725,500);





		
	}
	public void actionPerformed(ActionEvent e)
	{
		
		
		
		
		String str=e.getActionCommand();
		if(str=="Iterate" )
		{
			
			
			if(s2<s)
			{
				msg[s2]=t2.getText();
				s2++;
				for(int i=0;i<s2;i++)
				{
					if(msg[s2]==msg[i])
					{
						JOptionPane.showConfirmDialog(null, "Entered same element, Re-enter?", "Confirm",JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
    				}
				}
				
				for(int j=0;j<s2;j++)
					b[j]=Integer.parseInt(msg[j]);
				
				
							
				h1.sort(b);
				for(int i=0;i<s2;i++){
					msg[i]=String.valueOf(b[i]);
					
			}	
			repaint();
			}
			else
			{
				int response = JOptionPane.showConfirmDialog(null, "Entered excess elements, Re-sort?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.NO_OPTION) {
      
    } else if (response == JOptionPane.YES_OPTION) {
     dispose();			}
		}}
	}
	void start()
	{
		
	}
	int m=0;
	
	public void paint(Graphics g)
	{
		Font myFont=new Font("TimesRoman",Font.BOLD,30);
		g.setFont(myFont);
		for(int i=0;i<s2;i++)
			
		{	
			if(s!=15){	if(b[i]<10){	
			g.fillOval(d[i].width-10,d[i].height-25,35,35);}
				else{
			g.fillOval(d[i].width-10,d[i].height-30,50,50);}}
			else
			{
				if(b[i]<10){	
			g.fillOval(d[i].width-10,d[i].height-25,35,35);}
				else{
			g.fillOval(d[i].width-10,d[i].height-30,50,50);}}
			

				
			g.setColor(Color.WHITE);
			g.drawString(msg[i],d[i].width,d[i].height);
			g.setColor(Color.BLACK);
			g.drawLine(d[i].width,d[i].height,d[(i-1)/2].width,d[(i-1)/2].height);
		}
		m=300;
		g.drawString("Sorted Array:",100,600);
		for(String a:msg)
		{
			if(Integer.parseInt(a)<10){
			g.drawString(a,m+10,600);

			g.drawString(",",m+20,600);}
			else{
			g.drawString(a,m+40,600);
			g.drawString(",",m+65,600);}
			m=m+30;
		}
			
	}
	class HeapSort 
	{    
 private int[] a;
    private int n;
    private int left;
    private int right;
    private int largest;

    
    public void buildheap(int []a){
        n=s2-1;
        for(int i=n/2;i>=0;i--){
            minheap(a,i);
        }
    }
    
    public void minheap(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            minheap(a, largest);
        }
    }
    
    public void exchange(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
        }
    
    public void sort(int []a0){
        a=a0;
        buildheap(a);
        
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            minheap(a, 0);
        }
	for(int j=0;j<s;j++)
	b[j]=a[j];
    }
    
       }


}
		
