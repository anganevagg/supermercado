import java.util.ArrayList;
import javax.swing.*;

class Product{
	private float price;
	private int quantity;
	private String name;
	public Product(float price, int quantity, String name){
		this.price = price;
		this.quantity = quantity;
		this.name = name;
	}
	public float getTotal(){
		return price*quantity;
	}
	public String getName(){
		return name;
	}
	public int getQuantity(){
		return quantity;
	}
}

class Program{
	public static void main(String args[]){
		ArrayList<Product> products = new ArrayList<Product>();
		boolean flag = true;
		Product temp;
		String name;
		int quantity;
		float price;
		float total = 0;
		int selection;
		while(flag){
			total = 0;
			if(products.size()>0){
				selection = Integer.parseInt(JOptionPane.showInputDialog("1.- Agregar articulo\n2.- Mostrar el total\n3.- Eliminar articulo\n"));
			}
			else{
				selection = Integer.parseInt(JOptionPane.showInputDialog("1.- Agregar articulo\n2.- Mostrar el total"));
			}
			if(selection == 1){
				name=JOptionPane.showInputDialog("Ingresa el nombre del producto");
				price=Float.parseFloat(JOptionPane.showInputDialog("Ingresa precio"));
				quantity=Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad"));
				temp = new Product(price, quantity, name);
				products.add(temp);
				JOptionPane.showMessageDialog(null, String.format("Se agregaron %d %s(s) de %f", quantity, name, price));
			}
			else if(selection == 2){
				int counter = 1;
				String out = "";
				for(Product i : products){
					total+= i.getTotal();
					out += String.format("%d.- %s(%d) = %f\n", counter, i.getName(), i.getQuantity(), i.getTotal());
					counter++;
				}
				JOptionPane.showMessageDialog(null, String.format("%s\n Total = %f", out, total));
			}
			else if(selection == 3){
				String out="";
				int counter=0;
				for(Product i : products){
					out+=String.format("%d.- %s\n", counter+1, i.getName());
					counter++;
				}
				selection=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero del producto a eliminar\n"+out));
				selection-=1;
				products.remove(selection);
			}
			else{
				JOptionPane.showMessageDialog(null, "Adios");
				flag=false;
			}
		}
	}
}
