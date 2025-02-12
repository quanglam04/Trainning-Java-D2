package BT_10;

public class VietnamesePhone extends Phone {

	@Override
	public void insertContact(String name, String phone) {
		contacts.add(new Contact(name, phone));
		System.out.println("Thêm thành công vào danh sách");
		
	}

	@Override
	public void removeContact(String name) {
		for(Contact contact : contacts)
			if(contact.getName().equals(name))
			{
				contacts.remove(contact);
				System.out.println("Xóa thành công");
				return;
			}
		System.out.println("Liên hệ không có trong danh sách");
		return;
		
	}

	@Override
	public void updateContact(String name, String newPhone) {
		for(Contact contact : contacts)
			if(contact.getName().equals(name))
			{
				contact.setNumber(newPhone);
				System.out.println("Update liên hệ thành công");
				return;
			}
		System.out.println("Liên hệ cần update không có trong danh sách");
		return;
		
	}

	@Override
	public void searchContact(String name) {
		for(Contact contact : contacts)
			if(contact.getName().equals(name)) {
				System.out.println(contact.toString());
				return;
			}
		System.out.println("Không tìm thấy liên hệ");
		return;
	}
	@Override
	public void showAllContact() {
		for(Contact contact : contacts) {
			System.out.println(contact.toString());
		}
	}
	
}
