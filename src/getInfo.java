import inner.Product;
import inner.User;
import outer.ProductRW;
import outer.UserRW;

public class getInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserRW urw = new UserRW();
		System.out.println("Tipi\t\tUsername\tPassword\n" );
		ProductRW asd = new ProductRW();
		for(User x: urw.readEmp()) {
			System.out.println(x.getType()+"\t\t"+x.getUsername()+"\t\t"+x.getPassword());
		}
		
		System.out.println("-------------------------------------------------------");
		
		for(Product y: asd.readProd()) {
			System.out.println(y.getName()+"\t\t"+y.getCategory()+"\t\t"+y.getQuantity());
			
		}
	}
}